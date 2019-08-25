package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;



@Entity
@Table(name="menu")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MENUID")
	private int menuid;

	@Column(name="CREATEDATE")
	private Timestamp createDate;

	@Column(name="CREATEUSERID")
	private int createUserid;

	@Column(name="MENUNAMEEN")
	private String menuNameEn;

	@Column(name="MENUNAMETH")
	private String menuNameTh;
	
	@Column(name="GRPMENUID")
	private int grpmenuid;
	
	//bi-directional many-to-one association to TmpRoleMenu
	@JsonIgnore
	@OneToMany(mappedBy="menu")
	private List<TmpRoleMenu> tmpRoleMenus;


	
	public Menu() {
	}

	public int getMenuid() {
		return this.menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
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

	public String getMenuNameEn() {
		return this.menuNameEn;
	}

	public void setMenuNameEn(String menuNameEn) {
		this.menuNameEn = menuNameEn;
	}

	public String getMenuNameTh() {
		return this.menuNameTh;
	}

	public void setMenuNameTh(String menuNameTh) {
		this.menuNameTh = menuNameTh;
	}

	public List<TmpRoleMenu> getTmpRoleMenus() {
		return this.tmpRoleMenus;
	}

	public void setTmpRoleMenus(List<TmpRoleMenu> tmpRoleMenus) {
		this.tmpRoleMenus = tmpRoleMenus;
	}

	public TmpRoleMenu addTmpRoleMenus(TmpRoleMenu tmpRoleMenus) {
		getTmpRoleMenus().add(tmpRoleMenus);
		tmpRoleMenus.setMenu(this);

		return tmpRoleMenus;
	}

	public TmpRoleMenu removeTmpRoleMenus(TmpRoleMenu tmpRoleMenus) {
		getTmpRoleMenus().remove(tmpRoleMenus);
		tmpRoleMenus.setMenu(null);

		return tmpRoleMenus;
	}

	public int getGrpmenuid() {
		return grpmenuid;
	}

	public void setGrpmenuid(int grpmenuid) {
		this.grpmenuid = grpmenuid;
	}

}