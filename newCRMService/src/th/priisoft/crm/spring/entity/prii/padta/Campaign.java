package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;



@Entity
@Table(name="campaign")
@NamedQuery(name="Campaign.findAll", query="SELECT c FROM Campaign c")
public class Campaign implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long campaignid;

	@Column(name="agentdesc")
	private String agentDesc;

	private String campaignname;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	private int deleted;

	@Column(name="DESCTH")
	private String descTh;

	@Column(name="enddate")
	private Timestamp endDate;

	@Column(name="startdate")
	private Timestamp startDate;

	private String status;

	private BigDecimal target;

	@Column(name="useridcreate")
	private long useridCreate;
	
	@Column(name="gacampaign")
	private String gaCampaign;
	
	@Column(name="gaimport")
	private String gaImport;
	
	@Column(name="gaid")
	private String gaId;
	
	@Column(name="gamsg")
	private String gaMsg;
	
	public String getGaCampaign() {
		return gaCampaign;
	}

	public void setGaCampaign(String gaCampaign) {
		this.gaCampaign = gaCampaign;
	}

	public String getGaImport() {
		return gaImport;
	}

	public void setGaImport(String gaImport) {
		this.gaImport = gaImport;
	}

	@Transient
	private RefCampaignUser[] refCampaignUser;
	
	public Campaign() {
	}

	public long getCampaignid() {
		return this.campaignid;
	}

	public void setCampaignid(long campaignid) {
		this.campaignid = campaignid;
	}

	public String getAgentDesc() {
		return this.agentDesc;
	}

	public void setAgentDesc(String agentDesc) {
		this.agentDesc = agentDesc;
	}

	public String getCampaignname() {
		return this.campaignname;
	}

	public void setCampaignname(String campaignname) {
		this.campaignname = campaignname;
	}

	public Timestamp getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public int getDeleted() {
		return this.deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public String getDescTh() {
		return this.descTh;
	}

	public void setDescTh(String descTh) {
		this.descTh = descTh;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTarget() {
		return this.target;
	}

	public void setTarget(BigDecimal target) {
		this.target = target;
	}

	public long getUseridCreate() {
		return this.useridCreate;
	}

	public void setUseridCreate(long useridCreate) {
		this.useridCreate = useridCreate;
	}

	public RefCampaignUser[] getRefCampaignUser() {
		return refCampaignUser;
	}

	public void setRefCampaignUser(RefCampaignUser[] refCampaignUser) {
		this.refCampaignUser = refCampaignUser;
	}

	public String getGaId() {
		return gaId;
	}

	public void setGaId(String gaId) {
		this.gaId = gaId;
	}

	public String getGaMsg() {
		return gaMsg;
	}

	public void setGaMsg(String gaMsg) {
		this.gaMsg = gaMsg;
	}

	

}