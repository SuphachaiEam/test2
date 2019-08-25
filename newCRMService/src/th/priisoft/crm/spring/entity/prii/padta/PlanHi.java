package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name="plan_his")
@NamedQuery(name="PlanHi.findAll", query="SELECT p FROM PlanHi p")
public class PlanHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long hisid;

	private String action;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	private String detail;

	@Column(name="usercreate")
	private int userCreate;

	public PlanHi() {
	}

	public long getHisid() {
		return this.hisid;
	}

	public void setHisid(long hisid) {
		this.hisid = hisid;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
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

	public int getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(int userCreate) {
		this.userCreate = userCreate;
	}

}