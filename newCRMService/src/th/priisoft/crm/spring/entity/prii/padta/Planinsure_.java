package th.priisoft.crm.spring.entity.prii.padta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-08-10T20:54:34.913+0700")
@StaticMetamodel(Planinsure.class)
public class Planinsure_ {
	public static volatile SingularAttribute<Planinsure, Integer> planinsureid;
	public static volatile SingularAttribute<Planinsure, String> planinsureEn;
	public static volatile SingularAttribute<Planinsure, String> planinsureTh;
	public static volatile SingularAttribute<Planinsure, String> planinsurecode;
	public static volatile SingularAttribute<Planinsure, Double> suminsure;
	public static volatile SingularAttribute<Planinsure, Double> grosspremium;
	public static volatile SingularAttribute<Planinsure, Double> netpremium;
	public static volatile SingularAttribute<Planinsure, Planhd> planhd;
	public static volatile SingularAttribute<Planinsure, Planoption> planoption;
}
