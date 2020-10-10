package com.chuangxin.manage.dao;
import com.chuangxin.manage.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface UserDao {

@Select("select * from user where id =#{id}")
    User findById(@Param("id") Integer id);
@Insert("insert into user (id) values(#{id})")
    int insertId(@Param("id") Integer id);
@Delete("delete from user where id =#{id} ")
    void deleteUser(@Param("id") int id);

}

