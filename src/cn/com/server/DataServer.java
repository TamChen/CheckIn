package cn.com.server;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.springframework.context.ApplicationContext;
import com.csust.entity.User;
import com.csust.service.ChartService;
import com.csust.service.UserService;

import cn.com.list.Prototypelist;
import cn.com.model.Message;
import cn.com.model.Prototype;
import cn.com.thread.SendProcess;
import cn.com.util.ApplicationUtil;
public class DataServer extends TimerTask {
	ApplicationContext applicationContext = ApplicationUtil.getContext();
	UserService userService = (UserService) applicationContext.getBean("userService");
	ChartService chartService=(ChartService) applicationContext.getBean("chartService");
	public void run() {
      try{
    	  //个人签到信息  PERINFO
    	  //在线时长  ONTIME
    	  //在线次数  ONNUMBER
    	  //综合信息  MUTIL
    	  List<Float> worklist;
    	  List<Date> xdataList;
    	  List<String> userTimeList = new ArrayList<String>();
    	  List<String> timeList=new ArrayList<String>();
    	  Map<String,Object> obj = new HashMap<String,Object>();
    	  List<Prototype> prototypeList=Prototypelist.getPrototypelist();
    	  System.out.println("开始发送到前台的数据");
    	  if(prototypeList.size()>0){
    	  List<User> userlist=userService.findAll();
    	  for (User user : userlist) {
    		 userTimeList.add(userService.getActiveTime(user.getUserno()));
    		 timeList.add(userService.getime(user.getUserno()));
    	  }
    	  for (Prototype prototype : prototypeList) {
    		  //向每个用户发送该人的签到信息；
	    	  Message message=new Message();
	    	  int userno=userService.getUserByIp(prototype.getIp()).getUserno();
	    	  message.setType("PERINFO");
	    	  message.setIp(prototype.getIp());
	    	  message.setUserno(userno);
	    	  //获得该人每天记录的详细信息和横坐标
	    	  worklist=chartService.getPWorkTime(userno);//根据工作时间作为折线图的竖坐标
	  	      xdataList=chartService.getXPdata(userno);//根据签到的日期，只是发现每次待实验室的规律
	  	      obj.put("worklist", worklist);
	  	      obj.put("xdataList", xdataList);
	    	  message.setDetailMessage(obj.toString());
	    	  SendProcess.sendMessage(message);
	    	  //向每个用户发送总的时间排名
	    	  message.setType("ONTIME");
	    	  message.setDetailMessage(userTimeList.toString());
	    	  SendProcess.sendMessage(message);
	    	  //在线次数  ONNUMBER
	    	  message.setType("ONNUMBER");
	    	  message.setDetailMessage(timeList.toString());
	    	  SendProcess.sendMessage(message);
	    	  //发送综合消息 MUTIL
    	  }}
            }catch(Exception e){
				e.printStackTrace();
          }
	}
	
}
