package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;



@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USERID")
	private int userid;

	@Column(name="ACTIVE")
	private String active;

	@Column(name="CREATEDATE")
	private Timestamp createDate;

	@JsonIgnore
	@Column(name="CREATEUSERID")
	private int createUserid;

	@Column(name="DETAIL")
	private String detail;

	@Column(name="FNAME")
	private String fname;

	@Column(name="LICENSEEDATE")
	private Timestamp licenseEDate;

	@Column(name="LICENSESDATE")
	private Timestamp licenseSDate;

	@Column(name="LICENSENO")
	private String licenseno;

	@Column(name="LNAME")
	private String lname;

	@Column(name="LOGONAD")
	private String logonad;

	@Column(name="LOGONID")
	private String logonid;

	@Column(name="TYPES")
	private String types;

	
	@Transient
	private User usercreate;
	
	//bi-directional many-to-one association to RefMaster
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<RefMaster> refMasters;

	public User() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getCreateUserid() {
		return this.createUserid;
	}

	public void setCreateUserid(int createUserid) {
		this.createUserid = createUserid;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Timestamp getLicenseEDate() {
		return this.licenseEDate;
	}

	public void setLicenseEDate(Timestamp licenseEDate) {
		this.licenseEDate = licenseEDate;
	}

	public Timestamp getLicenseSDate() {
		return this.licenseSDate;
	}

	public void setLicenseSDate(Timestamp licenseSDate) {
		this.licenseSDate = licenseSDate;
	}

	public String getLicenseno() {
		return this.licenseno;
	}

	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLogonad() {
		return this.logonad;
	}

	public void setLogonad(String logonad) {
		this.logonad = logonad;
	}

	public String getLogonid() {
		return this.logonid;
	}

	public void setLogonid(String logonid) {
		this.logonid = logonid;
	}

	public String getTypes() {
		return this.types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public List<RefMaster> getRefMasters() {
		return this.refMasters;
	}

	public void setRefMasters(List<RefMaster> refMasters) {
		this.refMasters = refMasters;
	}

	public RefMaster addRefMaster(RefMaster refMaster) {
		getRefMasters().add(refMaster);
		refMaster.setUser(this);

		return refMaster;
	}

	public RefMaster removeRefMaster(RefMaster refMaster) {
		getRefMasters().remove(refMaster);
		refMaster.setUser(null);

		return refMaster;
	}

	public User getUsercreate() {
		return usercreate;
	}

	public void setUsercreate(User usercreate) {
		this.usercreate = usercreate;
	}

}