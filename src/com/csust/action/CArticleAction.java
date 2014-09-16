package com.csust.action;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import com.csust.entity.News;
import com.csust.service.ClientService;
import com.opensymphony.xwork2.ActionSupport;

public class CArticleAction extends ActionSupport{
	private String newsid;
	private ClientService clientService;
	@Test
	public String getArticle()  {
		System.out.println(newsid);	
		HttpSession session = ServletActionContext.getRequest().getSession();
		News news=clientService.getNewsById(Integer.valueOf(newsid));
		session.removeAttribute("title");
		session.removeAttribute("content");
		session.setAttribute("newtitle", news.getTitle());
		session.setAttribute("newcontent", news.getContent());
    	return "success";
		}
	public String getNewsid() {
		return newsid;
	}
	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}
	public ClientService getClientService() {
		return clientService;
	}
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}



}