package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name="logsession")
@NamedQuery(name="Logsession.findAll", query="SELECT l FROM Logsession l")
public class Logsession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long lsid;

	@Column(name="ipaddr")
	private String ipAddr;

	private Timestamp logdate;

	private String sessionid;

	private long userid;

	@Column(name="useridcreate")
	private long useridCreate;

	public Logsession() {
	}

	public long getLsid() {
		return this.lsid;
	}

	public void setLsid(long lsid) {
		this.lsid = lsid;
	}

	public String getIpAddr() {
		return this.ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public Timestamp getLogdate() {
		return this.logdate;
	}

	public void setLogdate(Timestamp logdate) {
		this.logdate = logdate;
	}

	public String getSessionid() {
		return this.sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getUseridCreate() {
		return this.useridCreate;
	}

	public void setUseridCreate(long useridCreate) {
		this.useridCreate = useridCreate;
	}

}