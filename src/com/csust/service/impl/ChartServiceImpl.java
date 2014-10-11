package com.csust.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.csust.dao.ChartDAO;
import com.csust.dao.UserDAO;
import com.csust.entity.Attend;
import com.csust.entity.User;
import com.csust.service.ChartService;

public class ChartServiceImpl implements ChartService {
	private ChartDAO chartDAO;
	private UserDAO userDAO;
	@Override
	public List<String> getXdata(Date chooseTime) {
		return chartDAO.getXdata(chooseTime);
	}
//	float price=1.2;
//	DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
//	String p=decimalFomat.format(price);//format 返回的是字符串
	public List<Float> getWorkTime(Date chooseTime) {
		String hql="select u.worktime from Attend as u where u.recordtime=? and u.worktime>0";
		List<Float> workTime=chartDAO.getBarData(hql,chooseTime);
		for (Float work : workTime) {
//			DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
			work=(float)(Math.round(work*100)/100);//如果要求精确4位就*10000然后/10000
		}
		return workTime;
	}

	public List<Float> getFreeTime(Date chooseTime) {
		String hql="select u.freetime from Attend as u where u.recordtime=? and u.worktime>0";
		List<Float> freeTime=chartDAO.getBarData(hql,chooseTime);
		for (Float free : freeTime) {
//			DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
			free=(float)(Math.round(free*100)/100);//如果要求精确4位就*10000然后/10000
		}
		return freeTime;
	}

	public void setChartDAO(ChartDAO chartDAO) {
		this.chartDAO = chartDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	public void saveAttend(Attend attend) {
		chartDAO.saveAttend(attend);
	}

	@Override
	public List<Attend> getPersonDate(int userno) {
		return chartDAO.getPersonDate(userno);
	}


	public List<Float> getAveTimeAndRate(Date recordtime) {
		List<Attend> attendList=new ArrayList<Attend>();
		List<Float> timeRate=new ArrayList<Float>();
		attendList=chartDAO.getThatDayData(recordtime);
		if(attendList.size()>0){
		Float totaltime=(float) 0;
		for (Attend attend : attendList) {
			totaltime=totaltime+attend.getFreetime()+attend.getWorktime();
		}
//		work=(float)(Math.round(work*100)/100);//如果要求精确4位就*10000然后/10000
		timeRate.add((float) Math.round(totaltime/attendList.size()*100/100));
		timeRate.add(((float) (attendList.size()/chartDAO.getThatDayData(recordtime).size()))*100);
		return timeRate;
		}
		timeRate.add((float) 0.0);//改天的到勤率与平均时长；
		timeRate.add((float) 0.0);
		return timeRate;
	}
	@Override
	public void updateFAttend(int userno, Date date ) {
		String hql="update Attend as u set u.freetime=u.freetime+0.2 where u.userno=? and u.recordtime=?";
		this.chartDAO.updateAttendTime( hql,userno, date);
		
	}
	@Override
	public void updateWAttend(int userno, Date date) {
		String hql="update Attend as u set u.worktime=u.worktime+0.2 where u.userno=? and u.recordtime=?";
		this.chartDAO.updateAttendTime(hql,userno, date);
	}
	@Override
	public int getTotalDay() {
		return chartDAO.getTotalDay();
	}

	@Override
	public List<Float> getPWorkTime(int userno) {
		
		List<Float> workTime=chartDAO.getPWorkData(userno);
		for (Float work : workTime) {
//			DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
			work=(float)(Math.round(work*100)/100);//如果要求精确4位就*10000然后/10000
		}
		return workTime;
	}
	public List<Float> getPFreeTime(int userno) {
		List<Float> freeTime=chartDAO.getPFreeTime(userno);
		for (Float free : freeTime) {
//			DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
			free=(float)(Math.round(free*100)/100);//如果要求精确4位就*10000然后/10000
		}
		return freeTime;
	}
	@Override
	public List<Date> getXPdata(int userno) {
		return chartDAO.getXPdata(userno);
	}

	@Override
	public List<Date> getDateList() {
		return chartDAO.getDateList();
	}

	@Override
	public List<Attend> getThatDayData(Date recordtime) {
		return chartDAO.getThatDayData(recordtime);
	}

	@Override
	public String getLongest(Date date) {
		return chartDAO.getLongest(date);
	}

	@Override
	public String getRateRank() {
		
		return "A";
	}
	@Override
	public List<Float> getWorkTime(Date begin, Date end) {
		List<User> userList=userDAO.findAll();
		List<Float> allDataList=new ArrayList<Float>();
		Float personal=(float) 0;
		for (User user : userList) {
			String hql="select u.worktime from Attend as u where u.userno=? and u.recordtime between ? and ? ";
			List<Float> workTime=chartDAO.getBarData01(hql,user.getUserno(),begin,end);
			for (Float float01 : workTime) {
				personal=personal+float01;
			}
			allDataList.add(personal);
			personal=(float) 0;
		}
		return allDataList;
	}
//	@Override
	public List<Float> getFreeTime(Date begin, Date end) {
		List<User> userList=userDAO.findAll();
		List<Float> allDataList=new ArrayList<Float>();
		Float personal=(float) 0;
		for (User user : userList) {
			String hql="select u.freetime from Attend as u where u.userno=? and u.recordtime between ? and ? ";
			List<Float> freeTime=chartDAO.getBarData01(hql,user.getUserno(),begin,end);
			for (Float float01 : freeTime) {
				personal=personal+float01;
			}
			allDataList.add(personal);
			personal=(float) 0;
		}
		return allDataList;
	}

	
}
