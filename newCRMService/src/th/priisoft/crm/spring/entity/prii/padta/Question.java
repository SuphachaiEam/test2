package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="question")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long qid;

	private long appid;
	
	private long planid;
	
	@Column(name="questioncode")
	private String questioncode;

	@Column(name="questionresult")
	private String questionResult;

	@Transient
	private Mainquestion mainquestion;
	
	public Question() {
	}

	public long getQid() {
		return qid;
	}

	public void setQid(long qid) {
		this.qid = qid;
	}

	public long getAppid() {
		return appid;
	}

	public void setAppid(long appid) {
		this.appid = appid;
	}

	public long getPlanid() {
		return planid;
	}

	public void setPlanid(long planid) {
		this.planid = planid;
	}

	public String getQuestioncode() {
		return questioncode;
	}

	public void setQuestioncode(String questioncode) {
		this.questioncode = questioncode;
	}

	public String getQuestionResult() {
		return questionResult;
	}

	public void setQuestionResult(String questionResult) {
		this.questionResult = questionResult;
	}

	public Mainquestion getMainquestion() {
		return mainquestion;
	}

	public void setMainquestion(Mainquestion mainquestion) {
		this.mainquestion = mainquestion;
	}

	
	
}