package com.yc.springbootkhaomyblog.biz;

import com.yc.springbootkhaomyblog.domain.Comment;
import com.yc.springbootkhaomyblog.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class CommentBiz {
    @Resource
    private CommentMapper commentMapper;
    public Comment create(Comment comm){
        commentMapper.insert(comm);
        return comm;
    }
}
