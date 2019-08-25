package th.priisoft.crm.spring.entity.prii.crmdta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-07-16T15:49:48.943+0700")
@StaticMetamodel(Menu.class)
public class Menu_ {
	public static volatile SingularAttribute<Menu, Integer> menuid;
	public static volatile SingularAttribute<Menu, Timestamp> createDate;
	public static volatile SingularAttribute<Menu, Integer> createUserid;
	public static volatile SingularAttribute<Menu, String> menuNameEn;
	public static volatile SingularAttribute<Menu, String> menuNameTh;
	public static volatile SingularAttribute<Menu, Integer> grpmenuid;
	public static volatile ListAttribute<Menu, TmpRoleMenu> tmpRoleMenus;
}
