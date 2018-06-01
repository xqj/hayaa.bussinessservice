package hayaa.bussiness.service.core;

import hayaa.bussiness.service.model.CustomPerson;
import hayaa.bussiness.service.model.CustomPersonSearchPamater;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
interface CustomPersonMapper {
    @Insert("insert into CustomPerson(name,sex,birthday,carID) values(#{customPerson.name},#{customPerson.sex},#{customPerson.birthday},#{customPerson.carID});")
    @Options(useGeneratedKeys = true, keyProperty = "customPerson.CustomPersonId")
    void insert(@Param("customPerson") CustomPerson customPerson);

    @Update("update CustomPerson set customPersonId=#{customPerson.customPersonId},name=#{customPerson.name},sex=#{customPerson.sex},birthday=#{customPerson.birthday},carID=#{customPerson.carID} where customPersonId=#{customPerson.CustomPersonId}")
    Boolean update(@Param("customPerson") CustomPerson customPerson);

    @Delete("delete from CustomPerson where customPersonId in (${ids})")
    Boolean delete(@Param("ids") String ids);

    @Select("select * from CustomPerson where CustomPersonId =#{Id}")
    CustomPerson get(int Id);

    List<CustomPerson> getList(@Param("searchPamater") CustomPersonSearchPamater searchPamater);
}