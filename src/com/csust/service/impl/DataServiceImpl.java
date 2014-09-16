package com.csust.service.impl;

import java.sql.Date;
import java.util.List;

import com.csust.dao.DataDAO;
import com.csust.entity.DayData;
import com.csust.service.DataService;

public class DataServiceImpl implements DataService {
	private DataDAO dataDAO;
	@Override
	public void saveDayData(DayData dayData) {
		this.dataDAO.saveDayData(dayData);
		
	}
	public void setDataDAO(DataDAO dataDAO) {
		this.dataDAO = dataDAO;
	}
	@Override
	public DayData getThatData(Date recordTime) {
		return this.dataDAO.getThatData(recordTime);
	}
	@Override
	public List<DayData> findAll() {
		return this.dataDAO.findAll();
	}
	
	
}
