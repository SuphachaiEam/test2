package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="cardtype")
@NamedQuery(name="Cardtype.findAll", query="SELECT c FROM Cardtype c")
public class Cardtype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cardtypeid;

	private String cardtypecode;

	@Column(name="cardtypedescen")
	private String cardtypedescEn;

	@Column(name="cardtypedescth")
	private String cardtypedescTh;
	
	public Cardtype() {
	}

	public int getCardtypeid() {
		return this.cardtypeid;
	}

	public void setCardtypeid(int cardtypeid) {
		this.cardtypeid = cardtypeid;
	}

	public String getCardtypecode() {
		return this.cardtypecode;
	}

	public void setCardtypecode(String cardtypecode) {
		this.cardtypecode = cardtypecode;
	}

	public String getCardtypedescEn() {
		return this.cardtypedescEn;
	}

	public void setCardtypedescEn(String cardtypedescEn) {
		this.cardtypedescEn = cardtypedescEn;
	}

	public String getCardtypedescTh() {
		return this.cardtypedescTh;
	}

	public void setCardtypedescTh(String cardtypedescTh) {
		this.cardtypedescTh = cardtypedescTh;
	}

	

}