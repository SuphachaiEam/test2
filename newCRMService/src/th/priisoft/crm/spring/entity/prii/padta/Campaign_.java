package th.priisoft.crm.spring.entity.prii.padta;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2562-05-23T00:24:44.184+0700")
@StaticMetamodel(Campaign.class)
public class Campaign_ {
	public static volatile SingularAttribute<Campaign, Long> campaignid;
	public static volatile SingularAttribute<Campaign, String> agentDesc;
	public static volatile SingularAttribute<Campaign, String> campaignname;
	public static volatile SingularAttribute<Campaign, Timestamp> dateCreate;
	public static volatile SingularAttribute<Campaign, Integer> deleted;
	public static volatile SingularAttribute<Campaign, String> descTh;
	public static volatile SingularAttribute<Campaign, Timestamp> endDate;
	public static volatile SingularAttribute<Campaign, Timestamp> startDate;
	public static volatile SingularAttribute<Campaign, String> status;
	public static volatile SingularAttribute<Campaign, BigDecimal> target;
	public static volatile SingularAttribute<Campaign, Long> useridCreate;
	public static volatile SingularAttribute<Campaign, String> gaCampaign;
	public static volatile SingularAttribute<Campaign, String> gaImport;
	public static volatile SingularAttribute<Campaign, String> gaId;
	public static volatile SingularAttribute<Campaign, String> gaMsg;
}
