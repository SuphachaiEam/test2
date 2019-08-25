package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;



@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCTID")
	private int productid;

	@Column(name="CREATEDATE")
	private Timestamp createDate;

	@Column(name="CREATEUSERID")
	private int createUserid;

	@Column(name="PRODUCTNAMEEN")
	private String productNameEn;

	@Column(name="PRODUCTNAMETH")
	private String productNameTh;

	//bi-directional many-to-one association to RefMaster
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private List<RefMaster> refMasters;

	public Product() {
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
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

	public String getProductNameEn() {
		return this.productNameEn;
	}

	public void setProductNameEn(String productNameEn) {
		this.productNameEn = productNameEn;
	}

	public String getProductNameTh() {
		return this.productNameTh;
	}

	public void setProductNameTh(String productNameTh) {
		this.productNameTh = productNameTh;
	}

	public List<RefMaster> getRefMasters() {
		return this.refMasters;
	}

	public void setRefMasters(List<RefMaster> refMasters) {
		this.refMasters = refMasters;
	}

	public RefMaster addRefMaster(RefMaster refMaster) {
		getRefMasters().add(refMaster);
		refMaster.setProduct(this);

		return refMaster;
	}

	public RefMaster removeRefMaster(RefMaster refMaster) {
		getRefMasters().remove(refMaster);
		refMaster.setProduct(null);

		return refMaster;
	}

}