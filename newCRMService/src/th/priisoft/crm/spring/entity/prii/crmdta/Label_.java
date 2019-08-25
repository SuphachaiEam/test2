package th.priisoft.crm.spring.entity.prii.crmdta;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-02-28T06:54:20.726+0700")
@StaticMetamodel(Label.class)
public class Label_ {
	public static volatile SingularAttribute<Label, Integer> labelid;
	public static volatile SingularAttribute<Label, String> labelcode;
	public static volatile SingularAttribute<Label, String> labeldescEn;
	public static volatile SingularAttribute<Label, String> labeldescTh;
	public static volatile SingularAttribute<Label, String> types;
	public static volatile ListAttribute<Label, Lov> lovs;
}
