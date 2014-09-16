package com.csust.action;

import com.csust.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String name;
    private String password;
    private UserService userService;
    public String login() {
    	/* NAME和PASSWORD为空则返回登录页面，否则验证登录 */
    	System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDdd");
    	System.out.println(name);
		if (null == name && null == password) {
			return "login";
		} else {
			Boolean u = userService.login(name, password);
			if (u) {
				return "ok";
			} else {
				return "error";
			}
		}
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
