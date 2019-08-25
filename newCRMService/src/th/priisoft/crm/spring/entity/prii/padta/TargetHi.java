package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name="target_his")
@NamedQuery(name="TargetHi.findAll", query="SELECT t FROM TargetHi t")
public class TargetHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long targethisid;

	private String act;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	private String detail;

	private long objid;

	@Column(name="useridcreate")
	private int useridCreate;

	public TargetHi() {
	}

	public long getTargethisid() {
		return this.targethisid;
	}

	public void setTargethisid(long targethisid) {
		this.targethisid = targethisid;
	}

	public String getAct() {
		return this.act;
	}

	public void setAct(String act) {
		this.act = act;
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

	public long getObjid() {
		return this.objid;
	}

	public void setObjid(long objid) {
		this.objid = objid;
	}

	public int getUseridCreate() {
		return this.useridCreate;
	}

	public void setUseridCreate(int useridCreate) {
		this.useridCreate = useridCreate;
	}

}