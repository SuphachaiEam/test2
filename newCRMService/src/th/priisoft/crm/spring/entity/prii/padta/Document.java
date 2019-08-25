package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;



@Entity
@Table(name="documents")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long documentid;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	private boolean deleted;

	private String documentname;

	private String status;

	private String uid;
	
	@JsonIgnore
	@Transient
	private String doc;
	
	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	@Column(name="userid_create")
	private long useridCreate;

	public Document() {
	}

	public long getDocumentid() {
		return this.documentid;
	}

	public void setDocumentid(long documentid) {
		this.documentid = documentid;
	}

	public Timestamp getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getDocumentname() {
		return this.documentname;
	}

	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public long getUseridCreate() {
		return this.useridCreate;
	}

	public void setUseridCreate(long useridCreate) {
		this.useridCreate = useridCreate;
	}

}