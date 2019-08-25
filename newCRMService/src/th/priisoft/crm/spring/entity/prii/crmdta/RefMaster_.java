package th.priisoft.crm.spring.entity.prii.crmdta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-05-10T01:44:10.812+0700")
@StaticMetamodel(RefMaster.class)
public class RefMaster_ {
	public static volatile SingularAttribute<RefMaster, Integer> rmid;
	public static volatile SingularAttribute<RefMaster, Timestamp> createDate;
	public static volatile SingularAttribute<RefMaster, Integer> createUserid;
	public static volatile SingularAttribute<RefMaster, Partner> partner;
	public static volatile SingularAttribute<RefMaster, Product> product;
	public static volatile SingularAttribute<RefMaster, Role> role;
	public static volatile SingularAttribute<RefMaster, User> user;
	public static volatile SingularAttribute<RefMaster, String> rmdesc;
}
