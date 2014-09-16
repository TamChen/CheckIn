package cn.com.thread;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.TimerTask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csust.entity.Attend;
import com.csust.entity.User;
import com.csust.service.ChartService;
import com.csust.service.UserService;
import com.csust.service.impl.UserServiceImpl;

import cn.com.list.Prototypelist;
import cn.com.list.WMessagelist;
import cn.com.model.Message;
import cn.com.model.Prototype;
import cn.com.util.ApplicationUtil;
public class ReceiveProcess extends TimerTask{
	ArrayList<Prototype> prototypelist=new ArrayList<Prototype>();
	Prototype prototype=new Prototype();
	ApplicationContext applicationContext = ApplicationUtil.getContext();
	UserService userService = (UserService) applicationContext.getBean("userService");
	ChartService chartService=(ChartService) applicationContext.getBean("chartService");
 	public void run() {
 		System.out.println("定时处理消息线程");
		prototypelist=Prototypelist.getPrototypelist();
		for (Prototype prototype : prototypelist) {
			Message message=new Message();
			try {
				String detailMessage="";
				String totalMessage=prototype.getIn().readLine();
				String subMessage=totalMessage.substring(7, totalMessage.length()-5)+"|";
				String mes[]=subMessage.split("\\|");
				message.setIp(prototype.getIp());
				message.setType(mes[0]);//用正则表达式将type和基本信息加入message
				message.setUserno(Integer.valueOf(mes[1]));
				for(int i=2;i<mes.length;i++)
					detailMessage=detailMessage+mes[i]+"|";
				message.setDetailMessage(detailMessage);
				System.out.println("type:"+mes[0]);
				System.out.println("userno:"+mes[1]);
				System.out.println("message:"+detailMessage);
				ProcessMessage(message);
				prototype.setLifetime((byte) 0);
//				System.out.println("收到的前台信息为"+totalMessage.getBytes("GBK"));
			}
			 catch (IOException e) {
				continue;//如果出现超时异常，则跳过
			}
		}		
 	}
	private void ProcessMessage(Message message) {
		//登录处理
		Attend attend=new Attend();
		Timestamp currentTime=new Timestamp(System.currentTimeMillis()); 
		Date date=new Date(currentTime.getTime());
		String mes[]=message.getDetailMessage().split("\\|");
		//登录处理
		if(message.getType().equals("LOGIN")){
			Boolean u =userService.login(message.getUserno(), mes[0]);
			if (u) {
				if(userService.checkIp(message.getIp())){	
					User user=userService.getUserByNo(message.getUserno());
					attend.setUserno(message.getUserno());
					chartService.updateWAttend(message.getUserno(),date);
					user.setIp(mes[1]);
					user.setStatus("on");
					userService.updateUser(user);
				}else{
					message.setType("ERRORIP");
					message.setDetailMessage("");
					SendProcess.sendMessage(message);
				}
			} else {
				message.setType("ERRORPS");
				message.setDetailMessage("");
				SendProcess.sendMessage(message);
			}
			}
		//心跳包处理
		if(message.getType().equals("WHB")){
			WMessagelist.add(message);
		}
		if(message.getType().equals("FHB")){
			WMessagelist.add(message);
		}
		}
}