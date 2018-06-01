package hayaa.bussiness.service.core;

import hayaa.bussiness.service.model.Spu;
import hayaa.bussiness.service.model.SpuSearchPamater;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
interface SpuMapper {
    @Insert("insert into Spu(spuCode,name,title,defaultImg,content) values(#{spu.spuCode},#{spu.name},#{spu.title},#{spu.defaultImg},#{spu.content});")
    @Options(useGeneratedKeys = true, keyProperty = "spu.SpuId")
    void insert(@Param("spu") Spu spu);

    @Update("update Spu set spuId=#{spu.spuId},spuCode=#{spu.spuCode},name=#{spu.name},title=#{spu.title},defaultImg=#{spu.defaultImg},content=#{spu.content} where spuId=#{spu.SpuId}")
    Boolean update(@Param("spu") Spu spu);

    @Delete("delete from Spu where spuId in (${ids})")
    Boolean delete(@Param("ids") String ids);

    @Select("select * from Spu where SpuId =#{Id}")
    Spu get(int Id);

    List<Spu> getList(@Param("searchPamater") SpuSearchPamater searchPamater);
}