package com.lovewristband.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lovewristband.mapper.BandServiceMapper;
import com.lovewristband.mapper.UserServiceMapper;
import com.lovewristband.mapper.User_BandServiceMapper;
import com.lovewristband.po.BandInfo;
import com.lovewristband.po.UserCount;
import com.lovewristband.po.UserInfo;
import com.lovewristband.po.User_Band;
import com.lovewristband.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserServiceMapper userServiceMapper;
	@Resource
	private BandServiceMapper bandServiceMapper;
	@Resource
	private User_BandServiceMapper user_BandServiceMapper;

	@Override
	public BandInfo checkband(BandInfo bandInfo) {
		// TODO Auto-generated method stub
		return bandServiceMapper.checkband(bandInfo);
	}
	
	public UserInfo check(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userServiceMapper.check(userInfo);
	}
	
	public UserInfo submit(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return userServiceMapper.submit(userInfo);
	}

	@Override
	public void reg(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userServiceMapper.reg(userInfo);
	}

	@Override
	public void setAll(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userServiceMapper.setAll(userInfo);
	}

	@Override
	public ArrayList<User_Band> getBandList(String userID) {
		// TODO Auto-generated method stub
		return user_BandServiceMapper.getBandList(userID);
	}

	@Override
	public void saveUserCount(UserCount userCount) {
		// TODO Auto-generated method stub
		userServiceMapper.saveUserCount(userCount);
	}

	@Override
	public UserCount getUserNum() {
		// TODO Auto-generated method stub
		return userServiceMapper.getUserNum();
	}

	@Override
	public List<UserInfo> getfamily(String bandID) {
		// TODO Auto-generated method stub
		ArrayList<User_Band> al= user_BandServiceMapper.getUserList(bandID);
		ArrayList<UserInfo> arr=new ArrayList<UserInfo>();
		for(User_Band ub:al)
		{
			
			arr.add(userServiceMapper.getInfo(ub.getUserID()));
		}
		return arr;
	}
	


}
