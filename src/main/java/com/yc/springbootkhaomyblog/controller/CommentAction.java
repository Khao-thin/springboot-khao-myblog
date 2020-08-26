package com.yc.springbootkhaomyblog.controller;

import com.yc.springbootkhaomyblog.biz.CommentBiz;
import com.yc.springbootkhaomyblog.domain.Comment;
import com.yc.springbootkhaomyblog.domain.Result;
import com.yc.springbootkhaomyblog.domain.User;
import com.yc.springbootkhaomyblog.mapper.CommentMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;

@RestController
public class CommentAction {
    @Resource
    private CommentBiz commentBiz;

    @Resource
    public CommentMapper commentMapper;

    @PostMapping("comment")
    public Result comment(Comment comm, @SessionAttribute User loginUser){
        comm.setCreateBy(loginUser.getId());
        commentBiz.create(comm);
        return new Result(1,"回复成功",loginUser);
    }

    @GetMapping("queryComm")
    public Result comment(int articleId) {
        return new Result(1, "查询回复成功",commentMapper.selectByArticle(articleId) );
    }
}
