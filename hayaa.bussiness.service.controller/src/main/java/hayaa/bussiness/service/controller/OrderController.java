package hayaa.bussiness.service.controller;

import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.basemodel.model.TransactionResult;
import hayaa.bussiness.service.IOrderService;
import hayaa.bussiness.service.model.Order;
import hayaa.bussiness.service.model.OrderSearchPamater;
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
@RequestMapping(value = "/order/", method = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*", allowCredentials = "true")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "pager")
    public TransactionResult<GridPager<Order>> GetPager(int page, int size) throws Exception {
        AssertHelper.AssertRangInt(page, 1, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(size, 1, Integer.MAX_VALUE);
        TransactionResult<GridPager<Order>> result = new TransactionResult<GridPager<Order>>();
        GridPagerPamater<OrderSearchPamater> pamater = new GridPagerPamater<>();
        OrderSearchPamater sp = new OrderSearchPamater();
        pamater.setSearchPamater(sp);
        pamater.setCurrent(page);
        pamater.setPageSize(size);
        GridPager<Order> serviceReusult = orderService.GetPager(pamater);
        if (serviceReusult.isActionResult() && serviceReusult.isHavingData()) {
            result.setData(serviceReusult);
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "get")
    public TransactionResult<Order> Get(int id) throws Exception {
        AssertHelper.AssertRangInt(id, 1, Integer.MAX_VALUE);
        TransactionResult<Order> result = new TransactionResult<Order>();
        FunctionResult<Order> serviceResult = orderService.Get(id);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "list")
    public TransactionResult<List<Order>> GetList() throws Exception {
        TransactionResult<List<Order>> result = new TransactionResult<List<Order>>();
        FunctionListResult<Order> serviceResult = orderService.GetList(new OrderSearchPamater());
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "add")
    public TransactionResult<Order> Add(Order info) throws Exception {
        AssertHelper.AssertRangInt(info.getOrderId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getOrderCode());
        AssertHelper.AssertRangInt(info.getSpuId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(info.getSkuId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertRangDouble(info.getPrice(), Double.MIN_VALUE, Double.MAX_VALUE);
        TransactionResult<Order> result = new TransactionResult<Order>();
        FunctionResult<Order> serviceResult = orderService.Create(info);
        if (serviceResult.isActionResult() && serviceResult.isHavingData()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @RequestMapping(value = "edit")
    public TransactionResult<Boolean> Edit(Order info) throws Exception {
        AssertHelper.AssertRangInt(info.getOrderId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertStringNullorEmpty(info.getOrderCode());
        AssertHelper.AssertRangInt(info.getSpuId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertRangInt(info.getSkuId(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        AssertHelper.AssertRangDouble(info.getPrice(), Double.MIN_VALUE, Double.MAX_VALUE);
        TransactionResult<Boolean> result = new TransactionResult<Boolean>();
        FunctionOpenResult<Boolean> serviceResult = orderService.UpdateByID(info);
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
        FunctionOpenResult<Boolean> serviceResult = orderService.DeleteByID(ids);
        if (serviceResult.isActionResult()) {
            result.setData(serviceResult.getData());
        } else {
            result.setCode(103);
            result.setMessage("暂无数据");
        }
        return result;
    }
}