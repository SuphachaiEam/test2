package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="status")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int statusid;

	private int moduleid;

	private String statuscode;

	@Column(name="statusdescen")
	private String statusdescEn;

	@Column(name="statusdescth")
	private String statusdescTh;

	public Status() {
	}

	public int getStatusid() {
		return this.statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public int getModuleid() {
		return this.moduleid;
	}

	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}

	public String getStatuscode() {
		return this.statuscode;
	}

	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

	public String getStatusdescEn() {
		return this.statusdescEn;
	}

	public void setStatusdescEn(String statusdescEn) {
		this.statusdescEn = statusdescEn;
	}

	public String getStatusdescTh() {
		return this.statusdescTh;
	}

	public void setStatusdescTh(String statusdescTh) {
		this.statusdescTh = statusdescTh;
	}

}