package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name="\"usersHis\"")
@NamedQuery(name="UsersHi.findAll", query="SELECT u FROM UsersHi u")
public class UsersHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"userhisid\"")
	private int userhisid;

	@Column(name="\"act\"")
	private String act;

	@Column(name="CREATEDATE")
	private Timestamp createDate;

	@Column(name="CREATEUSERID")
	private int createUserid;

	@Column(name="\"jsonStr\"")
	private String jsonStr;

	private int rmid;
	
	public UsersHi() {
	}

	public int getUserhisid() {
		return this.userhisid;
	}

	public void setUserhisid(int userhisid) {
		this.userhisid = userhisid;
	}

	public String getAct() {
		return this.act;
	}

	public void setAct(String act) {
		this.act = act;
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

	public String getJsonStr() {
		return this.jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}

	public int getRmid() {
		return rmid;
	}

	public void setRmid(int rmid) {
		this.rmid = rmid;
	}

}