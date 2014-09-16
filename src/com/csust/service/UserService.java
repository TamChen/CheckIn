package com.csust.service;

import java.util.List;

import com.csust.entity.User;

public interface UserService {
	public boolean login(int userno,String password);

	public void saveUser(User user);

	public List<User> findAll();

	public String getActiveTime(int userno);

	public String getime(int userno);

	public Float getPRate(int userno);

	public Boolean login(String name, String password);

	public boolean checkIp(String string);

	public void updateUser(User user);

	public User getUserByNo(int userno);

	public User getUserByIp(String ip);

	public List<User> getUserByName(String username);

	public Boolean managelogin(String name, String password);
}
