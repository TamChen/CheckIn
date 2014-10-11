package com.csust.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.csust.entity.News;
import com.csust.entity.Rss;
import com.csust.service.ClientService;
import com.opensymphony.xwork2.ActionSupport;

public class CpersonAction extends ActionSupport{
	private String username;
    private List<News> newsList;
    private List<Rss> rssList;
    private List<News> newsCollect;
	private ClientService clientService;
	@Test
	public String allinfo()  {
				this.username="helloworld";
				HttpSession session = ServletActionContext.getRequest().getSession();
				String username=(String) session.getAttribute("cusername");
				System.out.println(username);
				this.newsList=clientService.findPersonal(username);
				this.rssList=clientService.findRssByUsername(username);
				this.newsCollect=clientService.findCollectByUsername(username);
				System.out.println(newsList.get(0).getTitle());
				System.out.println(rssList.get(0).getRssname());
				System.out.println(newsCollect.get(0).getTitle());
    			return "success";
		}


	public List<News> getNewsCollect() {
		return newsCollect;
	}


	public void setNewsCollect(List<News> newsCollect) {
		this.newsCollect = newsCollect;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public List<Rss> getRssList() {
		return rssList;
	}

	public void setRssList(List<Rss> rssList) {
		this.rssList = rssList;
	}

}