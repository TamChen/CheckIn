package cn.com.list;

import java.util.ArrayList;

import cn.com.model.Prototype;

public class Prototypelist {
	private static ArrayList<Prototype> prototypelist=new ArrayList<Prototype>();
	public static ArrayList<Prototype> getPrototypelist() {
		return prototypelist;
	}
	public static void add(Prototype prototype) {
		prototypelist.add(prototype);
	}
	public static Prototype getPrototype(String ip) {
		
		for (int i = 0; i < prototypelist.size(); i++) {
			if(prototypelist.get(i).getIp().equals(ip)){
				return prototypelist.get(i);
			}
		}
		return null;
	}
}
