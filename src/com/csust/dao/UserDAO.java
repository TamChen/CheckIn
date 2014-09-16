package com.csust.dao;

import java.io.Serializable;
import java.util.List;

import com.csust.entity.Manage;
import com.csust.entity.User;

public interface UserDAO {
	public User queryUserByUserNo(int userno);

	public List<User> findAll();

	public Serializable saveUser(User user);

	public List<Integer> FindNoByName(String name);

	public boolean checkIp(String string);

	public void updateUser(User user);

	public User getUserByIp(String ip);

	public List<User> getUserByName(String username);

	public Manage queryManageByUsername(String name);

}
