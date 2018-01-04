package com.lovewristband.po;

public class PositionInfo {
     private String bandID;
     private String ptime;
     private String lng;
     private String lat;
	public String getBandID() {
		return bandID;
	}
	public void setBandID(String bandID) {
		this.bandID = bandID;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "PositionInfo [bandID=" + bandID + ", ptime=" + ptime + ", lng=" + lng + ", lat=" + lat + "]";
	}
}
