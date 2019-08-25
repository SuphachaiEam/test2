package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name="campaign_his")
@NamedQuery(name="CampaignHi.findAll", query="SELECT c FROM CampaignHi c")
public class CampaignHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long hisid;

	private String act;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	private String detail;

	@Column(name="usercreate")
	private int userCreate;

	public CampaignHi() {
	}

	public long getHisid() {
		return this.hisid;
	}

	public void setHisid(long hisid) {
		this.hisid = hisid;
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

	public int getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(int userCreate) {
		this.userCreate = userCreate;
	}

}