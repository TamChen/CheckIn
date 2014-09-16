package com.csust.dao.impl;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.csust.dao.UserDAO;
import com.csust.entity.Manage;
import com.csust.entity.User;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;

	public User queryUserByUserNo(int userno) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User as u where u.userno = ?");
		query.setInteger(0, userno);
		@SuppressWarnings("unchecked")
		List<User> u = query.list();
		if(u.size()>0)return u.get(0);
		return null;
	}
	@Override
	public List<Integer> FindNoByName(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select u.userno from User as u where u.username = ?");
		query.setString(0, name);
		@SuppressWarnings("unchecked")
		List<Integer> u =  (List<Integer>) query.list();
		return u;
	}
	
	public List<User> findAll() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User as u");
		@SuppressWarnings("unchecked")
		List<User> u = (List<User>) query.list();
		return u;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Serializable saveUser(User user) {
		return sessionFactory.getCurrentSession().save(user);
		
	}
	@Override
	public boolean checkIp(String ip) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Map as u where ip=?");
		query.setString(0, ip);
		if(query.list().size()>0)
		    return true;
		return false;
	}
	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	@Override
	public User getUserByIp(String ip) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User as u where u.ip = ?");
		query.setString(0, ip);
		User u = (User) query.uniqueResult();
		return u;
	}
	@Override
	public List<User>  getUserByName(String username) {
		System.out.println(username);
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User as u where u.username= ?");
		query.setString(0, username);
		@SuppressWarnings("unchecked")
		List<User> u = query.list();
		
		System.out.println(u.size());
		return u;
	}
	@Override
	public Manage queryManageByUsername(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Manage as u where u.username = ?");
		query.setString(0, name);
		@SuppressWarnings("unchecked")
		List<Manage> u = query.list();
		if(u.size()>0)return u.get(0);
		return null;
	}


}