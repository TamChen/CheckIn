package cn.com.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import cn.com.list.FMessagelist;
import cn.com.list.Prototypelist;
import cn.com.list.WMessagelist;
import cn.com.model.Message;
import cn.com.model.Prototype;

public class TimeUtil {
	private static final byte MAX_OLDTIME = 5;
	private static  ArrayList<Prototype> prototypelist=new ArrayList<Prototype>();
	 @SuppressWarnings("static-access")
	public static void changelifetime() throws IOException{
		 prototypelist=new Prototypelist().getPrototypelist();
		 if(prototypelist!=null){
		System.out.println(prototypelist);
		System.out.println("这里是获得的socketlist"+prototypelist.size());
		
		 for(int i=0;i<prototypelist.size();i++){
			 try{
				 Prototype prototype=prototypelist.get(i);
				 byte lifetime=prototype.getLifetime();
				 if(lifetime>MAX_OLDTIME){
					 delprototype(i);
					 }
				 
				 else if(lifetime>=MAX_OLDTIME){
					 //这个是生命时间
					 lifetime+=1;
					 prototype.setLifetime(lifetime);
				 }
				 else{
					 //这里是设置生命时间，如果存在都置为正常
					 lifetime+=1;
					 prototype.setLifetime(lifetime);
				 }
				 }catch(Exception e){
					 e.printStackTrace();
				 }
			}
		 }
	 }//检查生存时间
	 private static void delprototype(int i) throws IOException {
		 ServerUtil.closein(prototypelist.get(i).getIn());
	     ServerUtil.closeout(prototypelist.get(i).getOut());
	     deletMessageList(prototypelist.get(i));//在两个工作时间列表和空闲时间中也要删除；
	     prototypelist.remove(i);
	     System.out.println("这里是留下来的线程个数"+prototypelist.size());
	}
	private static void deletMessageList(Prototype prototype) {
		List<Message> FList=FMessagelist.getMessagelist();
		List<Message> WList=WMessagelist.getMessagelist();
		for (int index=0;index<WList.size();index++) {
			if(WList.get(index).getIp().equals(prototype.getIp()))
				WList.remove(index);
		}
		for (int index=0;index<FList.size();index++) {
			if(FList.get(index).getIp().equals(prototype.getIp()))
				FList.remove(index);
		}
	}
	public static ArrayList<Prototype> getPrototypelist() {
		return prototypelist;
	}
	public static void resetlifetime(String mac){
		 for(int i=0;i<prototypelist.size();i++){
				 prototypelist.get(i).setLifetime((byte)0);
		 }
	 }//重置生存时间

	
}
