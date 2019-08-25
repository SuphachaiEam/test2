package th.priisoft.crm.spring.entity.prii.crmdta;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-03-03T22:51:18.633+0700")
@StaticMetamodel(Groupmenu.class)
public class Groupmenu_ {
	public static volatile SingularAttribute<Groupmenu, Integer> grpmenuid;
	public static volatile SingularAttribute<Groupmenu, String> grpmenuNameEn;
	public static volatile SingularAttribute<Groupmenu, String> grpmenuNameTh;
	public static volatile ListAttribute<Groupmenu, TmpRoleMenu> tmpRoleMenus;
}
