package th.priisoft.crm.spring.entity.prii.crmdta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-02-28T06:54:20.873+0700")
@StaticMetamodel(Product.class)
public class Product_ {
	public static volatile SingularAttribute<Product, Integer> productid;
	public static volatile SingularAttribute<Product, Timestamp> createDate;
	public static volatile SingularAttribute<Product, Integer> createUserid;
	public static volatile SingularAttribute<Product, String> productNameEn;
	public static volatile SingularAttribute<Product, String> productNameTh;
	public static volatile ListAttribute<Product, RefMaster> refMasters;
}
