package com.yc.springbootkhaomyblog.mapper;

import com.yc.springbootkhaomyblog.domain.Category;
import org.apache.ibatis.annotations.Select;

public interface CategoryMapper {
    @Select("select * from category where id=#{id}")
    public Category selectById(int id);
}
