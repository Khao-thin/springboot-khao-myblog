package com.yc.springbootkhaomyblog.controller;

import com.yc.springbootkhaomyblog.biz.BizException;
import com.yc.springbootkhaomyblog.biz.UserBiz;
import com.yc.springbootkhaomyblog.domain.Result;
import com.yc.springbootkhaomyblog.domain.User;
import com.yc.springbootkhaomyblog.util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserAction {
    @Resource
    private UserBiz userBiz;
    @PostMapping("reg.do")
    public String register(@Valid User user, Errors errors, Model model) {
        if (errors.hasErrors()){
            model.addAttribute("errors", Utils.asMap(errors));
            model.addAttribute("user",user);
            return "reg";
        }
        try {
            userBiz.register(user);
        } catch (BizException e) {
            e.printStackTrace();
            errors.rejectValue("account","account",e.getMessage());
            model.addAttribute("errors",Utils.asMap(errors));
            model.addAttribute("user",user);
            return "reg";
        }
        //使用响应重定向
        return "redirect:/";
    }

    @GetMapping("toReg")
    public String toReg(){
        return "reg";
    }

    @PostMapping("login.do")
    @ResponseBody//返回json
    public Result login(@Valid User user, Errors errors,  HttpSession session){
        try {
            if (errors.hasFieldErrors("account")||errors.hasFieldErrors("pwd")){
                return new Result(0,"验证错误",Utils.asMap(errors));
            }
            User user1 = userBiz.login(user);
            session.setAttribute("loginUser",user1);
            return new Result(1,"登陆成功",user1);
        } catch (BizException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        }
    }
}
