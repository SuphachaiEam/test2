package th.priisoft.crm.spring.entity.prii.crmdta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-02-28T06:54:20.852+0700")
@StaticMetamodel(Partner.class)
public class Partner_ {
	public static volatile SingularAttribute<Partner, Integer> partnerid;
	public static volatile SingularAttribute<Partner, Timestamp> createDate;
	public static volatile SingularAttribute<Partner, Integer> createUserid;
	public static volatile SingularAttribute<Partner, String> partnerNameEn;
	public static volatile SingularAttribute<Partner, String> partnerNameTh;
	public static volatile SingularAttribute<Partner, String> privateKey;
	public static volatile SingularAttribute<Partner, String> publicKey;
	public static volatile ListAttribute<Partner, RefMaster> refMasters;
}
