package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="\"titles\"")
@NamedQuery(name="Title.findAll", query="SELECT t FROM Title t")
public class Title implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"titleid\"")
	private int titleid;

	@Column(name="\"titlecode\"")
	private String titlecode;

	@Column(name="\"titleen\"")
	private String titleen;

	@Column(name="\"titleth\"")
	private String titleth;

	public Title() {
	}

	public int getTitleid() {
		return this.titleid;
	}

	public void setTitleid(int titleid) {
		this.titleid = titleid;
	}

	public String getTitlecode() {
		return this.titlecode;
	}

	public void setTitlecode(String titlecode) {
		this.titlecode = titlecode;
	}

	public String getTitleen() {
		return this.titleen;
	}

	public void setTitleen(String titleen) {
		this.titleen = titleen;
	}

	public String getTitleth() {
		return this.titleth;
	}

	public void setTitleth(String titleth) {
		this.titleth = titleth;
	}

}