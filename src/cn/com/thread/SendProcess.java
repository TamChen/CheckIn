package cn.com.thread;

import java.io.PrintWriter;
import cn.com.list.Prototypelist;
import cn.com.model.Message;
import cn.com.model.Prototype;

public class SendProcess{
	public static  void sendMessage(Message message) {
		Prototype prototype=Prototypelist.getPrototype(message.getIp());
		if(prototype!=null){
		PrintWriter pw= prototype.getOut();
		String holeString=message.getType()+"|"+message.getUserno()+"|"+message.getDetailMessage();
		pw.println("#start#"+holeString+"#end#"+"'\n");
		pw.flush();
	}
	}
}