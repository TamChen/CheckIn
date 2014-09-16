package cn.com.server;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimerTask;

import org.springframework.context.ApplicationContext;

import com.csust.entity.Attend;
import com.csust.entity.DayData;
import com.csust.entity.User;
import com.csust.service.ChartService;
import com.csust.service.DataService;
import com.csust.service.UserService;

import cn.com.util.ApplicationUtil;
import cn.com.util.TimeUtil;
public class CheckServer extends TimerTask {
	ApplicationContext applicationContext = ApplicationUtil.getContext();
	UserService userService = (UserService) applicationContext.getBean("userService");
	ChartService chartService=(ChartService) applicationContext.getBean("chartService");
	DataService dataService=(DataService) applicationContext.getBean("dataService");
	public void run() {
      try{
    	     System.out.println("我在执行检查");
    	     Map map=Thread.getAllStackTraces();
    	     System.out.println("正在运行的线程数"+map.size());
    	     initialEveryDate();
			 TimeUtil.changelifetime();
            }catch(Exception e){
				e.printStackTrace();
          }
	}
	private void initialEveryDate() {
		Timestamp currentTime=new Timestamp(System.currentTimeMillis()); 
		Date date=new Date(currentTime.getTime());
		Calendar calendar = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。   
		int hour =calendar.get(Calendar.HOUR_OF_DAY); 
		int min=calendar.get(Calendar.MINUTE);
		if(hour==0&&min==1){
			List<Attend> attendList=chartService.getThatDayData(date);
			if(attendList.size()==0){
				List<User> userList=userService.findAll();
				DayData dayData=new DayData();
				for (User user : userList) {
					Attend attend=new Attend();
					attend.setUsername(user.getUsername());
					attend.setUserno(user.getUserno());
					attend.setIp(user.getIp());
					attend.setWorktime((float) 0);
					attend.setFreetime((float) 0);
					attend.setRecordtime(date);
					chartService.saveAttend(attend);
					//保存每天的数据
					dayData.setEvertime((float) 0);
					dayData.setNumber(0);
					dayData.setRate((float) 0);
					dayData.setRecordtime(date);
					dayData.setLongest("");
					dataService.saveDayData(dayData);
				}
			}
		}
		//每20分钟保存一次
		if(min%20==0)
		saveToDateBase();
	}
	private void saveToDateBase() {
		Random r=new Random();
		List<User> userList=userService.findAll();
		for (User user : userList) {
			Float totaltime=(float) 0;
			List<Float> activetime=chartService.getPWorkTime(user.getUserno());
			List<Float> freetime=chartService.getPFreeTime(user.getUserno());
			for (int i = 0; i < activetime.size(); i++) {
				totaltime=totaltime+activetime.get(i)+freetime.get(i);
			}
			totaltime=(float)(Math.round(totaltime*100)/100);
			user.setActivetime(totaltime.toString());
			List<Attend> attendList=chartService.getPersonDate(user.getUserno());
			user.setTime(attendList.size());
			user.setRate(userService.getPRate(user.getUserno()));
			userService.updateUser(user);
		}
		 User user=userList.get(r.nextInt(userList.size()));
		 List<Date> dateList=chartService.getXPdata(user.getUserno());
		 DayData dayData=new DayData();
		 for (Date date : dateList) {
			List<Float> timeRate=chartService.getAveTimeAndRate(date);
			 dayData.setEvertime(timeRate.get(0));
			 dayData.setRate(timeRate.get(1));
			 dayData.setNumber(chartService.getThatDayData(date).size());
			 dayData.setRecordtime(date);
			 dayData.setLongest(chartService.getLongest(date));
			 dataService.saveDayData(dayData);
		 }
	}
}
