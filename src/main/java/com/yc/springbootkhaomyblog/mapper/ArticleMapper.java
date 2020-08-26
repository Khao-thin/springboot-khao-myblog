package com.yc.springbootkhaomyblog.mapper;

import com.yc.springbootkhaomyblog.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {
    @Select("select * from article order by createTime desc")
    List<Article> selectByNew();
    @Select("select * from article where id=#{id}")
    Article selectById(int id);
    @Insert("insert into article values (#{id},#{author},#{title},#{content},"
            + "#{keyWords},#{description},#{categoryId},#{label},#{titleImgs},"
            + "#{status},now(),#{readCnt},#{agreeCnt})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")//返回自增值
    int insert(Article art);
}
