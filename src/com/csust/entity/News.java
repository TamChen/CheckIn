package com.csust.entity;

import java.sql.Timestamp;

public class News {
	private int id;
	private int userno;
	private int newsid;
	private String username;
	private int star;
	private int comnumber;
	private String statu;//在线状态
	private String title;//在线时长
	private String content;
	private String url;
	private Timestamp recordtime;
	public Timestamp getRecordtime() {
		return recordtime;
	}
	public void setRecordtime(Timestamp recordtime) {
		this.recordtime = recordtime;
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
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getComnumber() {
		return comnumber;
	}
	public void setComnumber(int comnumber) {
		this.comnumber = comnumber;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


}
