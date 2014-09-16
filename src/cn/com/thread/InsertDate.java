package cn.com.thread;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.context.ApplicationContext;

import com.csust.entity.Attend;
import com.csust.entity.User;
import com.csust.service.ChartService;
import com.csust.service.UserService;

import cn.com.list.FMessagelist;
import cn.com.list.Prototypelist;
import cn.com.list.WMessagelist;
import cn.com.model.Message;
import cn.com.model.Prototype;
import cn.com.util.ApplicationUtil;
import cn.com.util.TimeUtil;
public class InsertDate extends TimerTask {
	ApplicationContext applicationContext = ApplicationUtil.getContext();
	UserService userService = (UserService) applicationContext.getBean("userService");
	ChartService chartService=(ChartService) applicationContext.getBean("chartService");
	public void run() {
      try{
    	  //保存的的信息是工作时间和空闲时间，
    	  	Timestamp currentTime=new Timestamp(System.currentTimeMillis()); 
  			Date date=new Date(currentTime.getTime());
    	  	List<Message> Fmessagelist=FMessagelist.getMessagelist();
    	  	for (Message message : Fmessagelist) 
			chartService.updateFAttend(message.getUserno(), date);
    	  	List<Message> Wmessagelist=WMessagelist.getMessagelist();
    	  	for (Message message : Wmessagelist) 
			chartService.updateWAttend(message.getUserno(), date);
    	  	
            }catch(Exception e){
            	e.printStackTrace();
          }
	}


}
