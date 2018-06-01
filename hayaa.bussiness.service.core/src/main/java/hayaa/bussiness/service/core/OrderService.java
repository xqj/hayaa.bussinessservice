package hayaa.bussiness.service.core;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import hayaa.basemodel.model.FunctionListResult;
import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.basemodel.model.FunctionResult;
import hayaa.basemodel.model.GridPager.GridPager;
import hayaa.basemodel.model.GridPager.GridPagerPamater;
import hayaa.bussiness.service.IOrderService;
import hayaa.bussiness.service.model.Order;
import hayaa.bussiness.service.model.OrderSearchPamater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderService implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public FunctionResult<Order> Create(Order info) {
        FunctionResult<Order> r = new FunctionResult<Order>();
        orderMapper.insert(info);
        if (info.getOrderId() > 0) {
            r.setData(info);
        }
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> UpdateByID(Order info) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        r.setData(orderMapper.update(info));
        return r;
    }

    @Override
    public FunctionOpenResult<Boolean> DeleteByID(List<Integer> list) {
        FunctionOpenResult<Boolean> r = new FunctionOpenResult<Boolean>();
        String ids = list.toString().replace("[", "").replace("]", "");
        r.setData(orderMapper.delete(ids));
        return r;
    }

    @Override
    public GridPager<Order> GetPager(GridPagerPamater<OrderSearchPamater> gridPagerPamater) {
        PageHelper.orderBy("OrderId desc");
        Page pageInfo = PageHelper.startPage(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        List<Order> dalResult = orderMapper.getList(gridPagerPamater.getSearchPamater());
        GridPager<Order> r = new GridPager<>(gridPagerPamater.getCurrent(), gridPagerPamater.getPageSize());
        r.setData(dalResult);
        r.setTotal((int) pageInfo.getTotal());
        return r;
    }

    @Override
    public FunctionResult<Order> Get(int id) {
        FunctionResult<Order> r = new FunctionResult<Order>();
        r.setData(orderMapper.get(id));
        return r;
    }

    @Override
    public FunctionListResult<Order> GetList(OrderSearchPamater searchPamater) {
        FunctionListResult<Order> r = new FunctionListResult<Order>();
        r.setData(orderMapper.getList(searchPamater));
        return r;
    }
}