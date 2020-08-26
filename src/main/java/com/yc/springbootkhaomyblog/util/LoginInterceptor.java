package com.yc.springbootkhaomyblog.util;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断当前是否登录
        if (request.getSession().getAttribute("loginUser") == null) {
            // 根据当前的请求的方式返回不同结果
            // 判断当前是 页面跳转还是 ajax 请求
            String accept = request.getHeader("Accept");
            if(accept.startsWith("application/json")) {
                // ajax 请求
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().append("{code:0,msg:'请先登录系统'}");
                response.getWriter().append("{\"code\":\"0\",\"msg\":\"请先登录系统\"}");
            } else {
                // 页面跳转请求
                response.setContentType("text/html;charset=utf-8");
                response.sendRedirect("/?mustLogin");
            }
            return false;
        }
        // 正常业务执行返回 true
        return true;
    }
}
