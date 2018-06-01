package hayaa.bussiness.service.controller;

import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.basemodel.model.TransactionResult;
import hayaa.bussiness.service.ISpuService;
import hayaa.bussiness.service.model.Spu;
import hayaa.bussiness.service.model.SpuSearchPamater;
import hayaa.common.AssertHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/spu/", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*", allowCredentials = "true")
public class SpuController {
    @Autowired
    private ISpuService spuService;

    @RequestMapping(value = "pager")
    public TransactionResult<GridPager<Spu>> GetPager(int page, int size) throws Exception {
        AssertHelper.AssertRangInt(page, 1, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(size, 1, Integer.MAX_VALUE);
        TransactionResult<GridPager<Spu>> result = new TransactionResult<GridPager<Spu>>();
        GridPagerPamater<SpuSearchPamater> pamater = new GridPagerPamater<>();
        SpuSearchPamater sp = new SpuSearchPamater();
        pamater.setSearchPamater(sp);
        pamater.setCurrent(page);
        pamater.setPageSize(size);
        GridPager<Spu> serviceReusult = spuService.GetPager(pamater);
        if (serviceReusult.isActionResult() && serviceReusult.isHavingData()) {
            result.setData(serviceReusult);
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "get")
    public TransactionResult<Spu> Get(int id) throws Exception {
        AssertHelper.AssertRangInt(id, 1, Integer.MAX_VALUE);
        TransactionResult<Spu> result = new TransactionResult<Spu>();
        FunctionResult<Spu> serviceResult = spuService.Get(id);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "list")
    public TransactionResult<List<Spu>> GetList() throws Exception {
        TransactionResult<List<Spu>> result = new TransactionResult<List<Spu>>();
        FunctionListResult<Spu> serviceResult = spuService.GetList(new SpuSearchPamater());
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "add")
    public TransactionResult<Spu> Add(Spu info) throws Exception {
        AssertHelper.AssertRangInt(info.getSpuId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getSpuCode());
        AssertHelper.AssertStringNullorEmpty(info.getName());
        AssertHelper.AssertStringNullorEmpty(info.getTitle());
        AssertHelper.AssertStringNullorEmpty(info.getDefaultImg());
        AssertHelper.AssertStringNullorEmpty(info.getContent());
        TransactionResult<Spu> result = new TransactionResult<Spu>();
        FunctionResult<Spu> serviceResult = spuService.Create(info);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "edit")
    public TransactionResult<Boolean> Edit(Spu info) throws Exception {
        AssertHelper.AssertRangInt(info.getSpuId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getSpuCode());
        AssertHelper.AssertStringNullorEmpty(info.getName());
        AssertHelper.AssertStringNullorEmpty(info.getTitle());
        AssertHelper.AssertStringNullorEmpty(info.getDefaultImg());
        AssertHelper.AssertStringNullorEmpty(info.getContent());
        TransactionResult<Boolean> result = new TransactionResult<Boolean>();
        FunctionOpenResult<Boolean> serviceResult = spuService.UpdateByID(info);
        if (serviceResult.isActionResult()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "del")
    public TransactionResult<Boolean> Delete(int id) throws Exception {
        AssertHelper.AssertRangInt(id, 1, Integer.MAX_VALUE);
        TransactionResult<Boolean> result = new TransactionResult<Boolean>();
        List<Integer> ids = new ArrayList<>();
        ids.add(id);
        FunctionOpenResult<Boolean> serviceResult = spuService.DeleteByID(ids);
        if (serviceResult.isActionResult()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }
}