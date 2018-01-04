package com.lovewristband.mapper;

import java.util.List;

import com.lovewristband.po.BandInfo;
import com.lovewristband.po.PositionInfo;

public interface BandServiceMapper {
	public BandInfo checkband(BandInfo bandInfo);
	public BandInfo existBand(BandInfo bandInfo);	
	public BandInfo loginBand(BandInfo bandInfo);
	public void setBand(BandInfo bandInfo);
	public void create(BandInfo bandInfo);
	public void savePoint(PositionInfo positionInfo);
	public List<PositionInfo> getBandOneDayPosition(PositionInfo positionInfo);
	
}
