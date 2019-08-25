package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;



@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLEID")
	private int roleid;

	@Column(name="CREATEDATE")
	private Timestamp createDate;

	@Column(name="CREATEUSERID")
	private int createUserid;

	@Column(name="ROLENAMEEN")
	private String roleNameEn;

	@Column(name="ROLENAMETH")
	private String roleNameTh;

	@Column(name="ROLECODE")
	private String rolecode;
	
	//bi-directional many-to-one association to RefMaster
	@JsonIgnore
	@OneToMany(mappedBy="role")
	private List<RefMaster> refMasters;

	//bi-directional many-to-one association to TmpRoleMenu
	@JsonIgnore
	@OneToMany(mappedBy="role")
	private List<TmpRoleMenu> tmpRoleMenus;

	public Role() {
	}

	public int getRoleid() {
		return this.roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
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

	public String getRoleNameEn() {
		return this.roleNameEn;
	}

	public void setRoleNameEn(String roleNameEn) {
		this.roleNameEn = roleNameEn;
	}

	public String getRoleNameTh() {
		return this.roleNameTh;
	}

	public void setRoleNameTh(String roleNameTh) {
		this.roleNameTh = roleNameTh;
	}

	public List<RefMaster> getRefMasters() {
		return this.refMasters;
	}

	public void setRefMasters(List<RefMaster> refMasters) {
		this.refMasters = refMasters;
	}

	public RefMaster addRefMaster(RefMaster refMaster) {
		getRefMasters().add(refMaster);
		refMaster.setRole(this);

		return refMaster;
	}

	public RefMaster removeRefMaster(RefMaster refMaster) {
		getRefMasters().remove(refMaster);
		refMaster.setRole(null);

		return refMaster;
	}

	public List<TmpRoleMenu> getTmpRoleMenus() {
		return this.tmpRoleMenus;
	}

	public void setTmpRoleMenus(List<TmpRoleMenu> tmpRoleMenus) {
		this.tmpRoleMenus = tmpRoleMenus;
	}

	public TmpRoleMenu addTmpRoleMenus(TmpRoleMenu tmpRoleMenus) {
		getTmpRoleMenus().add(tmpRoleMenus);
		tmpRoleMenus.setRole(this);

		return tmpRoleMenus;
	}

	public TmpRoleMenu removeTmpRoleMenus(TmpRoleMenu tmpRoleMenus) {
		getTmpRoleMenus().remove(tmpRoleMenus);
		tmpRoleMenus.setRole(null);

		return tmpRoleMenus;
	}

	public String getRolecode() {
		return rolecode;
	}

	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}

}