package hayaa.bussiness.service.core;

import hayaa.bussiness.service.model.Sku;
import hayaa.bussiness.service.model.SkuSearchPamater;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
interface SkuMapper {
    @Insert("insert into Sku(spuId,name,title,price,total) values(#{sku.spuId},#{sku.name},#{sku.title},#{sku.price},#{sku.total});")
    @Options(useGeneratedKeys = true, keyProperty = "sku.SkuId")
    void insert(@Param("sku") Sku sku);

    @Update("update Sku set skuId=#{sku.skuId},spuId=#{sku.spuId},name=#{sku.name},title=#{sku.title},price=#{sku.price},total=#{sku.total} where skuId=#{sku.SkuId}")
    Boolean update(@Param("sku") Sku sku);

    @Delete("delete from Sku where skuId in (${ids})")
    Boolean delete(@Param("ids") String ids);

    @Select("select * from Sku where SkuId =#{Id}")
    Sku get(int Id);

    List<Sku> getList(@Param("searchPamater") SkuSearchPamater searchPamater);
}