package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="beneficiary")
@NamedQuery(name="Beneficiary.findAll", query="SELECT b FROM Beneficiary b")
public class Beneficiary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long beneficiaryid;

	private long clientid;

	private String name;

	private String relation;

	private String surname;

	public Beneficiary() {
	}

	public long getBeneficiaryid() {
		return this.beneficiaryid;
	}

	public void setBeneficiaryid(long beneficiaryid) {
		this.beneficiaryid = beneficiaryid;
	}

	public long getClientid() {
		return this.clientid;
	}

	public void setClientid(long clientid) {
		this.clientid = clientid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}