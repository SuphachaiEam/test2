package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name="\"tmp_role_menu\"")
@NamedQuery(name="TmpRoleMenu.findAll", query="SELECT t FROM TmpRoleMenu t")
public class TmpRoleMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"trmid\"")
	private int trmid;

	private String active;

	@Column(name="CREATEDATE")
	private Timestamp createDate;

	@Column(name="CREATEUSERID")
	private int createUserid;

	@Column(name="RACCESS")
	private int rAccess;

	@Column(name="RASSIGN")
	private int rAssign;

	@Column(name="RCOPY")
	private int rCopy;

	@Column(name="RCREATE")
	private int rCreate;

	@Column(name="RDELETE")
	private int rDelete;

	@Column(name="REDIT")
	private int rEdit;

	@Column(name="REXPORT")
	private int rExport;

	@Column(name="RIMPORT")
	private int rImport;

	@Column(name="RLIST")
	private int rList;

	@Column(name="RREJECT")
	private int rReject;

	@Column(name="RVIEW")
	private int rView;

	@ManyToOne
	@JoinColumn(name="menuid")
	private Menu menu;

	//bi-directional many-to-one association to Role

	@ManyToOne
	@JoinColumn(name="roleid")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="grpmenuid")
	private Groupmenu groupmenu;
	
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Groupmenu getGroupmenu() {
		return groupmenu;
	}

	public void setGroupmenu(Groupmenu groupmenu) {
		this.groupmenu = groupmenu;
	}

	public TmpRoleMenu() {
	}

	public int getTrmid() {
		return this.trmid;
	}

	public void setTrmid(int trmid) {
		this.trmid = trmid;
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

	public int getRAccess() {
		return this.rAccess;
	}

	public void setRAccess(int rAccess) {
		this.rAccess = rAccess;
	}

	public int getRAssign() {
		return this.rAssign;
	}

	public void setRAssign(int rAssign) {
		this.rAssign = rAssign;
	}

	public int getRCopy() {
		return this.rCopy;
	}

	public void setRCopy(int rCopy) {
		this.rCopy = rCopy;
	}

	public int getRCreate() {
		return this.rCreate;
	}

	public void setRCreate(int rCreate) {
		this.rCreate = rCreate;
	}

	public int getRDelete() {
		return this.rDelete;
	}

	public void setRDelete(int rDelete) {
		this.rDelete = rDelete;
	}

	public int getREdit() {
		return this.rEdit;
	}

	public void setREdit(int rEdit) {
		this.rEdit = rEdit;
	}

	public int getRExport() {
		return this.rExport;
	}

	public void setRExport(int rExport) {
		this.rExport = rExport;
	}

	public int getRImport() {
		return this.rImport;
	}

	public void setRImport(int rImport) {
		this.rImport = rImport;
	}

	public int getRList() {
		return this.rList;
	}

	public void setRList(int rList) {
		this.rList = rList;
	}

	public int getRReject() {
		return this.rReject;
	}

	public void setRReject(int rReject) {
		this.rReject = rReject;
	}

	public int getRView() {
		return this.rView;
	}

	public void setRView(int rView) {
		this.rView = rView;
	}


}