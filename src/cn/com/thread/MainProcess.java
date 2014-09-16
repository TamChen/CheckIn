package cn.com.thread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import cn.com.list.Prototypelist;
import cn.com.model.Prototype;
import cn.com.util.ConfigTable;
import cn.com.util.ServerUtil;
	public class MainProcess implements Runnable{
	    private Socket socket;
	    public MainProcess(Socket socket){
	        this.socket=socket;
	    }
	    public void run(){
	        try {
	        	socket.setSoTimeout(ConfigTable.timeout);
	            System.out.println("New connection accepted "+socket.getInetAddress()+":"+socket.getPort());
	    		PrintWriter pw = ServerUtil.getWriter(socket); 
	    		BufferedReader rd = ServerUtil.getReader(socket); 
	    		String StringremoteIP=socket.getInetAddress().getHostAddress(); 
	    		Prototype prototype=new Prototype();
	    		prototype.setIp(StringremoteIP);
	    		prototype.setLifetime((byte)0);
	    		prototype.setIn(rd);
	    		prototype.setOut(pw);
	    		Prototypelist.add(prototype);  		
	        	}
	        catch(Exception e){
				if(socket!=null){
					try {
						socket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				e.printStackTrace();
			}
	    	}



	}