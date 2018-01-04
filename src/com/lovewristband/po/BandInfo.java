package com.lovewristband.po;

public class BandInfo {
	private String bandID;
	private String pwd;
	private String bname;
	private String sexy;
	private String address;
	private String medicalID;
	private String bloodtype;
	private String thanksgiving;
	private String lng;
	private String lat;
	private int    age;
	private String    tele;
	private int    rad;
	private int    type;//0：未激活 1：激活 2:报失

	public String getBandID() {
		return bandID;
	}
	public void setBandID(String bandID) {
		this.bandID = bandID;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
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
	public String getMedicalID() {
		return medicalID;
	}
	public void setMedicalID(String medicalID) {
		this.medicalID = medicalID;
	}
	public String getThanksgiving() {
		return thanksgiving;
	}
	public void setThanksgiving(String thanksgiving) {
		this.thanksgiving = thanksgiving;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public int getRad() {
		return rad;
	}
	public void setRad(int rad) {
		this.rad = rad;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getBloodtype() {
		return bloodtype;
	}
	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}
	@Override
	public String toString() {
		return "BandInfo [bandID=" + bandID + ", pwd=" + pwd + ", bname=" + bname + ", sexy=" + sexy + ", address="
				+ address + ", medicalID=" + medicalID + ", bloodtype=" + bloodtype + ", thanksgiving=" + thanksgiving
				+ ", lng=" + lng + ", lat=" + lat + ", age=" + age + ", tele=" + tele + ", rad=" + rad + ", type="
				+ type + "]";
	}
}
