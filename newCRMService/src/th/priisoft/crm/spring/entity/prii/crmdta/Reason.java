package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="reason")
@NamedQuery(name="Reason.findAll", query="SELECT r FROM Reason r")
public class Reason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reasonid;

	private String reasoncode;

	@Column(name="reasondescen")
	private String reasondescEn;

	@Column(name="reasondescth")
	private String reasondescTh;

	private int statusid;

	public Reason() {
	}

	public int getReasonid() {
		return this.reasonid;
	}

	public void setReasonid(int reasonid) {
		this.reasonid = reasonid;
	}

	public String getReasoncode() {
		return this.reasoncode;
	}

	public void setReasoncode(String reasoncode) {
		this.reasoncode = reasoncode;
	}

	public String getReasondescEn() {
		return this.reasondescEn;
	}

	public void setReasondescEn(String reasondescEn) {
		this.reasondescEn = reasondescEn;
	}

	public String getReasondescTh() {
		return this.reasondescTh;
	}

	public void setReasondescTh(String reasondescTh) {
		this.reasondescTh = reasondescTh;
	}

	public int getStatusid() {
		return this.statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

}