package th.priisoft.crm.spring.entity.crmdta;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="roles")
public class RolesEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLEID")
	private int roleid;

	@Column(name="ROLE_NAME_TH")
	private String role_name_th;

	@Column(name="ROLE_NAME_EN")
	private String role_name_en;

	@Column(name="CREATE_DATE")
	private Timestamp create_date;

	@Column(name="CREATE_USERID")
	private String create_userid;

	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRole_name_th() {
		return role_name_th;
	}
	public void setRole_name_th(String role_name_th) {
		this.role_name_th = role_name_th;
	}
	public String getRole_name_en() {
		return role_name_en;
	}
	public void setRole_name_en(String role_name_en) {
		this.role_name_en = role_name_en;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public String getCreate_userid() {
		return create_userid;
	}
	public void setCreate_userid(String create_userid) {
		this.create_userid = create_userid;
	}
	

}