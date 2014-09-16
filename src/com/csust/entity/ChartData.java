package com.csust.entity;
import java.util.ArrayList;
import java.util.List;
public class ChartData {
	private String name;
	private List<Float> data=new ArrayList<Float>();
	private Boolean visible;
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Float> getData() {
		return data;
	}
	public void setData(List<Float> data) {
		this.data = data;
	}


}
