package hayaa.bussiness.service.core;

import hayaa.bussiness.service.model.Custom;
import hayaa.bussiness.service.model.CustomSearchPamater;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
interface CustomMapper {
    @Insert("insert into Custom(customPersonId,nickName,photo,group) values(#{custom.customPersonId},#{custom.nickName},#{custom.photo},#{custom.group});")
    @Options(useGeneratedKeys = true, keyProperty = "custom.CustomId")
    void insert(@Param("custom") Custom custom);

    @Update("update Custom set customId=#{custom.customId},customPersonId=#{custom.customPersonId},nickName=#{custom.nickName},photo=#{custom.photo},group=#{custom.group} where customId=#{custom.CustomId}")
    Boolean update(@Param("custom") Custom custom);

    @Delete("delete from Custom where customId in (${ids})")
    Boolean delete(@Param("ids") String ids);

    @Select("select * from Custom where CustomId =#{Id}")
    Custom get(int Id);

    List<Custom> getList(@Param("searchPamater") CustomSearchPamater searchPamater);
}