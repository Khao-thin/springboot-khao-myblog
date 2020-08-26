package com.yc.springbootkhaomyblog.biz;

import com.yc.springbootkhaomyblog.domain.Article;
import com.yc.springbootkhaomyblog.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ArticleBiz {
    @Resource
    private ArticleMapper aMapper;

    public int create(Article art) {
        return aMapper.insert(art);
    }
}
