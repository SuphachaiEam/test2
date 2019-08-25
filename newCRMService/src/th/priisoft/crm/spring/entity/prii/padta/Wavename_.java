package th.priisoft.crm.spring.entity.prii.padta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-02-28T06:54:21.511+0700")
@StaticMetamodel(Wavename.class)
public class Wavename_ {
	public static volatile SingularAttribute<Wavename, Long> waveid;
	public static volatile SingularAttribute<Wavename, Timestamp> dateCreate;
	public static volatile SingularAttribute<Wavename, String> filename;
	public static volatile SingularAttribute<Wavename, Long> useridCreate;
	public static volatile SingularAttribute<Wavename, String> wavename;
}
