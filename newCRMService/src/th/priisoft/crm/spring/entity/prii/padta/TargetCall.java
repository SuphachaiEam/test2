package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;

import th.priisoft.crm.spring.entity.prii.crmdta.Reason;
import th.priisoft.crm.spring.entity.prii.crmdta.Status;

import java.sql.Timestamp;



@Entity
@Table(name="target_calls")
@NamedQuery(name="TargetCall.findAll", query="SELECT t FROM TargetCall t")
public class TargetCall implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long targetcallsid;

	private Timestamp appointment;

	@Column(name="datecreate")
	private Timestamp dateCreate;

	@Column(name="dateremider")
	private Timestamp dateRemider;

	@Column(name="dateupdate")
	private Timestamp dateUpdate;

	@Column(name="descth")
	private String descTh;

	private long objid;

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
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Reason getReason() {
		return reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	public TargetCall() {
	}

	public long getTargetcallsid() {
		return this.targetcallsid;
	}

	public void setTargetcallsid(long targetcallsid) {
		this.targetcallsid = targetcallsid;
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

	public String getDescTh() {
		return this.descTh;
	}

	public void setDescTh(String descTh) {
		this.descTh = descTh;
	}

	public long getObjid() {
		return this.objid;
	}

	public void setObjid(long objid) {
		this.objid = objid;
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

}