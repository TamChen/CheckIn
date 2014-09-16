package com.csust.dao;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.csust.entity.Attend;


public interface ChartDAO {

	List<String> getXdata(Date chooseTime);

	List<Float> getBarData(String hql, Date chooseTime);

	Serializable saveAttend(Attend attend);

	List<Attend> getPersonDate(int userno);

	List<Attend> getThatDayData(Date recordtime);

	int getTotalDay();

	List<Float> getPWorkData( int userno);

	List<Date> getXPdata(int userno);

	List<Float> getPFreeTime(int userno);

	List<Date> getDateList();

	String getLongest(Date date);

	void updateAttendTime(String hql, int userno, Date date);

	List<Float> getBarData01(String hql, int i, Date begin, Date end);

}
