package th.priisoft.crm.spring.repository.priipa;

import java.util.ArrayList;
import java.util.List;

import th.priisoft.crm.spring.entity.prii.crmdta.Bank;
import th.priisoft.crm.spring.entity.prii.crmdta.Cardtype;
import th.priisoft.crm.spring.entity.prii.padta.AppCall;
import th.priisoft.crm.spring.entity.prii.padta.Application;
import th.priisoft.crm.spring.entity.prii.padta.Campaign;
import th.priisoft.crm.spring.entity.prii.padta.Document;
import th.priisoft.crm.spring.entity.prii.padta.Mainquestion;
import th.priisoft.crm.spring.entity.prii.padta.Outbound;
import th.priisoft.crm.spring.entity.prii.padta.Planhd;
import th.priisoft.crm.spring.entity.prii.padta.Planinsure;
import th.priisoft.crm.spring.entity.prii.padta.Planoption;
import th.priisoft.crm.spring.entity.prii.padta.Planprem;
import th.priisoft.crm.spring.entity.prii.padta.Question;
import th.priisoft.crm.spring.entity.prii.padta.RefBankCardPlan;
import th.priisoft.crm.spring.entity.prii.padta.RefCampaignUser;
import th.priisoft.crm.spring.entity.prii.padta.TargetCall;
import th.priisoft.crm.spring.entity.prii.padta.Wavename;


public interface PriiPACommonRepository {
	public Campaign saveCampaignEntity(Campaign entity) 	throws Exception;
	public boolean updateCampaignEntity(Campaign entity) throws Exception;
	public Campaign findCampaignByID(long campaignid) throws Exception;
	public List<Campaign> findCampaignByCond(String json) throws Exception;
	public ArrayList<RefCampaignUser> findRefCampaignUserByCond(String json) throws Exception;
		
	public Wavename saveWavenameEntity(Wavename entity) throws Exception;
	public Wavename findWavenameByID(long waveid) throws Exception ;
	public List<Wavename> findWavenameByCond(String json) throws Exception;
	
	public Outbound saveOutboundEntity(Outbound entity) 	throws Exception;
	public void saveOutboundEntity(List<Outbound> entity) 	throws Exception;
	public boolean updateOutboundEntity(Outbound entity) throws Exception;
	public Outbound findOutboundByID(long outboundid) throws Exception;
	public int countFindOutboundByCond2(String json) throws Exception;
	public List<Outbound> findOutboundByCond2(String json, String limit , int start) throws Exception;
	public List<Outbound> findOutboundByCond(String json, String limit) throws Exception;
	public boolean addCampaignToOutbound(String json, int campaignid);
	public boolean addCampaignToOutbound2(Object json);
	public boolean addCampaignToOutboundStr(String json);
	public boolean reAssignOutbound(String json);
	public boolean reAssignOutbound2(Object json);
	public boolean reAssignOutboundStr(String json);
	public boolean moveUserToOutbound(String json, int userid);
	public boolean moveUserToOutbound2(Object json);
	public boolean moveUserToOutboundStr(String json);
	public int deleteOutbound(int waveid);
	public int getMaxOutboundByRefCode(String refcode) throws Exception;
	
	public Document saveDocumentEntity(Document entity) 	throws Exception;
	public boolean updateDocumentEntity(Document entity) throws Exception;
	public Document findDocumentByID(long documentid) throws Exception;
	public List<Document> findDocumentByCond(String json) throws Exception;
	
	public TargetCall saveTargetCallEntity(TargetCall entity) 	throws Exception;
	public boolean updateTargetCallEntity(TargetCall entity) throws Exception;
	public TargetCall findTargetCallByID(long targetcallid) throws Exception;
	public List<TargetCall> findTargetCallByCond(String json) throws Exception;
	
	public AppCall saveAppCallEntity(AppCall entity) 	throws Exception;
	public boolean updateAppCallEntity(AppCall entity) throws Exception;
	public AppCall findAppCallByID(long appcallid) throws Exception;
	public List<AppCall> findAppCallByCond(String json) throws Exception;
	
	public Application saveApplicationEntity(Application entity) 	throws Exception;
	public boolean updateApplicationEntity(Application entity) throws Exception;
	public Application findApplicationByID(long applicationid) throws Exception;
	public List<Application> findApplicationByCond(String json,String limit,int start) throws Exception;
	public int countFindApplicationByCond(String json) throws Exception;
	
	public Planhd savePlanhdEntity(Planhd entity) 	throws Exception;
	public boolean updatePlanhdEntity(Planhd entity) throws Exception;
	public Planhd findPlanhdByID(long planid) throws Exception;
	public List<Planhd> findPlanhdByCond(String json) throws Exception;
	
	public Planoption savePlanoptionEntity(Planoption entity) 	throws Exception;
	public boolean updatePlanoptionEntity(Planoption entity) throws Exception;
	public Planoption findPlanoptionByID(long planoptionid) throws Exception;
	public List<Planoption> findPlanoptionByCond(String json) throws Exception;
	
	public Planinsure savePlaninsureEntity(Planinsure entity) 	throws Exception;
	public boolean updatePlaninsureEntity(Planinsure entity) throws Exception;
	public Planinsure findPlaninsureByID(long planinsureid) throws Exception;
	public List<Planinsure> findPlaninsureByCond(String json) throws Exception;
	
	public Planprem savePlanpremEntity(Planprem entity) 	throws Exception;
	public boolean updatePlanpremEntity(Planprem entity) throws Exception;
	public Planprem findPlanpremByID(long planpremid) throws Exception;
	public List<Planprem> findPlanpremByCond(String json) throws Exception;
	
	public RefBankCardPlan saveRefBankCardPlanEntity(RefBankCardPlan entity) 	throws Exception;
	public boolean updateRefBankCardPlanEntity(RefBankCardPlan entity) throws Exception;
	public RefBankCardPlan findRefBankCardPlanByID(long bcpid) throws Exception;
	public List<RefBankCardPlan> findRefBankCardPlanByCond(String json) throws Exception;
	public List<Bank> findBankByPlanpremid(long planpremid) throws Exception;
	public List<Cardtype> findCardTypeByPlanpremidBankid(long planpremid, long bankid) throws Exception;
	
	public Question addQuestion(Question entity);
	public boolean updateQuestion(Question entity);
	public Question findQuestionByID(long qid);
	public List<Question> findQuestionByCond(String json) throws Exception;
	public int deleteQuestion(long l) ;
	
	public Mainquestion saveMainquestionEntity(Mainquestion entity) 	throws Exception;
	public boolean updateMainquestionEntity(Mainquestion entity) throws Exception;
	public Mainquestion findMainquestionByID(long mqid) throws Exception;
	public List<Mainquestion> findMainquestionByCond(String json) throws Exception;
	public int deleteMainquestion(long l);
	
}
