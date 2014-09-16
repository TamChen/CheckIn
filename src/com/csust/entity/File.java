package com.csust.entity;

import java.sql.Date;

public class File {
	private int id;
	private String tag;
	private String newname;
	private String oldname;
	private int userno;
	private Date recordtime ;//在线状态
	private String address;//在线时长
	private String depict;
	private String format;
	private Float size;
	private String open;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getNewname() {
		return newname;
	}
	public void setNewname(String newname) {
		this.newname = newname;
	}
	public String getOldname() {
		return oldname;
	}
	public void setOldname(String oldname) {
		this.oldname = oldname;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public Date getRecordtime() {
		return recordtime;
	}
	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepict() {
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Float getSize() {
		return size;
	}
	public void setSize(Float size) {
		this.size = size;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}




}
