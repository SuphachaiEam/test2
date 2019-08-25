package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import th.priisoft.crm.spring.entity.prii.crmdta.Bank;
import th.priisoft.crm.spring.entity.prii.crmdta.Cardtype;
import th.priisoft.crm.spring.entity.prii.crmdta.Status;
import th.priisoft.crm.spring.entity.prii.crmdta.User;

import java.math.BigDecimal;
import java.sql.Timestamp;



@Entity
@Table(name="application")
@NamedQuery(name="Application.findAll", query="SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long appid;

	@Column(name="admindesc")
	private String admindesc;

	@Column(name="agentdesc")
	private String agentdesc;
	
	@JsonProperty( value = "bankid", access = JsonProperty.Access.WRITE_ONLY)
	private int bankid;

	@Column(name="bsremark1")
	private String bsremark1;

	@Column(name="bsremark2")
	private String bsremark2;

	@Column(name="bsremark3")
	private String bsremark3;

	@JsonProperty( value = "campaignid", access = JsonProperty.Access.WRITE_ONLY)
	private long campaignid;

	@JsonProperty( value = "cardtypeid", access = JsonProperty.Access.WRITE_ONLY)
	private int cardtypeid;

	private String chklist1;

	private String chklist10;

	private String chklist11;

	private String chklist12;

	private String chklist13;

	private String chklist14;

	private String chklist15;

	private String chklist2;

	private String chklist3;

	private String chklist4;

	private String chklist5;

	private String chklist6;

	private String chklist7;

	private String chklist8;

	private String chklist9;

	@Column(name="datecreate")
	private Timestamp datecreate;

	@Column(name="datesold")
	private Timestamp datesold;

	@Column(name="enddate")
	private String enddate;

	private String expiryofcard;

	private BigDecimal grosspremium;

	private String idcardofcard;

	private String nameofcard;

	private BigDecimal netpremium;

	private String nicelog;

	private String noofcard;

	private String noofcreditcard;

	private BigDecimal payofmonth;

	@JsonProperty( value = "planid", access = JsonProperty.Access.WRITE_ONLY)
	private long planid;

	@JsonProperty( value = "planinsureid", access = JsonProperty.Access.WRITE_ONLY)
	private long planinsureid;

	@JsonProperty( value = "planoptionid", access = JsonProperty.Access.WRITE_ONLY)
	private long planoptionid;

	@JsonProperty( value = "planpremid", access = JsonProperty.Access.WRITE_ONLY)
	private long planpremid;
	
	@Column(name="qcdate")
	private Timestamp qcdate;

	@Column(name="qcdescrefer")
	private String qcdescrefer;

	@Column(name="qcdesctsr")
	private String qcdesctsr;

	@JsonProperty( value = "qcuserid", access = JsonProperty.Access.WRITE_ONLY)
	@Column(name="qcuserid")
	private int qcuserid;

	private String refid;

	@Column(name="startdate")
	private String startdate;
	
	@JsonProperty( value = "statusid", access = JsonProperty.Access.WRITE_ONLY)
	private int statusid;

	private double suminsure;

	@Column(name="supervisordesc")
	private String supervisordesc;

	private String surnameofcard;

	private String taxsend;

	private String typeofpay;

	private String typeofsale;

	@JsonProperty( value = "useridcreate", access = JsonProperty.Access.WRITE_ONLY)
	@Column(name="useridcreate")
	private int useridcreate;
	
	@JsonProperty( value = "waveid", access = JsonProperty.Access.WRITE_ONLY)
	private long waveid;

	@Transient
	private Campaign campaign;
	
	@Transient
	private Wavename wavename;
	
	@Transient
	private Status status;
	
	@Transient
	private Bank bank;
	
	@Transient
	private Cardtype cardtype;
	
	@Transient
	private User qcuser;
	
	@Transient
	private User usercreate;
	
	@Transient 
	private Planhd planhd;
	
	@Transient
	private Planinsure planinsure;
	
	@Transient
	private Planoption planoption;
	
	@Transient
	private Planprem planprem;
	
	@Transient
	private Client[] client;
	
	@Transient
	private Question[] question;
		
	@Transient
	private RefTargetApp reftargetapp;
	
	public Application() {
	}

	public long getAppid() {
		return appid;
	}

	public void setAppid(long appid) {
		this.appid = appid;
	}

	public String getAdmindesc() {
		return admindesc;
	}

	public void setAdmindesc(String admindesc) {
		this.admindesc = admindesc;
	}

	public String getAgentdesc() {
		return agentdesc;
	}

	public void setAgentdesc(String agentdesc) {
		this.agentdesc = agentdesc;
	}

	public int getBankid() {
		return bankid;
	}

	public void setBankid(int bankid) {
		this.bankid = bankid;
	}

	public String getBsremark1() {
		return bsremark1;
	}

	public void setBsremark1(String bsremark1) {
		this.bsremark1 = bsremark1;
	}

	public String getBsremark2() {
		return bsremark2;
	}

	public void setBsremark2(String bsremark2) {
		this.bsremark2 = bsremark2;
	}

	public String getBsremark3() {
		return bsremark3;
	}

	public void setBsremark3(String bsremark3) {
		this.bsremark3 = bsremark3;
	}

	public long getCampaignid() {
		return campaignid;
	}

	public void setCampaignid(long campaignid) {
		this.campaignid = campaignid;
	}

	public int getCardtypeid() {
		return cardtypeid;
	}

	public void setCardtypeid(int cardtypeid) {
		this.cardtypeid = cardtypeid;
	}

	public String getChklist1() {
		return chklist1;
	}

	public void setChklist1(String chklist1) {
		this.chklist1 = chklist1;
	}

	public String getChklist10() {
		return chklist10;
	}

	public void setChklist10(String chklist10) {
		this.chklist10 = chklist10;
	}

	public String getChklist11() {
		return chklist11;
	}

	public void setChklist11(String chklist11) {
		this.chklist11 = chklist11;
	}

	public String getChklist12() {
		return chklist12;
	}

	public void setChklist12(String chklist12) {
		this.chklist12 = chklist12;
	}

	public String getChklist13() {
		return chklist13;
	}

	public void setChklist13(String chklist13) {
		this.chklist13 = chklist13;
	}

	public String getChklist14() {
		return chklist14;
	}

	public void setChklist14(String chklist14) {
		this.chklist14 = chklist14;
	}

	public String getChklist15() {
		return chklist15;
	}

	public void setChklist15(String chklist15) {
		this.chklist15 = chklist15;
	}

	public String getChklist2() {
		return chklist2;
	}

	public void setChklist2(String chklist2) {
		this.chklist2 = chklist2;
	}

	public String getChklist3() {
		return chklist3;
	}

	public void setChklist3(String chklist3) {
		this.chklist3 = chklist3;
	}

	public String getChklist4() {
		return chklist4;
	}

	public void setChklist4(String chklist4) {
		this.chklist4 = chklist4;
	}

	public String getChklist5() {
		return chklist5;
	}

	public void setChklist5(String chklist5) {
		this.chklist5 = chklist5;
	}

	public String getChklist6() {
		return chklist6;
	}

	public void setChklist6(String chklist6) {
		this.chklist6 = chklist6;
	}

	public String getChklist7() {
		return chklist7;
	}

	public void setChklist7(String chklist7) {
		this.chklist7 = chklist7;
	}

	public String getChklist8() {
		return chklist8;
	}

	public void setChklist8(String chklist8) {
		this.chklist8 = chklist8;
	}

	public String getChklist9() {
		return chklist9;
	}

	public void setChklist9(String chklist9) {
		this.chklist9 = chklist9;
	}

	public Timestamp getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(Timestamp datecreate) {
		this.datecreate = datecreate;
	}

	public Timestamp getDatesold() {
		return datesold;
	}

	public void setDatesold(Timestamp datesold) {
		this.datesold = datesold;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getExpiryofcard() {
		return expiryofcard;
	}

	public void setExpiryofcard(String expiryofcard) {
		this.expiryofcard = expiryofcard;
	}

	public BigDecimal getGrosspremium() {
		return grosspremium;
	}

	public void setGrosspremium(BigDecimal grosspremium) {
		this.grosspremium = grosspremium;
	}

	public String getIdcardofcard() {
		return idcardofcard;
	}

	public void setIdcardofcard(String idcardofcard) {
		this.idcardofcard = idcardofcard;
	}

	public String getNameofcard() {
		return nameofcard;
	}

	public void setNameofcard(String nameofcard) {
		this.nameofcard = nameofcard;
	}

	public BigDecimal getNetpremium() {
		return netpremium;
	}

	public void setNetpremium(BigDecimal netpremium) {
		this.netpremium = netpremium;
	}

	public String getNicelog() {
		return nicelog;
	}

	public void setNicelog(String nicelog) {
		this.nicelog = nicelog;
	}

	public String getNoofcard() {
		return noofcard;
	}

	public void setNoofcard(String noofcard) {
		this.noofcard = noofcard;
	}

	public String getNoofcreditcard() {
		return noofcreditcard;
	}

	public void setNoofcreditcard(String noofcreditcard) {
		this.noofcreditcard = noofcreditcard;
	}

	public BigDecimal getPayofmonth() {
		return payofmonth;
	}

	public void setPayofmonth(BigDecimal payofmonth) {
		this.payofmonth = payofmonth;
	}

	

	public Timestamp getQcdate() {
		return qcdate;
	}

	public void setQcdate(Timestamp qcdate) {
		this.qcdate = qcdate;
	}

	public String getQcdescrefer() {
		return qcdescrefer;
	}

	public void setQcdescrefer(String qcdescrefer) {
		this.qcdescrefer = qcdescrefer;
	}

	public String getQcdesctsr() {
		return qcdesctsr;
	}

	public void setQcdesctsr(String qcdesctsr) {
		this.qcdesctsr = qcdesctsr;
	}

	public int getQcuserid() {
		return qcuserid;
	}

	public void setQcuserid(int qcuserid) {
		this.qcuserid = qcuserid;
	}

	public String getRefid() {
		return refid;
	}

	public void setRefid(String refid) {
		this.refid = refid;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public double getSuminsure() {
		return suminsure;
	}

	public void setSuminsure(double suminsure) {
		this.suminsure = suminsure;
	}

	public String getSupervisordesc() {
		return supervisordesc;
	}

	public void setSupervisordesc(String supervisordesc) {
		this.supervisordesc = supervisordesc;
	}

	public String getSurnameofcard() {
		return surnameofcard;
	}

	public void setSurnameofcard(String surnameofcard) {
		this.surnameofcard = surnameofcard;
	}

	public String getTaxsend() {
		return taxsend;
	}

	public void setTaxsend(String taxsend) {
		this.taxsend = taxsend;
	}

	public String getTypeofpay() {
		return typeofpay;
	}

	public void setTypeofpay(String typeofpay) {
		this.typeofpay = typeofpay;
	}

	public String getTypeofsale() {
		return typeofsale;
	}

	public void setTypeofsale(String typeofsale) {
		this.typeofsale = typeofsale;
	}

	public int getUseridcreate() {
		return useridcreate;
	}

	public void setUseridcreate(int useridcreate) {
		this.useridcreate = useridcreate;
	}

	public long getWaveid() {
		return waveid;
	}

	public void setWaveid(long waveid) {
		this.waveid = waveid;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public Wavename getWavename() {
		return wavename;
	}

	public void setWavename(Wavename wavename) {
		this.wavename = wavename;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Cardtype getCardtype() {
		return cardtype;
	}

	public void setCardtype(Cardtype cardtype) {
		this.cardtype = cardtype;
	}

	public User getQcuser() {
		return qcuser;
	}

	public void setQcuser(User qcuser) {
		this.qcuser = qcuser;
	}

	public User getUsercreate() {
		return usercreate;
	}

	public void setUsercreate(User usercreate) {
		this.usercreate = usercreate;
	}

	public Planhd getPlanhd() {
		return planhd;
	}

	public void setPlanhd(Planhd planhd) {
		this.planhd = planhd;
	}

	public Planinsure getPlaninsure() {
		return planinsure;
	}

	public void setPlaninsure(Planinsure planinsure) {
		this.planinsure = planinsure;
	}

	public Planoption getPlanoption() {
		return planoption;
	}

	public void setPlanoption(Planoption planoption) {
		this.planoption = planoption;
	}

	public Client[] getClient() {
		return client;
	}

	public void setClient(Client[] client) {
		this.client = client;
	}

	public Question[] getQuestion() {
		return question;
	}

	public void setQuestion(Question[] question) {
		this.question = question;
	}

	public RefTargetApp getReftargetapp() {
		return reftargetapp;
	}

	public void setReftargetapp(RefTargetApp reftargetapp) {
		this.reftargetapp = reftargetapp;
	}

	public long getPlanid() {
		return planid;
	}

	public void setPlanid(long planid) {
		this.planid = planid;
	}

	public long getPlaninsureid() {
		return planinsureid;
	}

	public void setPlaninsureid(long planinsureid) {
		this.planinsureid = planinsureid;
	}

	public long getPlanoptionid() {
		return planoptionid;
	}

	public void setPlanoptionid(long planoptionid) {
		this.planoptionid = planoptionid;
	}

	public long getPlanpremid() {
		return planpremid;
	}

	public void setPlanpremid(long planpremid) {
		this.planpremid = planpremid;
	}

	public Planprem getPlanprem() {
		return planprem;
	}

	public void setPlanprem(Planprem planprem) {
		this.planprem = planprem;
	}

	

}
