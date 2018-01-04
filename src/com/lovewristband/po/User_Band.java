package com.lovewristband.po;

public class User_Band {
     private String userID;
     private String bandID;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBandID() {
		return bandID;
	}
	public void setBandID(String bandID) {
		this.bandID = bandID;
	}
	@Override
	public String toString() {
		return "User_Band [userID=" + userID + ", bandID=" + bandID + "]";
	}

}
