package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="\"gender\"")
@NamedQuery(name="Gender.findAll", query="SELECT g FROM Gender g")
public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"genderid\"")
	private int genderid;

	@Column(name="\"gendercode\"")
	private String gendercode;

	@Column(name="\"gendernameth\"")
	private String gendernameth;
	
	@Column(name="\"gendernameen\"")
	private String gendernameen;
	
	public Gender() {
	}

	public int getGenderid() {
		return this.genderid;
	}

	public void setGenderid(int genderid) {
		this.genderid = genderid;
	}

	public String getGendercode() {
		return this.gendercode;
	}

	public void setGendercode(String gendercode) {
		this.gendercode = gendercode;
	}

	public String getGendernameth() {
		return gendernameth;
	}

	public void setGendernameth(String gendernameth) {
		this.gendernameth = gendernameth;
	}

	public String getGendernameen() {
		return gendernameen;
	}

	public void setGendernameen(String gendernameen) {
		this.gendernameen = gendernameen;
	}

}