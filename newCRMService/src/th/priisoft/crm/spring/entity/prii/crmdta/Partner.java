package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;



@Entity
@Table(name="partner")
@NamedQuery(name="Partner.findAll", query="SELECT p FROM Partner p")
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PARTNERID")
	private int partnerid;

	@Column(name="CREATEDATE")
	private Timestamp createDate;

	@Column(name="CREATEUSERID")
	private int createUserid;

	@Column(name="PARTNERNAMEEN")
	private String partnerNameEn;

	@Column(name="PARTNERNAMETH")
	private String partnerNameTh;
	
	@JsonIgnore
	@Column(name="PRIVATEKEY")
	private String privateKey;
	
	@JsonIgnore
	@Column(name="PUBLICKEY")
	private String publicKey;

	//bi-directional many-to-one association to RefMaster
	@JsonIgnore
	@OneToMany(mappedBy="partner")
	private List<RefMaster> refMasters;

	public Partner() {
	}

	public int getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(int partnerid) {
		this.partnerid = partnerid;
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

	public String getPartnerNameEn() {
		return this.partnerNameEn;
	}

	public void setPartnerNameEn(String partnerNameEn) {
		this.partnerNameEn = partnerNameEn;
	}

	public String getPartnerNameTh() {
		return this.partnerNameTh;
	}

	public void setPartnerNameTh(String partnerNameTh) {
		this.partnerNameTh = partnerNameTh;
	}

	public String getPrivateKey() {
		return this.privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return this.publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public List<RefMaster> getRefMasters() {
		return this.refMasters;
	}

	public void setRefMasters(List<RefMaster> refMasters) {
		this.refMasters = refMasters;
	}

	public RefMaster addRefMaster(RefMaster refMaster) {
		getRefMasters().add(refMaster);
		refMaster.setPartner(this);

		return refMaster;
	}

	public RefMaster removeRefMaster(RefMaster refMaster) {
		getRefMasters().remove(refMaster);
		refMaster.setPartner(null);

		return refMaster;
	}

}