package com.csust.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.csust.entity.User;
import com.csust.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ManageAction extends ActionSupport{
	private String name;
    private String password;
    private UserService userService;
    public String login() throws IOException {
    	/* NAME和PASSWORD为空则返回登录页面，否则验证登录 */
//    	System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDdd");
//    	System.out.println(name);
    	//获取头部的ip信息action登录第一做验证，从头部获取ip信息
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	System.out.println(name+"和"+password);
		if (null == name && null == password) {
			return "login";
		} else {
			Boolean u = userService.login(name, password);
			System.out.println(u);
			if (u) {
				User user=userService.getUserByName(name).get(0);
				session.setAttribute("cip", user.getIp());
				session.setAttribute("cactivetime", user.getActivetime());
				session.setAttribute("ctime", user.getTime());
				session.setAttribute("crate",user.getRate() );
				session.setAttribute("cusername", name);
				session.setAttribute("cpassword", password);
				session.setAttribute("cimgurl", user.getImgurl());
				return "success";
			} else {
				//是根据返回的是否为空判断是否跳转，这里有点小问题
				return "error";
			}
		}

		}
    public String manageLogin() throws IOException {

		if (null == name && null == password) {
			return "login";
		} else {
			Boolean u = userService.managelogin(name, password);
			if (u) {
				return "success";
			} else {
				return "error";
			}
		}
		}
    public String exit() throws IOException {
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	HttpServletResponse response = ServletActionContext.getResponse();
    	session.invalidate();//用来清空会话，放在退出操作里

//    	session.removeAttribute("user");
    	return "success";
    }
    public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public String getPassword() {
    	return password;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
}
