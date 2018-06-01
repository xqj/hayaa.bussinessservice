package hayaa.bussiness.service.core;

import hayaa.bussiness.service.model.Order;
import hayaa.bussiness.service.model.OrderSearchPamater;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
interface OrderMapper {
    @Insert("insert into Order(orderCode,spuId,skuId,price,status) values(#{order.orderCode},#{order.spuId},#{order.skuId},#{order.price},#{order.status});")
    @Options(useGeneratedKeys = true, keyProperty = "order.OrderId")
    void insert(@Param("order") Order order);

    @Update("update Order set orderId=#{order.orderId},orderCode=#{order.orderCode},spuId=#{order.spuId},skuId=#{order.skuId},price=#{order.price},status=#{order.status} where orderId=#{order.OrderId}")
    Boolean update(@Param("order") Order order);

    @Delete("delete from Order where orderId in (${ids})")
    Boolean delete(@Param("ids") String ids);

    @Select("select * from Order where OrderId =#{Id}")
    Order get(int Id);

    List<Order> getList(@Param("searchPamater") OrderSearchPamater searchPamater);
}