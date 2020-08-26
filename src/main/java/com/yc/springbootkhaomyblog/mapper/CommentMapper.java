package com.yc.springbootkhaomyblog.mapper;

import com.yc.springbootkhaomyblog.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper {
    @Insert("insert into comment values (null,"
            + "#{articleId},#{content},#{createBy},now())")
    public int insert(Comment comm);

    @Select("select * from comment where articleId=#{articleId}")
    public List<Comment> selectByArticle(int articleId);
}
