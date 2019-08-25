package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="planinsure")
@NamedQuery(name="Planinsure.findAll", query="SELECT p FROM Planinsure p")
public class Planinsure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int planinsureid;

	@Column(name="planinsureen")
	private String planinsureEn;

	@Column(name="planinsureth")
	private String planinsureTh;

	@Column(name="planinsurecode")
	private String planinsurecode;

	@Column(name="suminsure")
	private double suminsure;
	
	@Column(name="grosspremium")
	private double grosspremium;
	
	@Column(name="netpremium")
	private double netpremium;
	
	//bi-directional many-to-one association to Planhd
	@ManyToOne
	@JoinColumn(name="planid")
	private Planhd planhd;

	//bi- directional many-to-one association to Planoption
	@ManyToOne
	@JoinColumn(name="planoptionid")
	private Planoption planoption;

	public Planinsure() {
	}

	public int getPlaninsureid() {
		return this.planinsureid;
	}

	public void setPlaninsureid(int planinsureid) {
		this.planinsureid = planinsureid;
	}

	public String getPlaninsureEn() {
		return this.planinsureEn;
	}

	public void setPlaninsureEn(String planinsureEn) {
		this.planinsureEn = planinsureEn;
	}

	public String getPlaninsureTh() {
		return this.planinsureTh;
	}

	public void setPlaninsureTh(String planinsureTh) {
		this.planinsureTh = planinsureTh;
	}

	public String getPlaninsurecode() {
		return this.planinsurecode;
	}

	public void setPlaninsurecode(String planinsurecode) {
		this.planinsurecode = planinsurecode;
	}

	public Planhd getPlanhd() {
		return this.planhd;
	}

	public void setPlanhd(Planhd planhd) {
		this.planhd = planhd;
	}

	public Planoption getPlanoption() {
		return this.planoption;
	}

	public void setPlanoption(Planoption planoption) {
		this.planoption = planoption;
	}

	public double getSuminsure() {
		return suminsure;
	}

	public void setSuminsure(double suminsure) {
		this.suminsure = suminsure;
	}

	public double getGrosspremium() {
		return grosspremium;
	}

	public void setGrosspremium(double grosspremium) {
		this.grosspremium = grosspremium;
	}

	public double getNetpremium() {
		return netpremium;
	}

	public void setNetpremium(double netpremium) {
		this.netpremium = netpremium;
	}

}