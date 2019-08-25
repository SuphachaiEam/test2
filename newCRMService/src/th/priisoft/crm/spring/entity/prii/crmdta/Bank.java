package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="bank")
@NamedQuery(name="Bank.findAll", query="SELECT b FROM Bank b")
public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bankid;

	private String bankcode;

	@Column(name="banknameen")
	private String banknameEn;

	@Column(name="banknameth")
	private String banknameTh;

	private String swiftcode;

	public Bank() {
	}

	public int getBankid() {
		return this.bankid;
	}

	public void setBankid(int bankid) {
		this.bankid = bankid;
	}

	public String getBankcode() {
		return this.bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getBanknameEn() {
		return this.banknameEn;
	}

	public void setBanknameEn(String banknameEn) {
		this.banknameEn = banknameEn;
	}

	public String getBanknameTh() {
		return this.banknameTh;
	}

	public void setBanknameTh(String banknameTh) {
		this.banknameTh = banknameTh;
	}

	public String getSwiftcode() {
		return this.swiftcode;
	}

	public void setSwiftcode(String swiftcode) {
		this.swiftcode = swiftcode;
	}

}