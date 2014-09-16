package cn.com.model;

public class Message {
	private String type;  //消息类型
    private int userno;//mac地址ַ
    private String ip;//ip地址
    private String detailMessage;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDetailMessage() {
		return detailMessage;
	}
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	
}
