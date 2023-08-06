package com.stuti.email.api;

import com.stuti.hcm.ApiDetails;
import com.stuti.hcm.ApiService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;

@Component
public class CustomInterceptor implements HandlerInterceptor {

    private ApiService apiService;

    @Autowired
    public CustomInterceptor(ApiService apiService){
        this.apiService=apiService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request , HttpServletResponse response, Object handler){
        String requestURL = request.getRequestURL().toString();
        String requestMethod = request.getMethod();
        System.out.println("Incoming request " + requestMethod + requestURL );

        String clientName=request.getHeader("Client-Name");
        String ipaddress=request.getHeader("X-Forwarded-For");
        if(ipaddress==null||ipaddress.isBlank()||ipaddress.isEmpty()){
            ipaddress=request.getRemoteAddr();
            if(ipaddress==null){
                ipaddress="UnknownIP";
            }
        }
        if(clientName==null||clientName.isEmpty()||clientName.isBlank()){
            clientName="UnknownClient";
        }
        ApiDetails apiDetails=new ApiDetails(clientName ,ipaddress,new Timestamp(System.currentTimeMillis()));
        apiService.saveApiDetails(apiDetails);
        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView){

    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response , Object handler, Exception ex){

    }
}
