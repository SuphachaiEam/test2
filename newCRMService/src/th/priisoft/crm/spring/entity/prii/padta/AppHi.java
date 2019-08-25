package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name="app_his")
@NamedQuery(name="AppHi.findAll", query="SELECT a FROM AppHi a")
public class AppHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long apphisid;

	private String action;

	private long appid;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	private String detail;

	@Column(name="useridcreate")
	private int useridCreate;

	public AppHi() {
	}

	public long getApphisid() {
		return this.apphisid;
	}

	public void setApphisid(long apphisid) {
		this.apphisid = apphisid;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public long getAppid() {
		return this.appid;
	}

	public void setAppid(long appid) {
		this.appid = appid;
	}

	public Timestamp getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getUseridCreate() {
		return this.useridCreate;
	}

	public void setUseridCreate(int useridCreate) {
		this.useridCreate = useridCreate;
	}

}