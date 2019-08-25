package th.priisoft.crm.spring.entity.prii.crmdta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-06-12T22:08:36.538+0700")
@StaticMetamodel(Role.class)
public class Role_ {
	public static volatile SingularAttribute<Role, Integer> roleid;
	public static volatile SingularAttribute<Role, Timestamp> createDate;
	public static volatile SingularAttribute<Role, Integer> createUserid;
	public static volatile SingularAttribute<Role, String> roleNameEn;
	public static volatile SingularAttribute<Role, String> roleNameTh;
	public static volatile SingularAttribute<Role, String> rolecode;
	public static volatile ListAttribute<Role, RefMaster> refMasters;
	public static volatile ListAttribute<Role, TmpRoleMenu> tmpRoleMenus;
}
