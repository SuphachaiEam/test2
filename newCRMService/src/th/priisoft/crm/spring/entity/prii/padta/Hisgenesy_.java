package th.priisoft.crm.spring.entity.prii.padta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-02-28T06:54:21.322+0700")
@StaticMetamodel(Hisgenesy.class)
public class Hisgenesy_ {
	public static volatile SingularAttribute<Hisgenesy, Long> hgid;
	public static volatile SingularAttribute<Hisgenesy, Timestamp> completeDate;
	public static volatile SingularAttribute<Hisgenesy, Timestamp> dateCreate;
	public static volatile SingularAttribute<Hisgenesy, String> filegenesys;
	public static volatile SingularAttribute<Hisgenesy, String> hgName;
	public static volatile SingularAttribute<Hisgenesy, Integer> numImport;
	public static volatile SingularAttribute<Hisgenesy, Long> useridCreate;
}
