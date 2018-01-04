package com.lovewristband.controller;

import java.io.IOException;  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import com.lovewristband.po.UserInfo; 

public class FilterController extends HttpServlet implements Filter {  
    private static final long serialVersionUID = 1L;  
  
    public void doFilter(ServletRequest  arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {  
           HttpServletRequest request=(HttpServletRequest)arg0;     
           HttpServletResponse response  =(HttpServletResponse) arg1;      
           HttpSession session = request.getSession();
           UserInfo user_role = (UserInfo)session.getAttribute("user");//登录人角色  
           String url=request.getRequestURI();     
           if( user_role == null) {        
                //判断获取的路径不为空且不是访问登录页面或执行登录操作时跳转     
             if(url!=null && !url.equals("") && ( url.indexOf("login")<0 && url.indexOf("reg")<0 && url.indexOf("help")<0 && url.indexOf("bandgogo")<0 && url.indexOf("index")<0)) {     
                	response.sendRedirect(request.getContextPath() + "/login.html");     
                    return ;     
                }                
            }     
            arg2.doFilter(arg0, arg1);     
            return;     
    }  
    public void init(FilterConfig arg0) throws ServletException {  
    }  
  
} 
