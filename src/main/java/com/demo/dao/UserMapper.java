package com.demo.dao;

import com.demo.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

@SuppressWarnings("deprecation")
public interface UserMapper {

    @Insert("insert into t_users(name,age,state,createDate) values(#{name},#{age},#{state},#{createDate})")
    public int insertUser(UserEntity user);

    @Delete("update t_users set state='0' WHERE id =#{id} and state='1'")
    int deleteUser(UserEntity user);

    @Update("update t_users set name=#{name},age=#{age} WHERE id=#{id} and state='1'")
    int updateUser(UserEntity user);

    @Select("SELECT id,name,age,state,createDate from t_users where id = #{id} and state='1'")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "state", column = "state"),
            @Result(property = "createDate", column = "createDate") })
    UserEntity findById(int id);

    @Select("select id,name,age,state,createDate from t_users where state='1' ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "state", column = "state"),
            @Result(property = "createDate", column = "createDate") })
    public List<UserEntity> queryList();

}
