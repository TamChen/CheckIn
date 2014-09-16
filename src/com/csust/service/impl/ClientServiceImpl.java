package com.csust.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.csust.dao.ClientDAO;
import com.csust.dao.UserDAO;
import com.csust.entity.News;
import com.csust.entity.Rss;
import com.csust.entity.RssUser;
import com.csust.entity.User;
import com.csust.service.ClientService;
import com.csust.service.UserService;


public class ClientServiceImpl implements ClientService {
	private ClientDAO clientDAO;
	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public ClientDAO getClientDAO() {
		return clientDAO;
	}
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	public List<News> findPersonal(String username) {
		return clientDAO.findPersonal(username);
	}
	@Override
	public List<Rss> findRssByUsername(String username) {
		return clientDAO. findRssByUsername(username);
	}
	@Override
	public List<News> findCollectByUsername(String username) {
		List<News> newsList=new ArrayList<News>();
		List<User> userlist=userDAO.getUserByName(username);
		if (userlist.size()>0) {
			User user=userlist.get(0);
			String collect=user.getMycollect();
			String collectList[]=collect.split(",");
			for (int i = 0; i < collectList.length; i++) {
				newsList.add(clientDAO.findNewById(Integer.valueOf(collectList[i])));
			}
			
		}
	
		return newsList;
	}
	public News getNewsById(Integer newsid) {
		return clientDAO.findNewById(newsid);
	}

	

	
}
