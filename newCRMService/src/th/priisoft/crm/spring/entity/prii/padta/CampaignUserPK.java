package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;


@Embeddable
public class CampaignUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long campaignid;

	private int userid;

	public CampaignUserPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CampaignUserPK)) {
			return false;
		}
		CampaignUserPK castOther = (CampaignUserPK)other;
		return 
			(this.campaignid == castOther.campaignid)
			&& (this.userid == castOther.userid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.campaignid ^ (this.campaignid >>> 32)));
		hash = hash * prime + this.userid;
		
		return hash;
	}
}