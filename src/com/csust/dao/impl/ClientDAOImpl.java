package com.csust.dao.impl;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.csust.dao.ChartDAO;
import com.csust.dao.ClientDAO;
import com.csust.entity.Attend;
import com.csust.entity.News;
import com.csust.entity.Rss;
import com.csust.entity.RssUser;
import com.sun.org.apache.bcel.internal.generic.Select;
public class ClientDAOImpl  implements ClientDAO {
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<News> findPersonal(String username) {
		System.out.println(username);
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from News u where u.username=?");
		query.setString(0, username);
		@SuppressWarnings("unchecked")
		List<News> u =query.list();
		System.out.println(u.size());
		return u;
	}
	@Override
	public List<Rss> findRssByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Rss as r where r.rssid in(select u.rssid from RssUser as u where u.username=?)");
		query.setString(0, username);
		@SuppressWarnings("unchecked")
		List<Rss> u = (List<Rss>)query.list();
		return u;
	}
	@Override
	public News findNewById(Integer newsid) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from News as u where u.newsid=?");
		query.setInteger(0, newsid);
		@SuppressWarnings("unchecked")
		List<News> u = (List<News>)query.list();
		if(u.size()>0)
		return u.get(0);
		return null;
	}

}