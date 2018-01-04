package com.lovewristband.controller;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;


public class UserNumServlet implements HttpSessionListener{
	

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("session"+event.getSession().getId()+" allocated at " + new Date());
		
		ServletContext context=event.getSession().getServletContext(); 
        Integer count=(Integer)context.getAttribute("count"); 
        if(count==null){ 
            count=new Integer(1); 
        }else{ 
            int co = count.intValue( ); 
            count= new Integer(co+1); 
        } 
        if(count<0) count = 0;
        System.out.println("当前用户人数："+count); 
        context.setAttribute("count", count);//保存人数 
        
		AccessCounter aobj=AccessCounter.getInstance();
		if(aobj!=null)
		   aobj.increaseSession(count);
		else
			System.out.println("sorry");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("session"+event.getSession().getId()+" expired at " + new Date());
		ServletContext context=event.getSession().getServletContext(); 
        Integer count=(Integer)context.getAttribute("count"); 
        int co=count.intValue(); 
        count=new Integer(co-1); 
        if(count<0) count = 0;
        context.setAttribute("count", count); 
        System.out.println("当前用户人数："+count); 
		
		AccessCounter aobj=AccessCounter.getInstance();
		if(aobj!=null)
		   aobj.decreaseSession(count);
		else
			System.out.println("sorry");
	}

}
