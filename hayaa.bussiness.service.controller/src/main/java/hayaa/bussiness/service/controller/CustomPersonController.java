package hayaa.bussiness.service.controller;

import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.basemodel.model.TransactionResult;
import hayaa.bussiness.service.ICustomPersonService;
import hayaa.bussiness.service.model.CustomPerson;
import hayaa.bussiness.service.model.CustomPersonSearchPamater;
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
@RequestMapping(value = "/customPerson/", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*", allowCredentials = "true")
public class CustomPersonController {
    @Autowired
    private ICustomPersonService customPersonService;

    @RequestMapping(value = "pager")
    public TransactionResult<GridPager<CustomPerson>> GetPager(int page, int size) throws Exception {
        AssertHelper.AssertRangInt(page, 1, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(size, 1, Integer.MAX_VALUE);
        TransactionResult<GridPager<CustomPerson>> result = new TransactionResult<GridPager<CustomPerson>>();
        GridPagerPamater<CustomPersonSearchPamater> pamater = new GridPagerPamater<>();
        CustomPersonSearchPamater sp = new CustomPersonSearchPamater();
        pamater.setSearchPamater(sp);
        pamater.setCurrent(page);
        pamater.setPageSize(size);
        GridPager<CustomPerson> serviceReusult = customPersonService.GetPager(pamater);
        if (serviceReusult.isActionResult() && serviceReusult.isHavingData()) {
            result.setData(serviceReusult);
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "get")
    public TransactionResult<CustomPerson> Get(int id) throws Exception {
        AssertHelper.AssertRangInt(id, 1, Integer.MAX_VALUE);
        TransactionResult<CustomPerson> result = new TransactionResult<CustomPerson>();
        FunctionResult<CustomPerson> serviceResult = customPersonService.Get(id);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "list")
    public TransactionResult<List<CustomPerson>> GetList() throws Exception {
        TransactionResult<List<CustomPerson>> result = new TransactionResult<List<CustomPerson>>();
        FunctionListResult<CustomPerson> serviceResult = customPersonService.GetList(new CustomPersonSearchPamater());
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "add")
    public TransactionResult<CustomPerson> Add(CustomPerson info) throws Exception {
        AssertHelper.AssertRangInt(info.getCustomPersonId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getName());
        AssertHelper.AssertNull(info.getSex());
        AssertHelper.AssertNull(info.getBirthday());
        AssertHelper.AssertStringNullorEmpty(info.getCarID());
        TransactionResult<CustomPerson> result = new TransactionResult<CustomPerson>();
        FunctionResult<CustomPerson> serviceResult = customPersonService.Create(info);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "edit")
    public TransactionResult<Boolean> Edit(CustomPerson info) throws Exception {
        AssertHelper.AssertRangInt(info.getCustomPersonId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getName());
        AssertHelper.AssertNull(info.getSex());
        AssertHelper.AssertNull(info.getBirthday());
        AssertHelper.AssertStringNullorEmpty(info.getCarID());
        TransactionResult<Boolean> result = new TransactionResult<Boolean>();
        FunctionOpenResult<Boolean> serviceResult = customPersonService.UpdateByID(info);
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
        FunctionOpenResult<Boolean> serviceResult = customPersonService.DeleteByID(ids);
        if (serviceResult.isActionResult()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }
}