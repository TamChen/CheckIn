package com.csust.action;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.server.DataServer;

import com.csust.dao.DataDAO;
import com.csust.entity.Attend;
import com.csust.entity.DayData;
import com.csust.entity.User;
import com.csust.service.ChartService;
import com.csust.service.DataService;
import com.csust.service.UserService;

public class ChartActionTest {
	private String username;
	private Float worktime;
	private Float freetime;
	private String ip;
	private String firstname[]={"赵","钱","孙","李","周", "陈","肖" ,"张", "戴", "欧阳", "孔", "孟", "王", "田", "玉", "黄"};
	private String lastname[]={"翼","一","二","三","四","五","六","七","八","九","十","立波","笑笑","弯弯","琪琪","狒狒","菲菲","慧慧","惠惠","灰灰","辉辉","王波"};
	private int data[]={1,2,3,4,5,6,7,8,9,10,12};
	ChartService chartService;
	UserService userService;
	DataService dataService;
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app*.xml");
		 chartService=(ChartService) ctx.getBean("chartService");
		 userService=(UserService) ctx.getBean("userService");
		 dataService=(DataService) ctx.getBean("dataService");
 		 System.out.println("@Before");
	}

	@Test
	public void testSaveData() {
//	    Random r=new Random();
//	    for (int i = 0; i <30; i++) {
//		Attend attend=new Attend();
//		username=firstname[r.nextInt(firstname.length)]+lastname[r.nextInt(lastname.length)];
//		worktime=data[r.nextInt(data.length)]+r.nextFloat();
//		freetime=data[r.nextInt(data.length)]+r.nextFloat();
//		attend.setUserno(i);
//		attend.setUsername(username);
//		attend.setWorktime(worktime);
//		attend.setFreetime(freetime);
//		 Date randomDate = randomDate("2014-01-01", "2014-08-15"); 
//		 attend.setRecordtime(new Timestamp(randomDate.getTime()));
//		chartService.saveAttend(attend);
//		for(int j = 0; j <30; j++) {
//		attend.setUserno(i);
//		worktime=data[r.nextInt(data.length)]+r.nextFloat();
//		freetime=data[r.nextInt(data.length)]+r.nextFloat();
//		attend.setWorktime(worktime);
//		attend.setFreetime(freetime);
//		randomDate = randomDate("2014-01-01", "2014-08-15"); 
//		attend.setRecordtime(new Timestamp(randomDate.getTime()));
//		chartService.saveAttend(attend);}
//		System.out.println("Hello JUnit!"); 
//	    }
		
	}

	@Test
	public void testSaveUser() {
		Random r=new Random();
		
		 for (int i = 0; i <20; i++) {
			 Attend attend=new Attend();
			 User user=new User();
			 username=firstname[r.nextInt(firstname.length)]+lastname[r.nextInt(lastname.length)];
			 user.setUsername(username);
			 user.setUserno(i);
			 user.setPassword("123456");
			 String ip=r.nextInt(255)+"."+r.nextInt(255)+"."+r.nextInt(255)+"."+r.nextInt(255);
			 user.setIp(ip);
			 Timestamp currentTime=new Timestamp(System.currentTimeMillis()); 
//			 Calendar cal = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。   
			 for (int j = 0; j <15; j++) {
				 worktime=data[r.nextInt(data.length)]+r.nextFloat();
				 freetime=data[r.nextInt(data.length)]+r.nextFloat();
				 attend.setUsername(username);
				 attend.setUserno(i);
				 attend.setIp(ip);
				 attend.setWorktime(worktime);
				 attend.setFreetime(freetime);
				 Date date = new Date(currentTime.getTime());
				 attend.setRecordtime(date);
				 chartService.saveAttend(attend);
	//			 cal.add(Calendar.DAY_OF_MONTH, -1);//取当前日期的前一天. 
				 currentTime=new Timestamp(currentTime.getTime()-1*24*3600*1000);
			 }
			 Float activetime=(float) 0;
			 List<Float> FreeList=chartService.getPFreeTime(i);
			 List<Float> WorkList=chartService.getPWorkTime(i);
			 for (int j = 0; j <FreeList.size(); j++) 
			 activetime=activetime+FreeList.get(j)+WorkList.get(j);
			 activetime=(float)(Math.round(activetime*100)/100);
			 user.setActivetime(activetime.toString());
			 List<Attend> attendList=chartService.getPersonDate(i);
			 user.setTime(attendList.size());
			 user.setRate((float)10.20);
			 user.setStatus("A");
			 user.setRank(10);
//			 user.setRank(userService.);
			 userService.saveUser(user);
		 	}
		 	List<User> userList=userService.findAll();
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
	 
    private static Date randomDate(String beginDate, String endDate) {  
        try {  
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            Date start = (Date) format.parse(beginDate);// 构造开始日期  
            Date end = (Date) format.parse(endDate);// 构造结束日期  
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。  
            if (start.getTime() >= end.getTime()) {  
                return null;  
            }  
            long date = random(start.getTime(), end.getTime());  
  
            return new Date(date);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    private static long random(long begin, long end) {  
        long rtn = begin + (long) (Math.random() * (end - begin));  
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
        if (rtn == begin || rtn == end) {  
            return random(begin, end);  
        }  
        return rtn;  
    }  
}
