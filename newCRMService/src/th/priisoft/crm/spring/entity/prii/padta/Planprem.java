package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="planprem")
public class Planprem implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planpremid;
	
	@JsonIgnore
	@Column(name="planinsureid")
	private int planinsureid;
	
	@Column(name="minage")
	private int minage;
	
	@Column(name="maxage")
	private int maxage;
	
	@Column(name="type")
	private int type;
	
	@Column(name="netprem1")
	private double netprem1;
	
	@Column(name="planpremname")
	private String planpremname;

	@Transient
	private Planinsure planinsure;
	
	public int getPlanpremid() {
		return planpremid;
	}

	public void setPlanpremid(int planpremid) {
		this.planpremid = planpremid;
	}

	public int getPlaninsureid() {
		return planinsureid;
	}

	public void setPlaninsureid(int planinsureid) {
		this.planinsureid = planinsureid;
	}

	public int getMinage() {
		return minage;
	}

	public void setMinage(int minage) {
		this.minage = minage;
	}

	public int getMaxage() {
		return maxage;
	}

	public void setMaxage(int maxage) {
		this.maxage = maxage;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getNetprem1() {
		return netprem1;
	}

	public void setNetprem1(double netprem1) {
		this.netprem1 = netprem1;
	}

	public String getPlanpremname() {
		return planpremname;
	}

	public void setPlanpremname(String planpremname) {
		this.planpremname = planpremname;
	}

	public Planinsure getPlaninsure() {
		return planinsure;
	}

	public void setPlaninsure(Planinsure planinsure) {
		this.planinsure = planinsure;
	}
	
	

}
