package th.priisoft.crm.spring.entity.prii.padta;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-03-28T23:46:09.531+0700")
@StaticMetamodel(Document.class)
public class Document_ {
	public static volatile SingularAttribute<Document, Long> documentid;
	public static volatile SingularAttribute<Document, Timestamp> dateCreate;
	public static volatile SingularAttribute<Document, Boolean> deleted;
	public static volatile SingularAttribute<Document, String> documentname;
	public static volatile SingularAttribute<Document, String> status;
	public static volatile SingularAttribute<Document, String> uid;
	public static volatile SingularAttribute<Document, Long> useridCreate;
}
