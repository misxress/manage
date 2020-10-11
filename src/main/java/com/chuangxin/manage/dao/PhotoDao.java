package com.chuangxin.manage.dao;
import com.chuangxin.manage.model.Photo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PhotoDao {

    @Select("select * from photo where id =#{id}")
    Photo findById(@Param("id") String id);

    @Insert("insert into photo (id,address,data) values(#{id},#{address},#{data})")
    void insert(@Param("id") String id, @Param("address") String address, @Param("data") byte[] data);

    @Delete("delete from photo where id =#{id} ")
    void delete(@Param("id") String id);
}
