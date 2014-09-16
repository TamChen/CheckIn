package cn.com.util;

import java.io.UnsupportedEncodingException;

/**
 * 该类作用是解决乱码问题的工具类
 * @author Administrator
 *
 */
public class EncodeUtil {
	public static String transferISO8859ToUTF8(String str) throws UnsupportedEncodingException{
		return new String (str.getBytes("ISO-8859-1"),"utf-8");
	}
	public static String transferGBKToUTF8(String str) throws UnsupportedEncodingException{
		return new String (str.getBytes("gbk"),"UTF-8");
	}
}
