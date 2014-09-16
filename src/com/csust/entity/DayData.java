package com.csust.entity;
import java.sql.Date;
public class DayData {
	private int id;
	private Float evertime;
	private Float rate;
	private int number;
	private Date recordtime;
	private String longest;
	public String getLongest() {
		return longest;
	}
	public void setLongest(String longest) {
		this.longest = longest;
	}
	public Float getEvertime() {
		return evertime;
	}
	public void setEvertime(Float evertime) {
		this.evertime = evertime;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Date getRecordtime() {
		return recordtime;
	}
	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
