package th.priisoft.crm.spring.entity.prii.crmdta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-02-28T06:54:20.753+0700")
@StaticMetamodel(Logsession.class)
public class Logsession_ {
	public static volatile SingularAttribute<Logsession, Long> lsid;
	public static volatile SingularAttribute<Logsession, String> ipAddr;
	public static volatile SingularAttribute<Logsession, Timestamp> logdate;
	public static volatile SingularAttribute<Logsession, String> sessionid;
	public static volatile SingularAttribute<Logsession, Long> userid;
	public static volatile SingularAttribute<Logsession, Long> useridCreate;
}
