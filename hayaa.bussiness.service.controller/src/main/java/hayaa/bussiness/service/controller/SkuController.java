package hayaa.bussiness.service.controller;

import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.basemodel.model.TransactionResult;
import hayaa.bussiness.service.ISkuService;
import hayaa.bussiness.service.model.Sku;
import hayaa.bussiness.service.model.SkuSearchPamater;
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
@RequestMapping(value = "/sku/", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*", allowCredentials = "true")
public class SkuController {
    @Autowired
    private ISkuService skuService;

    @RequestMapping(value = "pager")
    public TransactionResult<GridPager<Sku>> GetPager(int page, int size) throws Exception {
        AssertHelper.AssertRangInt(page, 1, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(size, 1, Integer.MAX_VALUE);
        TransactionResult<GridPager<Sku>> result = new TransactionResult<GridPager<Sku>>();
        GridPagerPamater<SkuSearchPamater> pamater = new GridPagerPamater<>();
        SkuSearchPamater sp = new SkuSearchPamater();
        pamater.setSearchPamater(sp);
        pamater.setCurrent(page);
        pamater.setPageSize(size);
        GridPager<Sku> serviceReusult = skuService.GetPager(pamater);
        if (serviceReusult.isActionResult() && serviceReusult.isHavingData()) {
            result.setData(serviceReusult);
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "get")
    public TransactionResult<Sku> Get(int id) throws Exception {
        AssertHelper.AssertRangInt(id, 1, Integer.MAX_VALUE);
        TransactionResult<Sku> result = new TransactionResult<Sku>();
        FunctionResult<Sku> serviceResult = skuService.Get(id);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "list")
    public TransactionResult<List<Sku>> GetList() throws Exception {
        TransactionResult<List<Sku>> result = new TransactionResult<List<Sku>>();
        FunctionListResult<Sku> serviceResult = skuService.GetList(new SkuSearchPamater());
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "add")
    public TransactionResult<Sku> Add(Sku info) throws Exception {
        AssertHelper.AssertRangInt(info.getSkuId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(info.getSpuId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getName());
        AssertHelper.AssertStringNullorEmpty(info.getTitle());
        AssertHelper.AssertRangDouble(info.getPrice(), Double.MIN_VALUE, Double.MAX_VALUE);
        AssertHelper.AssertRangInt(info.getTotal(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        TransactionResult<Sku> result = new TransactionResult<Sku>();
        FunctionResult<Sku> serviceResult = skuService.Create(info);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "edit")
    public TransactionResult<Boolean> Edit(Sku info) throws Exception {
        AssertHelper.AssertRangInt(info.getSkuId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(info.getSpuId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getName());
        AssertHelper.AssertStringNullorEmpty(info.getTitle());
        AssertHelper.AssertRangDouble(info.getPrice(), Double.MIN_VALUE, Double.MAX_VALUE);
        AssertHelper.AssertRangInt(info.getTotal(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        TransactionResult<Boolean> result = new TransactionResult<Boolean>();
        FunctionOpenResult<Boolean> serviceResult = skuService.UpdateByID(info);
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
        FunctionOpenResult<Boolean> serviceResult = skuService.DeleteByID(ids);
        if (serviceResult.isActionResult()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }
}