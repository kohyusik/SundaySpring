package com.jason.web.mapper;

import org.apache.ibatis.annotations.Select;

public interface MemberMapper {

    @Select("SELECT NOW()")
    public String getTime();

    public String getTime2();
}
