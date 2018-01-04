package com.lovewristband.service;

import java.util.ArrayList;
import java.util.List;

import com.lovewristband.po.BandInfo;
import com.lovewristband.po.UserCount;
import com.lovewristband.po.UserInfo;
import com.lovewristband.po.User_Band;

public interface UserService 
{
       public UserInfo check(UserInfo userInfo);//查询信息
       public UserInfo submit(UserInfo userInfo);//登录检查
       public void reg(UserInfo userInfo);//进行注册
       public void setAll(UserInfo userInfo);//设置资料
       public BandInfo checkband(BandInfo bandInfo);
       public ArrayList<User_Band> getBandList(String userID);//获得bandlist
	   public void saveUserCount(UserCount userCount);
	   public UserCount getUserNum();
       public List<UserInfo> getfamily(String bandID);//得到家人信息
}
