package com.csust.service;

import java.sql.Date;
import java.util.List;

import com.csust.entity.Attend;

public interface ChartService {

	
	
	List<Float> getWorkTime(Date chooseTime);

	List<Float> getFreeTime(Date chooseTime);

	void saveAttend(Attend attend);

	List<Attend> getPersonDate(int userno);

	List<Float> getAveTimeAndRate(Date recordTime);

	int getTotalDay();

	List<Attend> getThatDayData(Date recordtime);
	
	List<Float> getPWorkTime(int userno);

	List<Date> getXPdata(int userno);

	List<Float> getPFreeTime(int userno);

	List<String> getXdata(Date chooseTime);

	List<Date> getDateList();

	String getLongest(Date date);

	String getRateRank();

	void updateFAttend(int userno, Date date);

	void updateWAttend(int userno, Date date);

	List<Float> getWorkTime(Date begin, Date end);

	List<Float> getFreeTime(Date begin, Date end);


}
