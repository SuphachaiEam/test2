package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import java.util.List;

import th.priisoft.crm.spring.entity.prii.crmdta.Bank;
import th.priisoft.crm.spring.entity.prii.crmdta.Cardtype;

public class BankCard implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Bank bank;
	
	private List<Cardtype> lsCardtype;

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<Cardtype> getLsCardtype() {
		return lsCardtype;
	}

	public void setLsCardtype(List<Cardtype> lsCardtype) {
		this.lsCardtype = lsCardtype;
	}
	
	
}
