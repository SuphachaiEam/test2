package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="submainquestion")
@NamedQuery(name="Submainquestion.findAll", query="SELECT q FROM Submainquestion q")
public class Submainquestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long smqid;

	private long mqid;
	
	@Column(name="fieldvalue")
	private String fieldvalue;

	@Column(name="fielddisplay")
	private String fielddisplay;

	@Column(name="fieldsize")
	private long fieldsize;
	
	@Column(name="fieldlimit")
	private long fieldlimit;

	@Column(name="defaultvalue")
	private String defaultvalue;
	
	public Submainquestion() {
	}

	public long getSmqid() {
		return smqid;
	}

	public void setSmqid(long smqid) {
		this.smqid = smqid;
	}

	public long getMqid() {
		return mqid;
	}

	public void setMqid(long mqid) {
		this.mqid = mqid;
	}

	public String getFieldvalue() {
		return fieldvalue;
	}

	public void setFieldvalue(String fieldvalue) {
		this.fieldvalue = fieldvalue;
	}

	public String getFielddisplay() {
		return fielddisplay;
	}

	public void setFielddisplay(String fielddisplay) {
		this.fielddisplay = fielddisplay;
	}

	public long getFieldsize() {
		return fieldsize;
	}

	public void setFieldsize(long fieldsize) {
		this.fieldsize = fieldsize;
	}

	public long getFieldlimit() {
		return fieldlimit;
	}

	public void setFieldlimit(long fieldlimit) {
		this.fieldlimit = fieldlimit;
	}

	public String getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	



	
}