package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="param")
@NamedQuery(name="Param.findAll", query="SELECT p FROM Param p")
public class Param implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paramid;

	private String paramcode;

	private String paramname;

	private String paramvalue;

	public Param() {
	}

	public int getParamid() {
		return this.paramid;
	}

	public void setParamid(int paramid) {
		this.paramid = paramid;
	}

	public String getParamcode() {
		return this.paramcode;
	}

	public void setParamcode(String paramcode) {
		this.paramcode = paramcode;
	}

	public String getParamname() {
		return this.paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	public String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

}