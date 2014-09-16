package cn.com.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;

public class ServerUtil {
	   public static PrintWriter getWriter(Socket socket) throws IOException{
	        OutputStream socketOut=socket.getOutputStream();
	        return new PrintWriter(socketOut,true);
	    }
	    public static BufferedReader getReader(Socket socket) throws IOException{
	        InputStream socketIn=socket.getInputStream();
	        return new BufferedReader(new InputStreamReader(socketIn));
	    }
		public static void closein(BufferedReader in) throws IOException {
			if(in!=null)
			in.close();
		}
		public static void closeout(PrintWriter out) {
			if(out!=null)
			out.close();
		}
	    	    
}