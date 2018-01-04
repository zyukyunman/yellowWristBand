package com.lovewristband.po;

public class medical_allergy {
	private String medicalID;
	private String dataID;
	public String getMedicalID() {
		return medicalID;
	}
	public void setMedicalID(String medicalID) {
		this.medicalID = medicalID;
	}
	public String getDataID() {
		return dataID;
	}
	public void setDataID(String dataID) {
		this.dataID = dataID;
	}
	@Override
	public String toString() {
		return "medical_allergy [medicalID=" + medicalID + ", dataID=" + dataID + "]";
	}
}
