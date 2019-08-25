package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name="hisgenesys")
@NamedQuery(name="Hisgenesy.findAll", query="SELECT h FROM Hisgenesy h")
public class Hisgenesy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long hgid;

	@Column(name="completedate")
	private Timestamp completeDate;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	private String filegenesys;

	@Column(name="hgname")
	private String hgName;

	@Column(name="numimport")
	private int numImport;

	@Column(name="useridcreate")
	private long useridCreate;

	public Hisgenesy() {
	}

	public long getHgid() {
		return this.hgid;
	}

	public void setHgid(long hgid) {
		this.hgid = hgid;
	}

	public Timestamp getCompleteDate() {
		return this.completeDate;
	}

	public void setCompleteDate(Timestamp completeDate) {
		this.completeDate = completeDate;
	}

	public Timestamp getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getFilegenesys() {
		return this.filegenesys;
	}

	public void setFilegenesys(String filegenesys) {
		this.filegenesys = filegenesys;
	}

	public String getHgName() {
		return this.hgName;
	}

	public void setHgName(String hgName) {
		this.hgName = hgName;
	}

	public int getNumImport() {
		return this.numImport;
	}

	public void setNumImport(int numImport) {
		this.numImport = numImport;
	}

	public long getUseridCreate() {
		return this.useridCreate;
	}

	public void setUseridCreate(long useridCreate) {
		this.useridCreate = useridCreate;
	}

}