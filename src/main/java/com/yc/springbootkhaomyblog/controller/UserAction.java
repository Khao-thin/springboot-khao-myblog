package com.yc.springbootkhaomyblog.controller;

import com.yc.springbootkhaomyblog.biz.BizException;
import com.yc.springbootkhaomyblog.biz.UserBiz;
import com.yc.springbootkhaomyblog.domain.Result;
import com.yc.springbootkhaomyblog.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserAction {
    @Resource
    private UserBiz userBiz;
    @PostMapping("reg.do")
    public String register(@Valid User user, Errors errors, Model model) {
        if (errors.hasErrors()){
            model.addAttribute("errors",asMap(errors));
            model.addAttribute("user",user);
            return "reg";
        }
        try {
            userBiz.register(user);
        } catch (BizException e) {
            e.printStackTrace();
            errors.rejectValue("account","account",e.getMessage());
            model.addAttribute("errors",asMap(errors));
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
    public Result login(User user, HttpSession session){
        try {
            User user1 = userBiz.login(user);
            session.setAttribute("loginUser",user1);
        } catch (BizException e) {
            e.printStackTrace();
            return new Result(e.getMessage());
        }
        return new Result(1,"登陆成功");
    }

    /**
     * 将字段验证错误写到一个map
     * @param errors
     * @return
     */
    private Map<String,String> asMap(Errors errors){
        if(errors.hasErrors()){
            Map<String,String>ret=new HashMap<>();
            for (FieldError fieldError : errors.getFieldErrors()) {
                ret.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return ret;
        }else return null;
    }
}
