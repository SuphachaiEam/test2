package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;



@Entity
@Table(name="planhd")
@NamedQuery(name="Planhd.findAll", query="SELECT p FROM Planhd p")
public class Planhd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long planid;

	private String active;

	@Column(name="dateform")
	private Timestamp dateForm;

	@Column(name="dateto")
	private Timestamp dateTo;

	private String plancode;

	@Column(name="plandescen")
	private String plandescEn;

	@Column(name="plandescth")
	private String plandescTh;

	private double target;

	//bi-directional many-to-one association to Planinsure
	@JsonIgnore
	@OneToMany(mappedBy="planhd")
	private List<Planinsure> planinsures;

	@JsonIgnore
	//bi-directional many-to-one association to Planoption
	@OneToMany(mappedBy="planhd")
	private List<Planoption> planoptions;

	@Transient
	private List<Mainquestion> mainquestion;
	
	public Planhd() {
	}

	public long getPlanid() {
		return this.planid;
	}

	public void setPlanid(long planid) {
		this.planid = planid;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Timestamp getDateForm() {
		return this.dateForm;
	}

	public void setDateForm(Timestamp dateForm) {
		this.dateForm = dateForm;
	}

	public Timestamp getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Timestamp dateTo) {
		this.dateTo = dateTo;
	}

	public String getPlancode() {
		return this.plancode;
	}

	public void setPlancode(String plancode) {
		this.plancode = plancode;
	}

	public String getPlandescEn() {
		return this.plandescEn;
	}

	public void setPlandescEn(String plandescEn) {
		this.plandescEn = plandescEn;
	}

	public String getPlandescTh() {
		return this.plandescTh;
	}

	public void setPlandescTh(String plandescTh) {
		this.plandescTh = plandescTh;
	}

	public double getTarget() {
		return this.target;
	}

	public void setTarget(double target) {
		this.target = target;
	}

	public List<Planinsure> getPlaninsures() {
		return this.planinsures;
	}

	public void setPlaninsures(List<Planinsure> planinsures) {
		this.planinsures = planinsures;
	}

	public Planinsure addPlaninsure(Planinsure planinsure) {
		getPlaninsures().add(planinsure);
		planinsure.setPlanhd(this);

		return planinsure;
	}

	public Planinsure removePlaninsure(Planinsure planinsure) {
		getPlaninsures().remove(planinsure);
		planinsure.setPlanhd(null);

		return planinsure;
	}

	public List<Planoption> getPlanoptions() {
		return this.planoptions;
	}

	public void setPlanoptions(List<Planoption> planoptions) {
		this.planoptions = planoptions;
	}

	public Planoption addPlanoption(Planoption planoption) {
		getPlanoptions().add(planoption);
		planoption.setPlanhd(this);

		return planoption;
	}

	public Planoption removePlanoption(Planoption planoption) {
		getPlanoptions().remove(planoption);
		planoption.setPlanhd(null);

		return planoption;
	}

	public List<Mainquestion> getMainquestion() {
		return mainquestion;
	}

	public void setMainquestion(List<Mainquestion> mainquestion) {
		this.mainquestion = mainquestion;
	}

	

}