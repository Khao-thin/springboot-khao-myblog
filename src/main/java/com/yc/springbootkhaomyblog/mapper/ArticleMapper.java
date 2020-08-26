package com.yc.springbootkhaomyblog.mapper;

import com.yc.springbootkhaomyblog.domain.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleMapper {
    @Select("select * from article order by createTime desc")
    @Results(id="rmAm", value={
            @Result(id = true, column = "id", property = "id"), // 缓存性能优化用到
            @Result(column = "categoryId", property = "categoryId"), // 缓存性能优化用到
            @Result(
                    column = "categoryId",
                    property = "category",
                    one=@One(select="com.yc.springbootkhaomyblog.mapper.CategoryMapper.selectById"))
    })
    List<Article> selectByNew();

    @Select("select * from article where id=#{id}")
    @ResultMap("rmAm")
    Article selectById(int id);

    @Insert("insert into article values (#{id},#{author},#{title},#{content},"
            + "#{keyWords},#{description},#{categoryId},#{label},#{titleImgs},"
            + "#{status},now(),#{readCnt},#{agreeCnt})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")//返回自增值
    int insert(Article art);
}
