package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;

import th.priisoft.crm.spring.entity.prii.crmdta.Reason;
import th.priisoft.crm.spring.entity.prii.crmdta.Status;

import java.sql.Timestamp;



@Entity
@Table(name="app_calls")
@NamedQuery(name="AppCall.findAll", query="SELECT a FROM AppCall a")
public class AppCall implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long appcallsid;

	private long appid;

	private Timestamp appointment;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	@Column(name="dateremider")
	private Timestamp dateRemider;

	@Column(name="dateupdate")
	private Timestamp dateUpdate;

	@Column(name="descth")
	private String descTh;

	private int reasonid;

	private String remider;

	private int statusid;

	private String subject;

	@Column(name="useridcreate")
	private int useridCreate;
	
	@Transient
	private Reason reason;
	
	@Transient
	private Status status;

	public Reason getReason() {
		return reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public AppCall() {
	}

	public long getAppcallsid() {
		return this.appcallsid;
	}

	public void setAppcallsid(long appcallsid) {
		this.appcallsid = appcallsid;
	}

	public long getAppid() {
		return this.appid;
	}

	public void setAppid(long appid) {
		this.appid = appid;
	}

	public Timestamp getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Timestamp appointment) {
		this.appointment = appointment;
	}

	public Timestamp getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Timestamp getDateRemider() {
		return this.dateRemider;
	}

	public void setDateRemider(Timestamp dateRemider) {
		this.dateRemider = dateRemider;
	}

	public Timestamp getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Timestamp dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	
	public int getReasonid() {
		return this.reasonid;
	}

	public void setReasonid(int reasonid) {
		this.reasonid = reasonid;
	}

	public String getRemider() {
		return this.remider;
	}

	public void setRemider(String remider) {
		this.remider = remider;
	}

	public int getStatusid() {
		return this.statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getUseridCreate() {
		return this.useridCreate;
	}

	public void setUseridCreate(int useridCreate) {
		this.useridCreate = useridCreate;
	}

	public String getDescTh() {
		return descTh;
	}

	public void setDescTh(String descTh) {
		this.descTh = descTh;
	}

}