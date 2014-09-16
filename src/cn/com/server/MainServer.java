package cn.com.server;
import java.io.IOException;
import java.net.*;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.concurrent.*;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import cn.com.thread.InsertDate;
import cn.com.thread.MainProcess;
import cn.com.thread.ReceiveProcess;
import cn.com.util.ConfigTable;
public class MainServer extends Observable implements Runnable{
    private int port=10000;
    private ServerSocket serverSocket;
    private ExecutorService executorService;//线程池
	private static ReceiveProcess[] receive;
    public MainServer() throws IOException {
        //Runtime的availableProcessor()方法返回当前系统的CPU数目.
    	serverSocket=new ServerSocket(port);
        executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
    public void timer() {
    	Timer timer=new Timer();
    	DataServer dataServer=new DataServer();//往前台发送数据
    	CheckServer timerServer=new CheckServer();//定时检查有没有下线的，如果有下线的就将它剔除
    	InsertDate insertDate=new InsertDate();//如果定时插入数据；
    	receive=new ReceiveProcess[1];
    	//receive=new ReceiveProcess[Runtime.getRuntime().availableProcessors()];
    	//向前台客户端发送数据//5秒发一次
// 1    	timer.schedule(dataServer,0,60*1000L);
    	//timserver主要处理线程的如果超过这个时间就认为挂了；
// 2   	timer.schedule(timerServer,0, 6000L);
    	//12分钟刷新下一次，加一段时间
// 3   	timer.schedule(insertDate,0, 12*60*1000L);
    	//在这里开出线程进行消息处理
    	//这里是处理的线程，处理的线程的执行的频率应该比执行检查的时间要快点
    	for(int i=0;i<receive.length;i++){
  			receive[i] = new ReceiveProcess();	
//  4			timer.schedule(receive[i],0,5000L);
  		}
	}
	public void run(){
		System.out.println("服务器应用程序启动...");
		timer();
		try {
	        while(true){
	            Socket socket=null;
	            //接收客户连接,只要客户进行了连接,就会触发accept();从而建立连接
	            socket=serverSocket.accept();
	            executorService.execute(new MainProcess(socket));
	        }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
	/*
	连接-->发送文件信息(文件名,长度等)-->读数据-->发送文件数据

	接受时
	监听-->等待连接-->接受文件信息-->接受文件数据-->写入数据
  */

}