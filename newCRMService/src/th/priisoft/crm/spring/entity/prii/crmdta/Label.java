package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="labels")
@NamedQuery(name="Label.findAll", query="SELECT l FROM Label l")
public class Label implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int labelid;

	private String labelcode;

	@Column(name="labeldescen")
	private String labeldescEn;

	@Column(name="labeldescth")
	private String labeldescTh;

	private String types;

	//bi-directional many-to-one association to Lov
	@OneToMany(mappedBy="label", fetch = FetchType.LAZY)
	private List<Lov> lovs;

	public Label() {
	}

	public int getLabelid() {
		return this.labelid;
	}

	public void setLabelid(int labelid) {
		this.labelid = labelid;
	}

	public String getLabelcode() {
		return this.labelcode;
	}

	public void setLabelcode(String labelcode) {
		this.labelcode = labelcode;
	}

	public String getLabeldescEn() {
		return this.labeldescEn;
	}

	public void setLabeldescEn(String labeldescEn) {
		this.labeldescEn = labeldescEn;
	}

	public String getLabeldescTh() {
		return this.labeldescTh;
	}

	public void setLabeldescTh(String labeldescTh) {
		this.labeldescTh = labeldescTh;
	}

	public String getTypes() {
		return this.types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public List<Lov> getLovs() {
		return this.lovs;
	}

	public void setLovs(List<Lov> lovs) {
		this.lovs = lovs;
	}

	public Lov addLov(Lov lov) {
		getLovs().add(lov);
		lov.setLabel(this);

		return lov;
	}

	public Lov removeLov(Lov lov) {
		getLovs().remove(lov);
		lov.setLabel(null);

		return lov;
	}

}