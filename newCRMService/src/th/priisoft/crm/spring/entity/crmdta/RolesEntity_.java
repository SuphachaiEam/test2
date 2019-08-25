package th.priisoft.crm.spring.entity.crmdta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-02-28T06:54:20.585+0700")
@StaticMetamodel(RolesEntity.class)
public class RolesEntity_ {
	public static volatile SingularAttribute<RolesEntity, Integer> roleid;
	public static volatile SingularAttribute<RolesEntity, String> role_name_th;
	public static volatile SingularAttribute<RolesEntity, String> role_name_en;
	public static volatile SingularAttribute<RolesEntity, Timestamp> create_date;
	public static volatile SingularAttribute<RolesEntity, String> create_userid;
}
