package com.lovewristband.po;

public class datadictionary {
      private int dataID;
      private int item;
      private int PID;
	public int getDataID() {
		return dataID;
	}
	public void setDataID(int dataID) {
		this.dataID = dataID;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	@Override
	public String toString() {
		return "datadictionary [dataID=" + dataID + ", item=" + item + ", PID=" + PID + "]";
	}
}
