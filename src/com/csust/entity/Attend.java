package com.csust.entity;
import java.sql.Date;
public class Attend {
	private int id;
	private int userno;
	private String username;
	private String ip;
	private Float worktime;//在线状态
	private Float freetime;//在线时长
	private Date recordtime;
	
	
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

	public Float getWorktime() {
		return worktime;
	}
	public void setWorktime(Float worktime) {
		this.worktime = worktime;
	}
	public Float getFreetime() {
		return freetime;
	}
	public void setFreetime(Float freetime) {
		this.freetime = freetime;
	}
	public Date getRecordtime() {
		return recordtime;
	}
	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
	}




}
