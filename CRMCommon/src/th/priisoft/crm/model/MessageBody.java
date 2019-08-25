package th.priisoft.crm.model;


public class MessageBody {
	private String msgbodyid = "";
	private int seq;
	private String type = "";
	private String message = "";
	
	public String getMsgbodyid() {
		return msgbodyid;
	}
	public void setMsgbodyid(String msgbodyid) {
		this.msgbodyid = msgbodyid;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
