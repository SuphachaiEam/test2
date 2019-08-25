package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import th.priisoft.crm.spring.entity.prii.crmdta.Bank;
import th.priisoft.crm.spring.entity.prii.crmdta.Cardtype;



@Entity
@Table(name="ref_bankcardplan")
@NamedQuery(name="RefBankCardPlan.findAll", query="SELECT r FROM RefBankCardPlan r")
public class RefBankCardPlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long bcpid;

	@JsonIgnore
	@Column(name="planpremid")
	private long planpremid;

	@JsonIgnore
	private long bankid;
	
	@JsonIgnore
	private long cardtypeid;
	
	@Transient
	private Planprem planprem;
	
	@Transient
	private Bank bank;
	
	@Transient
	private Cardtype cardtype;
	
	public RefBankCardPlan() {
	}

	public long getBcpid() {
		return bcpid;
	}

	public void setBcpid(long bcpid) {
		this.bcpid = bcpid;
	}

	public long getPlanpremid() {
		return planpremid;
	}

	public void setPlanpremid(long planpremid) {
		this.planpremid = planpremid;
	}

	public long getBankid() {
		return bankid;
	}

	public void setBankid(long bankid) {
		this.bankid = bankid;
	}

	public long getCardtypeid() {
		return cardtypeid;
	}

	public void setCardtypeid(long cardtypeid) {
		this.cardtypeid = cardtypeid;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Cardtype getCardtype() {
		return cardtype;
	}

	public void setCardtype(Cardtype cardtype) {
		this.cardtype = cardtype;
	}

	public Planprem getPlanprem() {
		return planprem;
	}

	public void setPlanprem(Planprem planprem) {
		this.planprem = planprem;
	}

	

}