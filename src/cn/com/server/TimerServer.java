package cn.com.server;
import java.util.TimerTask;

import cn.com.util.TimeUtil;
public class TimerServer extends TimerTask {
	public void run() {
      try{
    	     System.out.println("我在执行检查");
			 TimeUtil.changelifetime();
            }catch(Exception e){
				e.printStackTrace();
          }
	}

}
