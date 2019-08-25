package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;



@Entity
@Table(name="planoption")
@NamedQuery(name="Planoption.findAll", query="SELECT p FROM Planoption p")
public class Planoption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int planoptionid;

	@Column(name="planoptionen")
	private String planoptionEn;

	@Column(name="planoptionth")
	private String planoptionTh;

	private String planoptioncode;
	
	@Column(name="person")
	private long person;

	//bi-directional many-to-one association to Planinsure
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy="planoption")
	private List<Planinsure> planinsures;

	//bi-directional many-to-one association to Planhd
	@ManyToOne
	@JoinColumn(name="planid")
	private Planhd planhd;

	public Planoption() {
	}

	public int getPlanoptionid() {
		return this.planoptionid;
	}

	public void setPlanoptionid(int planoptionid) {
		this.planoptionid = planoptionid;
	}

	public String getPlanoptionEn() {
		return this.planoptionEn;
	}

	public void setPlanoptionEn(String planoptionEn) {
		this.planoptionEn = planoptionEn;
	}

	public String getPlanoptionTh() {
		return this.planoptionTh;
	}

	public void setPlanoptionTh(String planoptionTh) {
		this.planoptionTh = planoptionTh;
	}

	public String getPlanoptioncode() {
		return this.planoptioncode;
	}

	public void setPlanoptioncode(String planoptioncode) {
		this.planoptioncode = planoptioncode;
	}

	public List<Planinsure> getPlaninsures() {
		return this.planinsures;
	}

	public void setPlaninsures(List<Planinsure> planinsures) {
		this.planinsures = planinsures;
	}

	public Planinsure addPlaninsure(Planinsure planinsure) {
		getPlaninsures().add(planinsure);
		planinsure.setPlanoption(this);

		return planinsure;
	}

	public Planinsure removePlaninsure(Planinsure planinsure) {
		getPlaninsures().remove(planinsure);
		planinsure.setPlanoption(null);

		return planinsure;
	}

	public Planhd getPlanhd() {
		return this.planhd;
	}

	public void setPlanhd(Planhd planhd) {
		this.planhd = planhd;
	}

	public long getPerson() {
		return person;
	}

	public void setPerson(long person) {
		this.person = person;
	}

}