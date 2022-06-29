package com.sys.payment.entity;

public class MyUser {
	/*
	 * ID:用户标识符
	 * UCN:本人卡号
	 * FCN:家族卡号
	 * BN:额度
	 * SBN:可用额度
	 * */
	private String ID;
	private String UCN;
	private String FCN;
	private double BN;
	private double SBN;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUCN() {
		return UCN;
	}
	public void setUCN(String uCN) {
		UCN = uCN;
	}
	public String getFCN() {
		return FCN;
	}
	public void setFCN(String fCN) {
		FCN = fCN;
	}
	public double getBN() {
		return BN;
	}
	public void setBN(double bN) {
		BN = bN;
	}
	public double getSBN() {
		return SBN;
	}
	public void setSBN(double sBN) {
		SBN = sBN;
	}


}

