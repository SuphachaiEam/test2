package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="v_fulluser")
public class VfullUser implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="rmid")
	private int rmid;
	
	@Column(name="rmdesc")
	private String rmdesc;
	
	@Column(name="USERID")
	private int userid;
	
	@Column(name="LOGONID")
	private String logonid;
	
	@Column(name="LOGONAD")
	private String logonad;
	
	@Column(name="FNAME")
	private String fname;
	
	@Column(name="LNAME")
	private String lname;
	
	@Column(name="LICENSENO")
	private String licenseno;
	
	@Column(name="LICENSESDATE")
	private Timestamp licenseSDate;
	
	@Column(name="LICENSEEDATE")
	private Timestamp licenseEDate;
	
	@Column(name="TYPES")
	private String types;
	
	@Column(name="DETAIL")
	private String detail;
	
	@Column(name="CREATEDATE")
	private Timestamp createDate;

	@Column(name="CREATEUSERID")
	private int createUserid;
	
	@Column(name="ACTIVE")
	private String active;
	
	@Column(name="PARTNERID")
	private int partnerid;
	
	@Column(name="PARTNERNAMEEN")
	private String partnerNameEn;

	@Column(name="PARTNERNAMETH")
	private String partnerNameTh;
	
	@Column(name="PRODUCTID")
	private int productid;
	
	@Column(name="PRODUCTNAMEEN")
	private String productNameEn;

	@Column(name="PRODUCTNAMETH")
	private String productNameTh;
	
	@Column(name="ROLEID")
	private int roleid;
	
	@Column(name="ROLENAMEEN")
	private String roleNameEn;

	@Column(name="ROLENAMETH")
	private String roleNameTh;

	@Column(name="ROLECODE")
	private String rolecode;
	
	public int getRmid() {
		return rmid;
	}

	public void setRmid(int rmid) {
		this.rmid = rmid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getLogonid() {
		return logonid;
	}

	public void setLogonid(String logonid) {
		this.logonid = logonid;
	}

	public String getLogonad() {
		return logonad;
	}

	public void setLogonad(String logonad) {
		this.logonad = logonad;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLicenseno() {
		return licenseno;
	}

	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}

	public Timestamp getLicenseSDate() {
		return licenseSDate;
	}

	public void setLicenseSDate(Timestamp licenseSDate) {
		this.licenseSDate = licenseSDate;
	}

	public Timestamp getLicenseEDate() {
		return licenseEDate;
	}

	public void setLicenseEDate(Timestamp licenseEDate) {
		this.licenseEDate = licenseEDate;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getCreateUserid() {
		return createUserid;
	}

	public void setCreateUserid(int createUserid) {
		this.createUserid = createUserid;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public int getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(int partnerid) {
		this.partnerid = partnerid;
	}

	public String getPartnerNameEn() {
		return partnerNameEn;
	}

	public void setPartnerNameEn(String partnerNameEn) {
		this.partnerNameEn = partnerNameEn;
	}

	public String getPartnerNameTh() {
		return partnerNameTh;
	}

	public void setPartnerNameTh(String partnerNameTh) {
		this.partnerNameTh = partnerNameTh;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductNameEn() {
		return productNameEn;
	}

	public void setProductNameEn(String productNameEn) {
		this.productNameEn = productNameEn;
	}

	public String getProductNameTh() {
		return productNameTh;
	}

	public void setProductNameTh(String productNameTh) {
		this.productNameTh = productNameTh;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRoleNameEn() {
		return roleNameEn;
	}

	public void setRoleNameEn(String roleNameEn) {
		this.roleNameEn = roleNameEn;
	}

	public String getRoleNameTh() {
		return roleNameTh;
	}

	public void setRoleNameTh(String roleNameTh) {
		this.roleNameTh = roleNameTh;
	}

	@Override
	public String toString() {
		return "VfullUser [rmid=" + rmid + ", userid=" + userid + ", logonid=" + logonid + ", logonad=" + logonad
				+ ", fname=" + fname + ", lname=" + lname + ", licenseno=" + licenseno + ", licenseSDate="
				+ licenseSDate + ", licenseEDate=" + licenseEDate + ", types=" + types + ", detail=" + detail
				+ ", createDate=" + createDate + ", createUserid=" + createUserid + ", active=" + active
				+ ", partnerid=" + partnerid + ", partnerNameEn=" + partnerNameEn + ", partnerNameTh=" + partnerNameTh
				+ ", productid=" + productid + ", productNameEn=" + productNameEn + ", productNameTh=" + productNameTh
				+ ", roleid=" + roleid + ", roleNameEn=" + roleNameEn + ", roleNameTh=" + roleNameTh + "]";
	}

	public String getRmdesc() {
		return rmdesc;
	}

	public void setRmdesc(String rmdesc) {
		this.rmdesc = rmdesc;
	}

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}
	
	
}
