package com.csust.dao.impl;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.csust.dao.DataDAO;
import com.csust.entity.DayData;
public class DataDAOImpl  implements DataDAO {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Serializable saveDayData(DayData dayData) {
		return sessionFactory.getCurrentSession().save(dayData);
	}
	@Override
	public DayData getThatData(Date recordTime) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from DayData as u where u.recordtime=?");
		query.setTimestamp(0,recordTime);
		@SuppressWarnings("unchecked")
		List<DayData>  dayDataList=query.list();
		if(dayDataList.size()>0)
		return dayDataList.get(0);
		return null;
	}
	@Override
	public List<DayData> findAll() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from DayData order by recordtime asc");
		@SuppressWarnings("unchecked")
		List<DayData> dayData=query.list();
		return dayData;
	}

	
}