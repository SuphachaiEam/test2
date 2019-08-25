package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name="campaign_users")
@NamedQuery(name="CampaignUser.findAll", query="SELECT c FROM CampaignUser c")
public class CampaignUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CampaignUserPK id;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	@Column(name="usercreate")
	private int userCreate;

	public CampaignUser() {
	}

	public CampaignUserPK getId() {
		return this.id;
	}

	public void setId(CampaignUserPK id) {
		this.id = id;
	}

	public Timestamp getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public int getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(int userCreate) {
		this.userCreate = userCreate;
	}

}