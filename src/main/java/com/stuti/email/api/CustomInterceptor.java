package com.stuti.email.api;

import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request , HttpServletResponse response, Object handler){
        String requestURL = request.getRequestURL().toString();
        String requestMethod = request.getMethod();
        System.out.println("Incoming request " + requestMethod + requestURL );

        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView){

    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response , Object handler, Exception ex){

    }
}
