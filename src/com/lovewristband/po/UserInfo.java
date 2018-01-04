package com.lovewristband.po;

public class UserInfo {
	private String userID;
	private String uname;
	private String pwd;
	private String sexy;
	private String address;
	private String tele;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSexy() {
		return sexy;
	}
	public void setSexy(String sexy) {
		this.sexy = sexy;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	@Override
	public String toString() {
		return "UserInfo [userID=" + userID + ", uname=" + uname + ", pwd=" + pwd + ", sexy=" + sexy + ", address="
				+ address + ", tele=" + tele + "]";
	}

}
