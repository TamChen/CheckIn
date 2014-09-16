package com.csust.service;

import java.sql.Date;
import java.util.List;

import com.csust.entity.DayData;

public interface DataService {

	void saveDayData(DayData dayData);

	DayData getThatData(Date recordTime);

	List<DayData> findAll();


}
