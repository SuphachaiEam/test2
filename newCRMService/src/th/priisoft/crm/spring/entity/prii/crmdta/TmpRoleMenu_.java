package th.priisoft.crm.spring.entity.prii.crmdta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-04-24T00:45:02.541+0700")
@StaticMetamodel(TmpRoleMenu.class)
public class TmpRoleMenu_ {
	public static volatile SingularAttribute<TmpRoleMenu, Integer> trmid;
	public static volatile SingularAttribute<TmpRoleMenu, String> active;
	public static volatile SingularAttribute<TmpRoleMenu, Timestamp> createDate;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> createUserid;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> rAccess;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> rAssign;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> rCopy;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> rCreate;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> rDelete;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> rEdit;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> rExport;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> rImport;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> rList;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> rReject;
	public static volatile SingularAttribute<TmpRoleMenu, Integer> rView;
	public static volatile SingularAttribute<TmpRoleMenu, Menu> menu;
	public static volatile SingularAttribute<TmpRoleMenu, Role> role;
	public static volatile SingularAttribute<TmpRoleMenu, Groupmenu> groupmenu;
}
