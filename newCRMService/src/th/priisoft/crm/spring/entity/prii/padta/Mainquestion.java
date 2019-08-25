package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="mainquestion")
@NamedQuery(name="Mainquestion.findAll", query="SELECT q FROM Mainquestion q")
public class Mainquestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long mqid;

	private long planid;

	@Column(name="questioncode")
	private String questionCode;

	@Column(name="questiondesc")
	private String questionDesc;

	@Column(name="questiontype")
	private String questiontype;
	
	@Transient
	private Submainquestion[] submainquestion;
	
	public Mainquestion() {
	}

	public long getMqid() {
		return mqid;
	}

	public void setMqid(long mqid) {
		this.mqid = mqid;
	}

	public long getPlanid() {
		return planid;
	}

	public void setPlanid(long planid) {
		this.planid = planid;
	}

	public String getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

	public String getQuestionDesc() {
		return questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

	public String getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}

	public Submainquestion[] getSubmainquestion() {
		return submainquestion;
	}

	public void setSubmainquestion(Submainquestion[] submainquestion) {
		this.submainquestion = submainquestion;
	}



	
}