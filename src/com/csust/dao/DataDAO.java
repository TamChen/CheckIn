package com.csust.dao;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.csust.entity.Attend;
import com.csust.entity.DayData;


public interface DataDAO {

	Serializable saveDayData(DayData dayData);

	DayData getThatData(Date recordTime);

	List<DayData> findAll();



}
