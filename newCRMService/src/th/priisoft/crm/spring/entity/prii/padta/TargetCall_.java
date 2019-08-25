package th.priisoft.crm.spring.entity.prii.padta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-03-17T19:09:36.613+0700")
@StaticMetamodel(TargetCall.class)
public class TargetCall_ {
	public static volatile SingularAttribute<TargetCall, Long> targetcallsid;
	public static volatile SingularAttribute<TargetCall, Timestamp> appointment;
	public static volatile SingularAttribute<TargetCall, Timestamp> dateCreate;
	public static volatile SingularAttribute<TargetCall, Timestamp> dateRemider;
	public static volatile SingularAttribute<TargetCall, Timestamp> dateUpdate;
	public static volatile SingularAttribute<TargetCall, String> descTh;
	public static volatile SingularAttribute<TargetCall, Long> objid;
	public static volatile SingularAttribute<TargetCall, Integer> reasonid;
	public static volatile SingularAttribute<TargetCall, String> remider;
	public static volatile SingularAttribute<TargetCall, Integer> statusid;
	public static volatile SingularAttribute<TargetCall, String> subject;
	public static volatile SingularAttribute<TargetCall, Integer> useridCreate;
}
