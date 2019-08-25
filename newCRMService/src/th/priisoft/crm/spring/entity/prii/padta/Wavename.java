package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



@Entity
@Table(name="wavename")
@NamedQuery(name="Wavename.findAll", query="SELECT w FROM Wavename w")
public class Wavename implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long waveid;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	private String filename;

	@Column(name="useridcreate")
	private long useridCreate;

	private String wavename;

	public Wavename() {
	}

	public long getWaveid() {
		return this.waveid;
	}

	public void setWaveid(long waveid) {
		this.waveid = waveid;
	}

	public Timestamp getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getUseridCreate() {
		return this.useridCreate;
	}

	public void setUseridCreate(long useridCreate) {
		this.useridCreate = useridCreate;
	}

	public String getWavename() {
		return this.wavename;
	}

	public void setWavename(String wavename) {
		this.wavename = wavename;
	}

}