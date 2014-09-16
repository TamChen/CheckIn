package com.csust.service.impl;

import java.util.List;

import com.csust.dao.ChartDAO;
import com.csust.dao.UserDAO;
import com.csust.entity.Attend;
import com.csust.entity.Manage;
import com.csust.entity.User;
import com.csust.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	private ChartDAO chartDAO;
	
	public boolean login(int userno, String password) {
		User user = userDAO.queryUserByUserNo(userno);
		if (user == null) {
			return false;
		} else {
			if (user.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		}
	}
	@Override
	public Boolean login(String name, String password) {
		List<User> userList=userDAO.getUserByName(name);
		if (userList.size()>0) {
			if (userList.get(0).getPassword().equals(password)) {
				return true;
			}
		}
//		List<Integer> userno=userDAO.FindNoByName(name);
//		for (Integer userNo : userno) {
//			if(login(userNo, password)==true)
//				return true;
//		}
	
		return false;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public void setChartDAO(ChartDAO chartDAO) {
		this.chartDAO = chartDAO;
	}
	@Override
	public void saveUser(User user) {
		userDAO.saveUser(user);
		
	}
	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}
	@Override
	public String getActiveTime(int userno) {
		Float totaltime=(float) 0;
		List<Float> pworkList=chartDAO.getPWorkData(userno);
		for (Float pwork : pworkList) {
			totaltime=totaltime+pwork;
		}
		List<Float> pfreeList=chartDAO.getPFreeTime(userno);
		for (Float pfree : pfreeList) {
			totaltime=totaltime+pfree;
		}
		return totaltime.toString();
	}
	@Override
	public String getime(int userno) {
		
		List<Attend> attendList=chartDAO.getPersonDate(userno);
		return String.valueOf(attendList.size());
	}
	@Override
	public Float getPRate(int userno) {
		int totalDay=chartDAO.getTotalDay();
		List<Attend> attendList=chartDAO.getPersonDate(userno);
		Float rate= ((float)attendList.size()/totalDay);
		return rate;
	}
	@Override
	public boolean checkIp(String string) {
		return userDAO.checkIp(string);
	}
	@Override
	public void updateUser(User user) {
		this.userDAO.updateUser(user);
	}
	@Override
	public User getUserByNo(int userno) {
		return userDAO.queryUserByUserNo(userno);
	}
	@Override
	public User getUserByIp(String ip) {
		return userDAO.getUserByIp(ip);
	}
	public Boolean managelogin(String name, String password) {
		Manage manage = userDAO.queryManageByUsername(name);
		if (manage== null) {
			return false;
		} else {
			if (manage.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		}
	}
	@Override
	public List<User> getUserByName(String username) {
		return userDAO.getUserByName(username);
	}
	
}
