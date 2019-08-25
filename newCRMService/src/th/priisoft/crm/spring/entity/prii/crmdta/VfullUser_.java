package th.priisoft.crm.spring.entity.prii.crmdta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-06-10T22:17:04.356+0700")
@StaticMetamodel(VfullUser.class)
public class VfullUser_ {
	public static volatile SingularAttribute<VfullUser, Integer> rmid;
	public static volatile SingularAttribute<VfullUser, String> rmdesc;
	public static volatile SingularAttribute<VfullUser, Integer> userid;
	public static volatile SingularAttribute<VfullUser, String> logonid;
	public static volatile SingularAttribute<VfullUser, String> logonad;
	public static volatile SingularAttribute<VfullUser, String> fname;
	public static volatile SingularAttribute<VfullUser, String> lname;
	public static volatile SingularAttribute<VfullUser, String> licenseno;
	public static volatile SingularAttribute<VfullUser, Timestamp> licenseSDate;
	public static volatile SingularAttribute<VfullUser, Timestamp> licenseEDate;
	public static volatile SingularAttribute<VfullUser, String> types;
	public static volatile SingularAttribute<VfullUser, String> detail;
	public static volatile SingularAttribute<VfullUser, Timestamp> createDate;
	public static volatile SingularAttribute<VfullUser, Integer> createUserid;
	public static volatile SingularAttribute<VfullUser, String> active;
	public static volatile SingularAttribute<VfullUser, Integer> partnerid;
	public static volatile SingularAttribute<VfullUser, String> partnerNameEn;
	public static volatile SingularAttribute<VfullUser, String> partnerNameTh;
	public static volatile SingularAttribute<VfullUser, Integer> productid;
	public static volatile SingularAttribute<VfullUser, String> productNameEn;
	public static volatile SingularAttribute<VfullUser, String> productNameTh;
	public static volatile SingularAttribute<VfullUser, Integer> roleid;
	public static volatile SingularAttribute<VfullUser, String> roleNameEn;
	public static volatile SingularAttribute<VfullUser, String> roleNameTh;
	public static volatile SingularAttribute<VfullUser, String> rolecode;
}
