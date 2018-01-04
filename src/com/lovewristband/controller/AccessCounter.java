package com.lovewristband.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


import com.lovewristband.po.UserCount;
import com.lovewristband.service.UserService;

@Component
public class AccessCounter {
    
	public static AtomicLong sessionCount=new AtomicLong();
	public static AtomicLong sessionExpiredCount=new AtomicLong();
	public static AccessCounter  obj=null;
	
	@Resource
	private  UserService userService;
	
	public AccessCounter()
	{
		obj=this;	
	}
	
	public static AccessCounter getInstance()
	{
		//if(obj==null)
		//	obj=new AccessCounter();
		return obj;
	}
	
	
	public  void increaseSession(Integer count)
	{
//		long sessNum = sessionCount.incrementAndGet();
//		System.out.println(sessNum);
		UserCount userCount = new UserCount();
		userCount.setAmount((int)count);
		userCount.setRecid(UUID.randomUUID().toString());
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = dateFormat.format(date);
		userCount.setTime(time);
		if(userService==null) System.out.println("fail");
		System.out.println(userCount);
		userService.saveUserCount(userCount);
	}
	
	public  void decreaseSession(Integer count)
	{
//		long sessNum = sessionExpiredCount.incrementAndGet();
//		System.out.println(sessNum);
		UserCount userCount = new UserCount();
		userCount.setAmount((int)count);
		userCount.setRecid(UUID.randomUUID().toString());
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = dateFormat.format(date);
		userCount.setTime(time);
		if(userService==null) System.out.println("fail");
		System.out.println(userCount);
		userService.saveUserCount(userCount);
	}

}
