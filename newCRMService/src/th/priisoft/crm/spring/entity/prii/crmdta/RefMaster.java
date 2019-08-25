package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;



@Entity
@Table(name="ref_master")
@NamedQuery(name="RefMaster.findAll", query="SELECT r FROM RefMaster r")
public class RefMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int rmid;
	
	@JsonIgnore
	@Column(name="CREATEDATE")
	private Timestamp createDate;
	
	@JsonIgnore
	@Column(name="CREATEUSERID")
	private int createUserid;

	//bi-directional many-to-one association to Partner
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="PARTNERID")
	private Partner partner;

	//bi-directional many-to-one association to Product
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private Product product;

	//bi-directional many-to-one association to Role
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="roleid")
	private Role role;

	//bi-directional many-to-one association to User
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;

	@Column(name="RMDESC")
	private String rmdesc;
	
	public String getRmdesc() {
		return rmdesc;
	}

	public void setRmdesc(String rmdesc) {
		this.rmdesc = rmdesc;
	}

	public RefMaster() {
	}

	public int getRmid() {
		return this.rmid;
	}

	public void setRmid(int rmid) {
		this.rmid = rmid;
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

	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}