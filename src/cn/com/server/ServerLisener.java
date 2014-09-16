package cn.com.server;
public class ServerLisener extends Thread {
        private Thread t;
        public ServerLisener(Thread t){
        	   this.t=t;
       }
        public void run() {
        	while(true){
        		if(!t.isAlive()){
        			System.out.println("服务器主线程挂了");
        			break;
        		}
        		else{
        			System.out.println("服务器主线程还没挂");
        		}
        	}
        }
}
