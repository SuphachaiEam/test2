package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="\"groupmenu\"")
@NamedQuery(name="Groupmenu.findAll", query="SELECT g FROM Groupmenu g")
public class Groupmenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"grpmenuid\"")
	private int grpmenuid;

	@Column(name="\"grpmenuNameEn\"")
	private String grpmenuNameEn;

	@Column(name="\"grpmenuNameTh\"")
	private String grpmenuNameTh;
	
	//bi-directional many-to-one association to TmpRoleMenu
	@JsonIgnore
	@OneToMany(mappedBy="groupmenu")
	private List<TmpRoleMenu> tmpRoleMenus;
	

	public Groupmenu() {
	}

	public int getGrpmenuid() {
		return this.grpmenuid;
	}

	public void setGrpmenuid(int grpmenuid) {
		this.grpmenuid = grpmenuid;
	}

	public String getGrpmenuNameEn() {
		return this.grpmenuNameEn;
	}

	public void setGrpmenuNameEn(String grpmenuNameEn) {
		this.grpmenuNameEn = grpmenuNameEn;
	}

	public String getGrpmenuNameTh() {
		return this.grpmenuNameTh;
	}

	public void setGrpmenuNameTh(String grpmenuNameTh) {
		this.grpmenuNameTh = grpmenuNameTh;
	}

}