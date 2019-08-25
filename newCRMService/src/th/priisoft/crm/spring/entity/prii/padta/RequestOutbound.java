package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;

public class RequestOutbound implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int  userid;
	private String outbound;
	private Wavename wave;
	public String getOutbound() {
		return outbound;
	}
	public void setOutbound(String outbound) {
		this.outbound = outbound;
	}
	//	private Outbound[] outbound;
	
	
	public Wavename getWave() {
		return wave;
	}
	public void setWave(Wavename wave) {
		this.wave = wave;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
}
