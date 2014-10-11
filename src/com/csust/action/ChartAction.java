package com.csust.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.csust.entity.Attend;
import com.csust.entity.ChartData;
import com.csust.entity.DayData;
import com.csust.entity.User;
import com.csust.service.ChartService;
import com.csust.service.DataService;
import com.csust.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.alibaba.fastjson.JSONObject;

public class ChartAction extends ActionSupport{
	private JSONObject jsonData = new JSONObject();  
	public UserService userService;
	public ChartService chartService;
	public DataService dataService;
	private int userno;
	private String username;
	private float rate;
	public String getRandomData(){
		Random random=new Random();
		User user=new User();
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		Date date=new Date(timestamp.getTime());
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<User> userList=userService.findAll();
		if(userList.size()>0){
		user=userList.get(random.nextInt(userList.size()));
		System.out.println(userList.size());
		System.out.println(user.getUsername());
		if(user.getActivetime()==null){
			user.setTime(0);
			user.setActivetime("0");}
		session.setAttribute("ip", user.getIp());
		session.setAttribute("activetime", user.getActivetime());
		session.setAttribute("time", user.getTime());
		session.setAttribute("username", user.getUsername());
		session.setAttribute("userno", user.getUserno());
		session.setAttribute("begintime", date);
		session.setAttribute("endtime", date);
		}
		return "success";
	}
	public String searchData() throws IOException{
		Random random=new Random();
		User user=new User();
		HttpSession session = ServletActionContext.getRequest().getSession();
		System.out.println(username);
		if(username!=null){
			List<User> userlList=userService.getUserByName(username);
			System.out.println(userlList.size());
			if(userlList.size()>1)
			user=userlList.get(random.nextInt(userlList.size()));
			else if(userlList.size()==1){
				user=userlList.get(0);
			}else
			{
				session.setAttribute("errorName", username);
				System.out.println("没有找到这个人");
				return "success";
			}
		}else {
			List<User> userList=userService.findAll();
			user=userList.get(random.nextInt(userList.size()));
		}
		if(user.getActivetime()==null){
			user.setTime(0);
			user.setActivetime("0");
		}
		session.setAttribute("ip", user.getIp());
		session.setAttribute("activetime", user.getActivetime());
		session.setAttribute("time", user.getTime());
		System.out.println(session.getAttribute("username"));
		session.setAttribute("username", user.getUsername());
		System.out.println(user.getUsername());
		System.out.println(session.getAttribute("username"));
		session.setAttribute("userno", user.getUserno());
		return "success";
	}
	public String getPersonData() throws UnsupportedEncodingException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<List<String>> totalList=new ArrayList<List<String>>();
		List<Attend> attendList=new ArrayList<Attend>();
		User user=new User();
		DayData dayData=new DayData();
		username=(String) session.getAttribute("username");
		System.out.println(username);
		List<User> userlList=userService.getUserByName(username);
		if(userlList.size()>0){
			user=userlList.get(0);
			System.out.println(user.getActivetime());
		if(user.getActivetime()==null){
			user.setTime(0);
			user.setActivetime("0");
		}
			session.setAttribute("ip", user.getIp());
			session.setAttribute("activetime", user.getActivetime());
			session.setAttribute("time", user.getTime());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userno", user.getUserno());
		}
		attendList=chartService.getPersonDate(user.getUserno());
		int personTime=attendList.size();
		if(personTime>0){
			for (Attend attend : attendList) {
				List<String> everyList=new ArrayList<String>();
				Date recordTime=attend.getRecordtime();
				dayData=dataService.getThatData(recordTime);
				everyList.add(dayData.getEvertime().toString());
				everyList.add(dayData.getRate().toString());
				everyList.add(attend.getWorktime().toString());
				everyList.add(attend.getFreetime().toString());
				everyList.add(recordTime.toString());
				totalList.add(everyList);
			}
		}
		jsonData.put("aaData", totalList);
		this.setJsonData(jsonData);
		return "success";
		
	}
	@Test
	public String getPieChart() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Attend> attendList=new ArrayList<Attend>();
		int totalDay=chartService.getTotalDay();
		if(session.getAttribute("userno")!=null){
		userno=(Integer) session.getAttribute("userno");
		attendList=chartService.getPersonDate(userno);
		rate=(float)attendList.size()/totalDay;
		int rate01=(int) ((rate*100)%100);
		if(attendList.size()==totalDay)
			rate01=100;
		jsonData.put("rate", rate01);}
		this.setJsonData(jsonData); 
		return "success";
	}
	public String getPLineData() {
		//总的折线图需要记录所有时间的所有的记录每天的记录                 个人
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<ChartData> dataList=new ArrayList<ChartData>();
		ChartData workData=new ChartData();
		ChartData freeData=new ChartData();
		List<Date> xdataList = new ArrayList<Date>(); 
		List<String> xtimedateList=new ArrayList<String>();
		List<Float> worklist = new ArrayList<Float>();//
		List<Float> freelist = new ArrayList<Float>();//
		if(session.getAttribute("userno")!=null){
		userno=(Integer) session.getAttribute("userno");
	    worklist=chartService.getPWorkTime(userno);//根据工作时间作为折线图的竖坐标
	    freelist=chartService.getPFreeTime(userno);//根据工作时间作为折线图的竖坐标
	    xdataList=chartService.getXPdata(userno);//根据签到的日期，只是发现每次待实验室的规律
		}
	    //这里可以做的更智能化，更加好的用户体验
	    for (int i = 0; i < xdataList.size(); i++) {
	    	if(i%5==0){
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			String teString=sdf.format(xdataList.get(i));
			xtimedateList.add(teString);}
	    	else {
	    		xtimedateList.add("");
			}
		}
	    workData.setName("个人学习时长走势图");
	    workData.setData(worklist);
	    workData.setVisible(true);
	    freeData.setName("个人空闲时长走势图");
	    freeData.setData(freelist);
	    freeData.setVisible(true);
	    dataList.add(freeData);
	    dataList.add(workData);
	    jsonData.put("data", dataList);
	    jsonData.put("listXdata", xtimedateList);
	    this.setJsonData(jsonData);
		return "success"; 
	}
	public String getALineData() {
		//总的折线图需要记录所有时间的所有的记录每天的记录
		List<User> userList=new ArrayList<User>();
		userList=userService.findAll();
		Random random=new Random();
		List<ChartData> dataList=new ArrayList<ChartData>();
		for (User user : userList) {
			ChartData workData=new ChartData();
			List<Float> worklist = new ArrayList<Float>();//
			worklist=chartService.getPWorkTime(user.getUserno());//根据工作时间作为折线图的竖坐标
			workData.setName(user.getUsername());
			workData.setData(worklist);
			workData.setVisible(false);
			dataList.add(workData);
		}
		//将两条随机线显示在总线中
		if(dataList.size()>0){
		dataList.get(random.nextInt(dataList.size())).setVisible(true);
		dataList.get(random.nextInt(dataList.size())).setVisible(true);}
		//获得横坐标时间所有
		List<Date> xdataList = new ArrayList<Date>(); 
		List<String> xtimedateList=new ArrayList<String>();
		if(userList.size()>0){
	    xdataList=chartService.getXPdata(userList.get(0).getUserno());//根据签到的日期，只是发现每次待实验室的规律
		}
	    for (int i = 0; i < xdataList.size(); i++) {
	    	if(i%5==0){
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			String teString=sdf.format(xdataList.get(i));
			xtimedateList.add(teString);}
	    	else {
	    		xtimedateList.add("");
			}
		}
	    Map<String,Object> obj = new HashMap<String,Object>();
	    jsonData.put("data", dataList);
	    jsonData.put("listXdata", xtimedateList);
	    this.setJsonData(jsonData);
		return "success"; 
	}
	public String getAllData() {
		Map<String,Object> obj = new HashMap<String,Object>();
		List<List<String>> totalList=new ArrayList<List<String>>();
		List<User> userList=new ArrayList<User>();
		userList=userService.findAll();
		int personTime=userList.size();
		if(personTime>0){
			for (User user : userList) {
				List<String> everyList=new ArrayList<String>();
				everyList.add(user.getUsername().toString());
				everyList.add(String.valueOf(user.getUserno()));
				everyList.add(user.getActivetime());
				everyList.add(String.valueOf(user.getTime()));
				everyList.add("0");
//				everyList.add(user.getRate().toString());
				totalList.add(everyList);
			}
		}
		jsonData.put("aaData", totalList);
		this.setJsonData(jsonData);
		return "success";
	}

	public void setChartService(ChartService chartService) {
		this.chartService = chartService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public JSONObject getJsonData() {
		return jsonData;
	}
	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
}