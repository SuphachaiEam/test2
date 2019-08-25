
package th.priisoft.crm.model;

import java.math.BigDecimal;


public class Message {
	
	private String msgid = "";
	private String msgfr = "";
	private String msgto = "";
	private String subject = "";
	private String msgbodyid = "";
	private String transtype = "";
	private String type = "";
	private String process = "";
	private String ref_batchno = "";
	private String ref_notino = "";
	private String ref_policyno = "";
	private String ref_proposalid = "";
	private String appname = "";
	private String desc = "";
	private String mailsys = "";
	private String hostname = "";
	private long objid;      
    private BigDecimal update;      
    private BigDecimal updatetime;      
    private String upduserid=""; 
	
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getMsgfr() {
		return msgfr;
	}
	public void setMsgfr(String msgfr) {
		this.msgfr = msgfr;
	}
	public String getMsgto() {
		return msgto;
	}
	public void setMsgto(String msgto) {
		this.msgto = msgto;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMsgbodyid() {
		return msgbodyid;
	}
	public void setMsgbodyid(String msgbodyid) {
		this.msgbodyid = msgbodyid;
	}
	public String getTranstype() {
		return transtype;
	}
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getRef_batchno() {
		return ref_batchno;
	}
	public void setRef_batchno(String ref_batchno) {
		this.ref_batchno = ref_batchno;
	}
	public String getRef_notino() {
		return ref_notino;
	}
	public void setRef_notino(String ref_notino) {
		this.ref_notino = ref_notino;
	}
	public String getRef_policyno() {
		return ref_policyno;
	}
	public void setRef_policyno(String ref_policyno) {
		this.ref_policyno = ref_policyno;
	}
	public String getRef_proposalid() {
		return ref_proposalid;
	}
	public void setRef_proposalid(String ref_proposalid) {
		this.ref_proposalid = ref_proposalid;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMailsys() {
		return mailsys;
	}
	public void setMailsys(String mailsys) {
		this.mailsys = mailsys;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public long getObjid() {
		return objid;
	}
	public void setObjid(long objid) {
		this.objid = objid;
	}
	public String getUpduserid() {
		return upduserid;
	}
	public void setUpduserid(String upduserid) {
		this.upduserid = upduserid;
	}
	public BigDecimal getUpdate() {
		return update;
	}
	public void setUpdate(BigDecimal update) {
		this.update = update;
	}
	public BigDecimal getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(BigDecimal updatetime) {
		this.updatetime = updatetime;
	}
	
}
