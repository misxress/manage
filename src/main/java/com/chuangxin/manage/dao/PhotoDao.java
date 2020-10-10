package com.chuangxin.manage.dao;
import com.chuangxin.manage.model.Photo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
public interface PhotoDao {

    @Select("select * from photo where id =#{id}")
    Photo findById(@Param("id") String id);
    @Insert("insert into photo (id,address) values(#{id},#{address})")
    int insertPhoto(@Param("id") String id,@Param("address") String address);
    @Delete("delete from photo where id =#{id} ")
    void deletePhoto(@Param("id") String id);
}
