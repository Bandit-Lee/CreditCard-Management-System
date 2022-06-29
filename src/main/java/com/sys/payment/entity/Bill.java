package com.sys.payment.entity;

import java.sql.Timestamp;

public class Bill {
	/*
	 * Bid:账单标识符
	 * Vot:账单金额
	 * Sna:商户名
	 * Dist:区别，本人或家族
	 * Hire:是否为分期付款账单
	 * Hway:分期付款方式
	 * Id: 账单用户ID
	 * Statue:账单当前状态
	 * createTime:账单创建时间
	 * */
	private String Bid;
	private double Vot;
	private String Sna;
	private String Dist;
	private String Hire;
	private String Hway;
	private String Id;
	private String Statue;
	private Timestamp Time;
	public String getBid() {
		return Bid;
	}
	public void setBid(String bid) {
		Bid = bid;
	}
	public double getVot() {
		return Vot;
	}
	public void setVot(double vot) {
		Vot = vot;
	}
	public String getSna() {
		return Sna;
	}
	public void setSna(String sna) {
		Sna = sna;
	}
	public String getDist() {
		return Dist;
	}
	public void setDist(String dist) {
		Dist = dist;
	}
	public String getHire() {
		return Hire;
	}
	public void setHire(String hire) {
		Hire = hire;
	}
	public String getHway() {
		return Hway;
	}
	public void setHway(String hway) {
		Hway = hway;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getStatue() {
		return Statue;
	}
	public void setStatue(String statue) {
		Statue = statue;
	}
	public Timestamp getTime() {
		return Time;
	}
	public void setTime(Timestamp time) {
		Time = time;
	}




}
