package th.priisoft.crm.spring.entity.prii.padta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-03-21T23:22:48.662+0700")
@StaticMetamodel(AppCall.class)
public class AppCall_ {
	public static volatile SingularAttribute<AppCall, Long> appcallsid;
	public static volatile SingularAttribute<AppCall, Long> appid;
	public static volatile SingularAttribute<AppCall, Timestamp> appointment;
	public static volatile SingularAttribute<AppCall, Timestamp> dateCreate;
	public static volatile SingularAttribute<AppCall, Timestamp> dateRemider;
	public static volatile SingularAttribute<AppCall, Timestamp> dateUpdate;
	public static volatile SingularAttribute<AppCall, String> descTh;
	public static volatile SingularAttribute<AppCall, Integer> reasonid;
	public static volatile SingularAttribute<AppCall, String> remider;
	public static volatile SingularAttribute<AppCall, Integer> statusid;
	public static volatile SingularAttribute<AppCall, String> subject;
	public static volatile SingularAttribute<AppCall, Integer> useridCreate;
}
