package com.yc.springbootkhaomyblog.mapper;

import com.yc.springbootkhaomyblog.domain.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {
    @Select("select * from article order by createTime desc")
    List<Article> selectByNew();
    @Select("select * from article where id=#{id}")
    Article selectById(int id);
}
