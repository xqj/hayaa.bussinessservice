package hayaa.bussiness.service.controller;

import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.basemodel.model.TransactionResult;
import hayaa.bussiness.service.ICustomService;
import hayaa.bussiness.service.model.Custom;
import hayaa.bussiness.service.model.CustomSearchPamater;
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
@RequestMapping(value = "/custom/", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*", allowCredentials = "true")
public class CustomController {
    @Autowired
    private ICustomService customService;

    @RequestMapping(value = "pager")
    public TransactionResult<GridPager<Custom>> GetPager(int page, int size) throws Exception {
        AssertHelper.AssertRangInt(page, 1, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(size, 1, Integer.MAX_VALUE);
        TransactionResult<GridPager<Custom>> result = new TransactionResult<GridPager<Custom>>();
        GridPagerPamater<CustomSearchPamater> pamater = new GridPagerPamater<>();
        CustomSearchPamater sp = new CustomSearchPamater();
        pamater.setSearchPamater(sp);
        pamater.setCurrent(page);
        pamater.setPageSize(size);
        GridPager<Custom> serviceReusult = customService.GetPager(pamater);
        if (serviceReusult.isActionResult() && serviceReusult.isHavingData()) {
            result.setData(serviceReusult);
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "get")
    public TransactionResult<Custom> Get(int id) throws Exception {
        AssertHelper.AssertRangInt(id, 1, Integer.MAX_VALUE);
        TransactionResult<Custom> result = new TransactionResult<Custom>();
        FunctionResult<Custom> serviceResult = customService.Get(id);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "list")
    public TransactionResult<List<Custom>> GetList() throws Exception {
        TransactionResult<List<Custom>> result = new TransactionResult<List<Custom>>();
        FunctionListResult<Custom> serviceResult = customService.GetList(new CustomSearchPamater());
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "add")
    public TransactionResult<Custom> Add(Custom info) throws Exception {
        AssertHelper.AssertRangInt(info.getCustomId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(info.getCustomPersonId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getNickName());
        AssertHelper.AssertStringNullorEmpty(info.getPhoto());
        AssertHelper.AssertRangInt(info.getGroup(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        TransactionResult<Custom> result = new TransactionResult<Custom>();
        FunctionResult<Custom> serviceResult = customService.Create(info);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "edit")
    public TransactionResult<Boolean> Edit(Custom info) throws Exception {
        AssertHelper.AssertRangInt(info.getCustomId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(info.getCustomPersonId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getNickName());
        AssertHelper.AssertStringNullorEmpty(info.getPhoto());
        AssertHelper.AssertRangInt(info.getGroup(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        TransactionResult<Boolean> result = new TransactionResult<Boolean>();
        FunctionOpenResult<Boolean> serviceResult = customService.UpdateByID(info);
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
        FunctionOpenResult<Boolean> serviceResult = customService.DeleteByID(ids);
        if (serviceResult.isActionResult()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }
}