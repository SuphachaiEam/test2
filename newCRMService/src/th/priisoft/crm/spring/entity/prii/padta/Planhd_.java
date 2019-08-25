package th.priisoft.crm.spring.entity.prii.padta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-08-13T23:21:48.316+0700")
@StaticMetamodel(Planhd.class)
public class Planhd_ {
	public static volatile SingularAttribute<Planhd, Long> planid;
	public static volatile SingularAttribute<Planhd, String> active;
	public static volatile SingularAttribute<Planhd, Timestamp> dateForm;
	public static volatile SingularAttribute<Planhd, Timestamp> dateTo;
	public static volatile SingularAttribute<Planhd, String> plancode;
	public static volatile SingularAttribute<Planhd, String> plandescEn;
	public static volatile SingularAttribute<Planhd, String> plandescTh;
	public static volatile SingularAttribute<Planhd, Double> target;
	public static volatile ListAttribute<Planhd, Planinsure> planinsures;
	public static volatile ListAttribute<Planhd, Planoption> planoptions;
}
