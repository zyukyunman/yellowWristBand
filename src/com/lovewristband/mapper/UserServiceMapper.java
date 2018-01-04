package com.lovewristband.mapper;



import java.util.List;

import com.lovewristband.po.UserCount;
import com.lovewristband.po.UserInfo;
import com.lovewristband.po.User_Band;

public interface UserServiceMapper {
	public UserInfo check(UserInfo userinfo);
	public UserInfo submit(UserInfo userinfo);
	public void reg(UserInfo userinfo);
	public void setAll(UserInfo userInfo);
	public void saveUserCount(UserCount userCount);
	public UserCount getUserNum();
	public UserInfo getInfo(String userID);
}
