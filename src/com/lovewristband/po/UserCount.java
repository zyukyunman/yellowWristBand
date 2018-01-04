package com.lovewristband.po;

public class UserCount {
	private String recid;
	private int    amount;
	private String time;
	public String getRecid() {
		return recid;
	}
	public void setRecid(String recid) {
		this.recid = recid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "UserCount [recid=" + recid + ", amount=" + amount + ", time=" + time + "]";
	}

}
