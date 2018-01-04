package com.lovewristband.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lovewristband.mapper.BandServiceMapper;
import com.lovewristband.mapper.User_BandServiceMapper;
import com.lovewristband.po.BandInfo;
import com.lovewristband.po.PositionInfo;
import com.lovewristband.po.User_Band;
import com.lovewristband.service.BandService;

@Service
public class BandServiceImpl implements BandService {
	
	@Resource
	private BandServiceMapper bandServiceMapper;
	
	@Resource
	private User_BandServiceMapper user_BandServiceMapper;
	
	@Override
	public BandInfo existBand(BandInfo bandInfo) {
		// TODO Auto-generated method stub
		return bandServiceMapper.existBand(bandInfo);
	}

	@Override
	public BandInfo loginBand(BandInfo bandInfo) {
		// TODO Auto-generated method stub
		return bandServiceMapper.loginBand(bandInfo);
	}

	@Override
	public void setuser_band(User_Band user_band) {
		user_BandServiceMapper.setuser_band(user_band);
	}

	@Override
	public User_Band duplicateBand(User_Band user_band) {
		// TODO Auto-generated method stub
		return user_BandServiceMapper.duplicateBand(user_band);
	}

	@Override
	public void setBand(BandInfo bandInfo) {
		// TODO Auto-generated method stub
		bandServiceMapper.setBand(bandInfo);
	}

	@Override
	public void disuser_band(User_Band user_Band) {
		// TODO Auto-generated method stub
		user_BandServiceMapper.disuser_band(user_Band);
	}

	@Override
	public void create(BandInfo bandInfo) {
		// TODO Auto-generated method stub
		bandServiceMapper.create(bandInfo);
	}

	@Override
	public void savePoint(PositionInfo positionInfo) {
		// TODO Auto-generated method stub
		bandServiceMapper.savePoint(positionInfo);
	}

	@Override
	public List<PositionInfo> getBandOneDayPosition(PositionInfo positionInfo) {
		// TODO Auto-generated method stub
		return bandServiceMapper.getBandOneDayPosition(positionInfo);
	}
		
	
	

}
