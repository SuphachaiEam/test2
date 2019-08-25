package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="ref_target_app")
@NamedQuery(name="RefTargetApp.findAll", query="SELECT r FROM RefTargetApp r")
public class RefTargetApp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rtaid;

	private long appid;

	private long objid;

	public RefTargetApp() {
	}

	public long getRtaid() {
		return this.rtaid;
	}

	public void setRtaid(long rtaid) {
		this.rtaid = rtaid;
	}

	public long getAppid() {
		return this.appid;
	}

	public void setAppid(long appid) {
		this.appid = appid;
	}

	public long getObjid() {
		return this.objid;
	}

	public void setObjid(long objid) {
		this.objid = objid;
	}

}