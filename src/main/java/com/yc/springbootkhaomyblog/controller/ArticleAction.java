package com.yc.springbootkhaomyblog.controller;

import com.yc.springbootkhaomyblog.biz.ArticleBiz;
import com.yc.springbootkhaomyblog.domain.Article;
import com.yc.springbootkhaomyblog.domain.User;
import com.yc.springbootkhaomyblog.mapper.ArticleMapper;
import com.yc.springbootkhaomyblog.util.Utils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class ArticleAction {
    @Resource
    private ArticleBiz abiz;

    @Resource
    private ArticleMapper articleMapper;

	@GetMapping("article")
	public ModelAndView article(ModelAndView modelAndView,int id) {
	    modelAndView.addObject("article",articleMapper.selectById(id));
	    modelAndView.setViewName("article");
		return modelAndView;
	}

    @GetMapping("toAddArticle")
    public ModelAndView toAddArticle(ModelAndView mav) {
        mav.setViewName("addArticle");
        return mav;
    }

    @PostMapping("addArticle.do")
    public ModelAndView addArticle(@Valid Article a, Errors errors, ModelAndView mav, @SessionAttribute("loginUser") User user) {
        // ModelAndView = Model + View
        if (errors.hasErrors()) {
            mav.addObject("errors", Utils.asMap(errors));
            mav.addObject("article", a);
            mav.setViewName("addArticle");
        } else {
            a.setAuthor(user.getName());
            abiz.create(a);
            //相应重定向 把地址传给浏览器 浏览器重新根据地址访问    不加redirect会把整个当成一个字符
            mav.setViewName("redirect:article?id="+a.getId()); // 未完待续 .. 展示新添加的文章
        }
        return mav;
    }
}
