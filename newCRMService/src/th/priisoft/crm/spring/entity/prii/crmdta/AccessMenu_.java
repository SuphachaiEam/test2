package th.priisoft.crm.spring.entity.prii.crmdta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-04-24T00:49:07.268+0700")
@StaticMetamodel(AccessMenu.class)
public class AccessMenu_ {
	public static volatile SingularAttribute<AccessMenu, Integer> accessid;
	public static volatile SingularAttribute<AccessMenu, String> active;
	public static volatile SingularAttribute<AccessMenu, Timestamp> createDate;
	public static volatile SingularAttribute<AccessMenu, Integer> createUserid;
	public static volatile SingularAttribute<AccessMenu, Integer> grpmenuid;
	public static volatile SingularAttribute<AccessMenu, Integer> menuid;
	public static volatile SingularAttribute<AccessMenu, Integer> rAccess;
	public static volatile SingularAttribute<AccessMenu, Integer> rAssign;
	public static volatile SingularAttribute<AccessMenu, Integer> rCopy;
	public static volatile SingularAttribute<AccessMenu, Integer> rCreate;
	public static volatile SingularAttribute<AccessMenu, Integer> rDelete;
	public static volatile SingularAttribute<AccessMenu, Integer> rEdit;
	public static volatile SingularAttribute<AccessMenu, Integer> rExport;
	public static volatile SingularAttribute<AccessMenu, Integer> rImport;
	public static volatile SingularAttribute<AccessMenu, Integer> rList;
	public static volatile SingularAttribute<AccessMenu, Integer> rReject;
	public static volatile SingularAttribute<AccessMenu, Integer> rView;
	public static volatile SingularAttribute<AccessMenu, Integer> rmid;
}
