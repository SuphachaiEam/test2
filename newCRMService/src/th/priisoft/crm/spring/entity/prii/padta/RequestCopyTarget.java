package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;

public class RequestCopyTarget implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int  userid;
	private int[] objid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int[] getObjid() {
		return objid;
	}
	public void setObjid(int[] objid) {
		this.objid = objid;
	}
	
	
	
	
}
