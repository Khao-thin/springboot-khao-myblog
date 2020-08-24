package com.yc.springbootkhaomyblog.mapper;

import com.yc.springbootkhaomyblog.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("insert into user(name,account,pwd,phone,email,head,createTime,status,type) " +
            "values (#{name},#{account},#{pwd},#{phone},#{email},#{head},#{createTime},#{status},#{type})")
    int insert(User user);

    @Select("select * from user where account=#{account} and pwd=#{pwd}")
    User selectByLogin(User user);

    @Select("select count(*) from user where account=#{account}")
    int countByAccount(String account);
}
