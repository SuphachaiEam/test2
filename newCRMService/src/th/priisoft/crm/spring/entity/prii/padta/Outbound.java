package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

import th.priisoft.crm.spring.entity.prii.crmdta.Status;

import java.sql.Date;
import java.sql.Timestamp;



@JsonIgnoreType(true)
@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="outbound")
@NamedQuery(name="Outbound.findAll", query="SELECT o FROM Outbound o")
public class Outbound implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long objid;

	private String address1;

	private String address2;

	private String address3;

	private String address4;

	private String address5;

	private String age;

	@Column(name="assigneduserid")
	private int assignedUserid;

	private Timestamp birthdate;

	private int birthyear;
	
	@JsonProperty( value = "campaignid", access = JsonProperty.Access.WRITE_ONLY)
	private long campaignid;

	private String cardno;

	@Column(name="chkbacklist")
	private String chkBacklist;

	@Column(name="chkdnc")
	private String chkDnc;

	@Column(name="chkduplicate")
	private String chkDuplicate;

	@Column(name="copyobjid")
	private long copyObjid;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	@Column(name="datemodify")
	private Timestamp dateModify;

	private boolean deleted;

	@Column(name="expirycard")
	private String expiryCard;

	private String gender;

	@Column(name="homeext")
	private String homeExt;

	@Column(name="homephone")
	private String homePhone;

	private double income;

	private String leadtype;

	@Column(name="mobilephone")
	private String mobilePhone;

	@Column(name="nameen")
	private String nameEn;

	@Column(name="nameth")
	private String nameTh;

	private String note1;

	private String note10;

	private String note2;

	private String note3;

	private String note4;

	private String note5;

	private String note6;

	private String note7;

	private String note8;

	private String note9;

	@Column(name="officeext")
	private String officeExt;

	@Column(name="officephone")
	private String officePhone;

	@Column(name="paycardtype")
	private String payCardType;

	private String province;

	@Column(name="REFERENCECODE")
	private String referenceCode;

	@Column(name="surnameen")
	private String surnameEn;

	@Column(name="surnameth")
	private String surnameTh;

	@Column(name="titleen")
	private String titleEn;

	@Column(name="titleth")
	private String titleTh;

	@Column(name="useridcreate")
	private int useridCreate;

	@Column(name="useridmodify")
	private int useridModify;
	
	@JsonProperty( value = "waveid", access = JsonProperty.Access.WRITE_ONLY)
	private long waveid;
	
	@JsonProperty( value = "statusid", access = JsonProperty.Access.WRITE_ONLY)
	private int statusid;
	
	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Transient
	private Campaign campaign;
	
	@Transient
	private Wavename wavename;
	
	@Transient
	private Status status;

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

	public Outbound() {
	}

	public long getObjid() {
		return this.objid;
	}

	public void setObjid(long objid) {
		this.objid = objid;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return this.address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getAddress5() {
		return this.address5;
	}

	public void setAddress5(String address5) {
		this.address5 = address5;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getAssignedUserid() {
		return this.assignedUserid;
	}

	public void setAssignedUserid(int assignedUserid) {
		this.assignedUserid = assignedUserid;
	}

	public Timestamp getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}

	public int getBirthyear() {
		return this.birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public long getCampaignid() {
		return this.campaignid;
	}

	public void setCampaignid(long campaignid) {
		this.campaignid = campaignid;
	}

	public String getCardno() {
		return this.cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getChkBacklist() {
		return this.chkBacklist;
	}

	public void setChkBacklist(String chkBacklist) {
		this.chkBacklist = chkBacklist;
	}

	public String getChkDnc() {
		return this.chkDnc;
	}

	public void setChkDnc(String chkDnc) {
		this.chkDnc = chkDnc;
	}

	public String getChkDuplicate() {
		return this.chkDuplicate;
	}

	public void setChkDuplicate(String chkDuplicate) {
		this.chkDuplicate = chkDuplicate;
	}

	public long getCopyObjid() {
		return this.copyObjid;
	}

	public void setCopyObjid(long copyObjid) {
		this.copyObjid = copyObjid;
	}

	public Timestamp getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Timestamp getDateModify() {
		return this.dateModify;
	}

	public void setDateModify(Timestamp dateModify) {
		this.dateModify = dateModify;
	}

	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getExpiryCard() {
		return this.expiryCard;
	}

	public void setExpiryCard(String expiryCard) {
		this.expiryCard = expiryCard;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHomeExt() {
		return this.homeExt;
	}

	public void setHomeExt(String homeExt) {
		this.homeExt = homeExt;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public double getIncome() {
		return this.income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getLeadtype() {
		return this.leadtype;
	}

	public void setLeadtype(String leadtype) {
		this.leadtype = leadtype;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameTh() {
		return this.nameTh;
	}

	public void setNameTh(String nameTh) {
		this.nameTh = nameTh;
	}

	public String getNote1() {
		return this.note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public String getNote10() {
		return this.note10;
	}

	public void setNote10(String note10) {
		this.note10 = note10;
	}

	public String getNote2() {
		return this.note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public String getNote3() {
		return this.note3;
	}

	public void setNote3(String note3) {
		this.note3 = note3;
	}

	public String getNote4() {
		return this.note4;
	}

	public void setNote4(String note4) {
		this.note4 = note4;
	}

	public String getNote5() {
		return this.note5;
	}

	public void setNote5(String note5) {
		this.note5 = note5;
	}

	public String getNote6() {
		return this.note6;
	}

	public void setNote6(String note6) {
		this.note6 = note6;
	}

	public String getNote7() {
		return this.note7;
	}

	public void setNote7(String note7) {
		this.note7 = note7;
	}

	public String getNote8() {
		return this.note8;
	}

	public void setNote8(String note8) {
		this.note8 = note8;
	}

	public String getNote9() {
		return this.note9;
	}

	public void setNote9(String note9) {
		this.note9 = note9;
	}

	public String getOfficeExt() {
		return this.officeExt;
	}

	public void setOfficeExt(String officeExt) {
		this.officeExt = officeExt;
	}

	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getPayCardType() {
		return this.payCardType;
	}

	public void setPayCardType(String payCardType) {
		this.payCardType = payCardType;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getReferenceCode() {
		return this.referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public String getSurnameEn() {
		return this.surnameEn;
	}

	public void setSurnameEn(String surnameEn) {
		this.surnameEn = surnameEn;
	}

	public String getSurnameTh() {
		return this.surnameTh;
	}

	public void setSurnameTh(String surnameTh) {
		this.surnameTh = surnameTh;
	}

	public String getTitleEn() {
		return this.titleEn;
	}

	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}

	public String getTitleTh() {
		return this.titleTh;
	}

	public void setTitleTh(String titleTh) {
		this.titleTh = titleTh;
	}

	public int getUseridCreate() {
		return this.useridCreate;
	}

	public void setUseridCreate(int useridCreate) {
		this.useridCreate = useridCreate;
	}

	public int getUseridModify() {
		return this.useridModify;
	}

	public void setUseridModify(int useridModify) {
		this.useridModify = useridModify;
	}

	public long getWaveid() {
		return this.waveid;
	}

	public void setWaveid(long waveid) {
		this.waveid = waveid;
	}

}