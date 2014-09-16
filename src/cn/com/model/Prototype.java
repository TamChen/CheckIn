package cn.com.model;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
public class Prototype {
	private String ip;
	private byte lifetime;
	private PrintWriter out;
	private BufferedReader in;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public byte getLifetime() {
		return lifetime;
	}
	public void setLifetime(byte lifetime) {
		this.lifetime = lifetime;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

}
