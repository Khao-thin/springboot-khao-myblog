package com.yc.springbootkhaomyblog.controller;

import com.github.pagehelper.PageHelper;
import com.yc.springbootkhaomyblog.mapper.ArticleMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class IndexAction {
    @Resource
    private ArticleMapper articleMapper;

    @GetMapping(path = {"/","/index.html"})
    public String index(Model model,@RequestParam(defaultValue = "1") int page){
        PageHelper.startPage(page,5);
        model.addAttribute("aList",articleMapper.selectByNew());
        return "index";
    }

}
