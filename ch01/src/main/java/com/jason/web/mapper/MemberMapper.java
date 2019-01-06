package com.jason.web.mapper;

import org.apache.ibatis.annotations.*;

public interface MemberMapper {

    @Select("SELECT NOW()")
    String getTime();

    String getTime2();

//    @Insert("INSERT INTO user (id, age, name) VALUES (#{id}, #{age}, #{name})")
    int insertUser(@Param("id") int id, @Param("age") int age, @Param("name") String name);

    @Delete("truncate table user")
    int removeAll();
}
