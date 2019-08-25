package th.priisoft.crm.spring.entity.prii.crmdta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-05-10T01:50:47.329+0700")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> userid;
	public static volatile SingularAttribute<User, String> active;
	public static volatile SingularAttribute<User, Timestamp> createDate;
	public static volatile SingularAttribute<User, Integer> createUserid;
	public static volatile SingularAttribute<User, String> detail;
	public static volatile SingularAttribute<User, String> fname;
	public static volatile SingularAttribute<User, Timestamp> licenseEDate;
	public static volatile SingularAttribute<User, Timestamp> licenseSDate;
	public static volatile SingularAttribute<User, String> licenseno;
	public static volatile SingularAttribute<User, String> lname;
	public static volatile SingularAttribute<User, String> logonad;
	public static volatile SingularAttribute<User, String> logonid;
	public static volatile SingularAttribute<User, String> types;
	public static volatile ListAttribute<User, RefMaster> refMasters;
}
