package com.csust.entity;

public class User {
	private int id;
	private int userno;
	private String username;
	private String password;
	private String ip;
	private String status;//在线状态
	private String activetime;//在线时长
	private int time;
	private int rank;
	private Float rate;
	private String imgurl;
	private String mynewslist;
	private String mycollect;
	private String myrsslist;

	public String getMyrsslist() {
		return myrsslist;
	}
	public void setMyrsslist(String myrsslist) {
		this.myrsslist = myrsslist;
	}
	public String getMynewslist() {
		return mynewslist;
	}
	public void setMynewslist(String mynewslist) {
		this.mynewslist = mynewslist;
	}
	public String getMycollect() {
		return mycollect;
	}
	public void setMycollect(String mycollect) {
		this.mycollect = mycollect;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getActivetime() {
		return activetime;
	}
	public void setActivetime(String activetime) {
		this.activetime = activetime;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
