package com.chuangxin.manage.dao;
import com.chuangxin.manage.model.Sign;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



public interface SignDao {
    @Select("select * from sign where id =#{id}")
    Sign findById(@Param("id") String id);
    @Insert("insert into sign (id,address,uid,data) values(#{id},#{address},#{uid},#{data})")
    void insert(@Param("id") String id, @Param("address") String address,@Param("uid") int uid, @Param("data") byte[] data);
    @Delete("delete from sign where id =#{id} ")
    void delete(@Param("id") String id);
    @Update("update sign set (id,address,data) =(#{id},#{address},#{data}) where uid =#{uid}")
    void update(@Param("id") String id, @Param("address") String address, @Param("data") byte[] data,@Param("uid") int uid);

}
