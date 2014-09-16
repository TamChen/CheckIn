package com.csust.dao.impl;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.csust.dao.ChartDAO;
import com.csust.entity.Attend;
import com.sun.org.apache.bcel.internal.generic.Select;
public class ChartDAOImpl  implements ChartDAO {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getXdata(Date chooseTime) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select u.username from Attend as u where u.worktime>0 and u.recordtime=?");
		query.setDate(0, chooseTime);
		@SuppressWarnings("unchecked")
		List<String> u = (List<String>)query.list();
		return u;
	}
	@Override
	public List<Float> getBarData(String hql,Date chooseTime) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setDate(0, chooseTime);
		@SuppressWarnings("unchecked")
		List<Float> u = (List<Float>)query.list();
		return u;
	}
	@Override
	public Serializable saveAttend(Attend attend) {
		return sessionFactory.getCurrentSession().save(attend);
	}
	@Override
	public List<Attend> getPersonDate(int userno) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Attend as u where u.userno = ? and u.worktime<>0 order by u.recordtime asc");
		query.setInteger(0, userno);
		@SuppressWarnings("unchecked")
		List<Attend> u = (List<Attend>)query.list();
		return u;
	}
	@Override
	public List<Attend> getThatDayData(Date recordtime) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Attend as u where u.recordtime = ? and u.worktime>0");
		query.setDate(0,recordtime);
		@SuppressWarnings("unchecked")
		List<Attend> u = (List<Attend>)query.list();
		return u;
	}

	@Override
	@Test
	public int getTotalDay() {
//		delete from table where time in (select min(time) from table) 
		
		Date currentTime=new Date(System.currentTimeMillis()); 
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select min(recordtime) from Attend");
		Date minRecordTime=(Date) query.uniqueResult();
		//因为今天的时间减去最早的时间除以一天的天数，需要再加一
		if(minRecordTime!=null)
		return (int) ((currentTime.getTime()-minRecordTime.getTime())/(24*60*60*1000)+1);
		return 0;
	}
	@Override
	public List<Float> getPWorkData(int userno) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("select round(u.worktime,2)  from Attend "+
				"as u where u.userno=? order by u.recordtime asc");
		query.setInteger(0,userno);
		@SuppressWarnings("unchecked")
		List<Float> u = (List<Float>)query.list();
		return u;
	}
	public List<Float> getPFreeTime(int userno) {
		Query query = sessionFactory.getCurrentSession().createQuery("select u.freetime from Attend "+
	"as u where u.userno=? order by u.recordtime asc");
		query.setInteger(0,userno);
		@SuppressWarnings("unchecked")
		List<Float> u = (List<Float>)query.list();
		return u;
	}
	@Override
	public List<Date> getXPdata(int userno) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select u.recordtime from Attend as u where userno=? order by u.recordtime asc");
		query.setInteger(0,userno);
		@SuppressWarnings("unchecked")
		List<Date> u = (List<Date>)query.list();
		return u;
	}
	@Override
	public List<Date> getDateList() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select distinct u.recordtime from Attend as u order by u.recordtime asc");
		@SuppressWarnings("unchecked")
		List<Date> u = (List<Date>)query.list();
		return u;
	}
	@Override
	public String getLongest(Date date) {
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"from Attend where worktime in (select max(worktime) from Attend where recordtime=?)");
		query.setDate(0,date);
		@SuppressWarnings("unchecked")
		List<Attend> attendList = (List<Attend>) query.list();
		if(attendList.size()>0){
		return attendList.get(0).getUsername()+attendList.get(0).getWorktime();
		}
		return null;
	}

	public void updateAttendTime(String hql, int userno, Date date) {
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, userno);
		query.setDate(1,date);
		query.executeUpdate();
		
	}
	public List<Float> getBarData01(String hql, int userno, Date begin, Date end) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, userno);
		query.setDate(1,begin );
		query.setDate(2,end);
		@SuppressWarnings("unchecked")
		List<Float> u = (List<Float>)query.list();
		return u;
	}

	
	


	
}