package cn.com.server;

//代码清单StartCycleRunTask：容器监听器
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.thread.InsertDate;
import cn.com.thread.ReceiveProcess;
import cn.com.util.ApplicationUtil;

import com.csust.entity.Attend;
import com.csust.entity.User;
import com.csust.service.ChartService;
import com.csust.service.UserService;
public class StartRunTask  extends Observable implements ServletContextListener {
  private Timer timer=new Timer();
  private ApplicationContext ctx;
  private static ReceiveProcess[] receive;
  public void contextDestroyed(ServletContextEvent arg0) {
      // ②该方法在Web容器关闭时执行
	  timer.cancel();
      System.out.println("服务器应用程序关闭...");
  }
  public void contextInitialized(ServletContextEvent sce) {
       //②在Web容器启动时自动执行该方法
      
      //获得实例
	  ctx = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
	  UserService userService = (UserService) ctx.getBean("userService");
	  ChartService chartService=(ChartService) ctx.getBean("chartService");
//    启动服务器中所有的定时服务
	  TimerTask  task = new SimpleTimerTask();  
      timer.schedule(task, 5000); //
      
      //初始化数据库
      	Timestamp currentTime=new Timestamp(System.currentTimeMillis()); 
		Date date=new Date(currentTime.getTime());
		List<Date> attendList=chartService.getDateList();
		System.out.println("获得当天的数据如果启动时有数据，就不执行"+attendList.size());
		if(attendList.size()==0){
			List<User> userList=userService.findAll();
			for (User user : userList) {
				Attend attend=new Attend();
				attend.setUsername(user.getUsername());
				attend.setUserno(user.getUserno());
				attend.setIp(user.getIp());
				attend.setWorktime((float) 0);
				attend.setFreetime((float) 0);
				attend.setRecordtime(date);
				chartService.saveAttend(attend);
			}
		}
  }
class SimpleTimerTask extends TimerTask {//③任务
	
  public void run() {
	  try {
    	  MainServer mainServer=new MainServer();
//    	  addObserver(serverLisener);
//    	  mainServer.addObserver(mainServer);
    	  mainServer.run();
  		mainServer = new MainServer();
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  }
}}