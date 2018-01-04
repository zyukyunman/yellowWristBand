package com.lovewristband.mapper;

import java.util.ArrayList;
import java.util.List;

import com.lovewristband.po.UserInfo;
import com.lovewristband.po.User_Band;

public interface User_BandServiceMapper {

	void setuser_band(User_Band user_band);

	User_Band duplicateBand(User_Band user_band);

	ArrayList<User_Band> getBandList(String userID);

	void disuser_band(User_Band user_Band);
	
	ArrayList<User_Band> getUserList(String bandID);
}
