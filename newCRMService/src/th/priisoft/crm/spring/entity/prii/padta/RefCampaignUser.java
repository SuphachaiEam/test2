package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="ref_campaign_user")
@NamedQuery(name="RefCampaignUser.findAll", query="SELECT r FROM RefCampaignUser r")
public class RefCampaignUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rcuid;

	private long campaignid;

	private int userid;

	public RefCampaignUser() {
	}

	public long getRcuid() {
		return this.rcuid;
	}

	public void setRcuid(long rcuid) {
		this.rcuid = rcuid;
	}

	public long getCampaignid() {
		return this.campaignid;
	}

	public void setCampaignid(long campaignid) {
		this.campaignid = campaignid;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}