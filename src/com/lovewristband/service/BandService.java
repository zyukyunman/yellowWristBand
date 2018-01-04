package com.lovewristband.service;

import java.util.List;

import com.lovewristband.po.BandInfo;
import com.lovewristband.po.PositionInfo;
import com.lovewristband.po.User_Band;

public interface BandService {
	
	public BandInfo existBand(BandInfo bandInfo);

	public BandInfo loginBand(BandInfo bandInfo);
	
	public void setBand(BandInfo bandInfo);

	public void setuser_band(User_Band user_band);

	public User_Band duplicateBand(User_Band user_band);

	public void disuser_band(User_Band user_Band);

	public void create(BandInfo bandInfo);

	public void savePoint(PositionInfo positionInfo);

	public List<PositionInfo> getBandOneDayPosition(PositionInfo positionInfo);
	
	

}
