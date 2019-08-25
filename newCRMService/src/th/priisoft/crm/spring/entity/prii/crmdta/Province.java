package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.List;



@Entity
@Table(name="province")
@NamedQuery(name="Province.findAll", query="SELECT p FROM Province p")
public class Province implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pid")
	private long pid;

	@Column(name="provincecode")
	private String provincecode;

	@Column(name="provinceTh")
	private String provinceTh;

	@Column(name="provinceEn")
	private String provinceEn;

	
	public Province() {
	}


	public long getPid() {
		return pid;
	}


	public void setPid(long pid) {
		this.pid = pid;
	}


	public String getProvincecode() {
		return provincecode;
	}


	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}


	public String getProvinceTh() {
		return provinceTh;
	}


	public void setProvinceTh(String provinceTh) {
		this.provinceTh = provinceTh;
	}


	public String getProvinceEn() {
		return provinceEn;
	}


	public void setProvinceEn(String provinceEn) {
		this.provinceEn = provinceEn;
	}

	
}