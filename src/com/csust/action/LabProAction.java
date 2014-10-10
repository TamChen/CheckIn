package com.csust.action;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.csust.entity.Attend;
import com.csust.entity.ChartData;
import com.csust.entity.DayData;
import com.csust.entity.User;
import com.csust.service.ChartService;
import com.csust.service.DataService;
import com.csust.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
public class LabProAction extends ActionSupport{
	public UserService userService;
	public ChartService chartService;
	public DataService dataService;
	private JSONObject jsonData = new JSONObject();  
	private JSONObject resultObj ;
	private String begintime;
	private String endtime;
	public String checkBarData() throws ParseException{
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("begintime");
		session.removeAttribute("endtime");
		session.setAttribute("begintime",java.sql.Date.valueOf(begintime));
		session.setAttribute("endtime",java.sql.Date.valueOf(endtime));
		return "success";
	}
	public String getBarData() {
		//这里是显示实验室详细信息的条形图
		Random random=new Random();
		HttpSession session = ServletActionContext.getRequest().getSession();
		Date begin=(Date) session.getAttribute("begintime");
		Date end=(Date) session.getAttribute("endtime");
		if(begin!=null){
		begin = java.sql.Date.valueOf(begin.toString());
		end=java.sql.Date.valueOf(end.toString());
		List<Attend> attendList=new ArrayList<Attend>();//根据学号取得那天的数据
		List<User> userList=userService.findAll();
		User user=userList.get(random.nextInt(userList.size()));
		attendList=chartService.getPersonDate(user.getUserno());//用这里的时间自己写的时间有问题，排好序的
		if (attendList.get(0).getRecordtime().after(begin)||attendList.get(attendList.size()-1).getRecordtime().before(end)) {
			System.out.println("没有那天的数据");
		}
		}
		System.out.println("查询时间"+begin);
		System.err.println("查询时间"+end);
		List<ChartData> dataList=new ArrayList<ChartData>();
		ChartData workData=new ChartData();
		ChartData freeData=new ChartData();
		List<String> xdataList = new ArrayList<String>(); 
		List<Float> worklist = new ArrayList<Float>();//
	    List<Float> freelist = new ArrayList<Float>();//
	    worklist=chartService.getWorkTime(begin,end);
	    freelist=chartService.getFreeTime(begin,end);
//	    worklist=chartService.getWorkTime(begin);
//	    freelist=chartService.getFreeTime(begin);
	    xdataList=chartService.getXdata(begin);
	    workData.setName("学习时长");
	    workData.setData(worklist);
	    workData.setVisible(true);
	    freeData.setName("空闲时长");
	    freeData.setData(freelist);
	    freeData.setVisible(true);
	    dataList.add(workData);
	    dataList.add(freeData);
	    jsonData.put("data", dataList);
	    jsonData.put("listXdata", xdataList);
	    this.setJsonData(jsonData);
		return "success"; 
	}
	public String getAverTimeData() {
		ChartData averTimeData=new ChartData();
		List<Float> averTimelist = new ArrayList<Float>();//
		List<Date> xdataList = new ArrayList<Date>(); 
		List<String> xtimedateList=new ArrayList<String>();
		List<ChartData> dataList=new ArrayList<ChartData>();//需要一个用户学号作为入口
		List<DayData> dayDataList=new ArrayList<DayData>();
		dayDataList=dataService.findAll();
		if(dayDataList.size()>0)
		for (DayData dayData : dayDataList) {
			averTimelist.add(dayData.getEvertime());
			xdataList.add(dayData.getRecordtime());
		}
		averTimeData.setName("在线平均时长走势图");
		averTimeData.setData(averTimelist);
		averTimeData.setVisible(true);
		dataList.add(averTimeData);
		   for (int i = 0; i < xdataList.size(); i++) {
		    	if(i%5==0){
		    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
				String teString=sdf.format(xdataList.get(i));
				xtimedateList.add(teString);}
		    	else {
		    		xtimedateList.add("");
				}
			}
	    jsonData.put("data", dataList);
	    jsonData.put("listXdata", xtimedateList);
	    this.setJsonData(jsonData);
		return "success"; 
	}
	public String getEverRate() {
		Float rate;
		ChartData rateData=new ChartData();
		List<Float> ratelist = new ArrayList<Float>();//
		List<Date> xdataList = new ArrayList<Date>(); 
		List<String> xtimedateList=new ArrayList<String>();
		List<ChartData> dataList=new ArrayList<ChartData>();//需要一个用户学号作为入口
		List<DayData> dayDataList=new ArrayList<DayData>();
		dayDataList=dataService.findAll();
		for (DayData dayData : dayDataList) {
			rate=dayData.getRate();
			ratelist.add(rate);
			xdataList.add(dayData.getRecordtime());
		}
		rateData.setName("到勤率折线图");
		rateData.setData(ratelist);
		rateData.setVisible(true);
		//处理横坐标防止过多
		dataList.add(rateData);
		   for (int i = 0; i < xdataList.size(); i++) {
		    	if(i%5==0){
		    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
				String teString=sdf.format(xdataList.get(i));
				xtimedateList.add(teString);}
		    	else {
		    		xtimedateList.add("");
				}
			}
	    jsonData.put("data", dataList);
	    jsonData.put("listXdata", xtimedateList);
	    this.setJsonData(jsonData);
		return "success"; 
	}
	public String getEveyData() {
		Random random=new Random();
		List<List<String>> totalList=new ArrayList<List<String>>();
		List<DayData> dayDataList=new ArrayList<DayData>();
		dayDataList=dataService.findAll();
		if(dayDataList.size()>0)
			for (DayData dayData : dayDataList) {
				List<String> everyList=new ArrayList<String>();
				everyList.add(dayData.getEvertime().toString());//平均在线时长
				everyList.add(dayData.getRate().toString());//到勤率
				everyList.add(String.valueOf(dayData.getNumber()));//在线人数
				everyList.add(dayData.getLongest());//在线时长最长的人
				everyList.add(chartService.getRateRank());
				everyList.add(dayData.getRecordtime().toString());
				totalList.add(everyList);
			}
			jsonData.put("aaData", totalList);
			this.setJsonData(jsonData);
		return "success";
	}

	public JSONObject getResultObj() {
		return resultObj;
	}

	public void setChartService(ChartService chartService) {
		this.chartService = chartService;
	}
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	public void setResultObj(JSONObject resultObj) {
		this.resultObj = resultObj;
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
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
}