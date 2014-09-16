package cn.com.list;

import java.util.ArrayList;

import cn.com.model.Message;
import cn.com.model.Prototype;

public class WMessagelist {
	private static ArrayList<Message> messagelist=new ArrayList<Message>();
	public static ArrayList<Message> getMessagelist() {
		return messagelist;
	}
	public static void add(Message message) {
		messagelist.add(message);
	}

}
