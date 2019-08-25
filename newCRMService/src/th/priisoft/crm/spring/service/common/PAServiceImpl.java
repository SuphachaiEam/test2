package th.priisoft.crm.spring.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import th.priisoft.crm.spring.repository.priipa.PriiPACommonRepository;

@Service
public class PAServiceImpl implements PAService {
	@Autowired
	private PriiPACommonRepository priiPACommonRepository;
	
	//Start Campaign
		@Transactional("PRII_PA_Trans")
		public Campaign saveCampaignEntity(Campaign campaign) throws Exception {
			campaign = priiPACommonRepository.saveCampaignEntity(campaign);
			return campaign;
		}
		
		@Transactional("PRII_PA_Trans")
		public boolean updateCampaignEntity(Campaign campaign) throws Exception {
			return priiPACommonRepository.updateCampaignEntity(campaign);

		}
		@Transactional("PRII_PA_Trans")
		public Campaign findCampaignByID(long campaignid) throws Exception {
			Campaign entity = new  Campaign();
			entity = priiPACommonRepository.findCampaignByID(campaignid);
			return entity;
		}
		@Transactional("PRII_PA_Trans")
		public List<Campaign> findCampaignByCond(String json) throws Exception {
			List<Campaign> lsentity = priiPACommonRepository.findCampaignByCond(json);
			return lsentity;
		}
		@Transactional("PRII_PA_Trans")
		public List<RefCampaignUser> findRefCampaignUserByCond(String json) throws Exception {
			List<RefCampaignUser> lsentity = priiPACommonRepository.findRefCampaignUserByCond(json);
			return lsentity;
		}
		
		//End Campaign
		//Start Wavename
		@Transactional("PRII_PA_Trans")
		public Wavename saveWavenameEntity(Wavename wavename) throws Exception {
			wavename = priiPACommonRepository.saveWavenameEntity(wavename);
			return wavename;
		}
		@Transactional("PRII_PA_Trans")
		public Wavename findWavenameByID(long waveid) throws Exception {
			Wavename entity = new  Wavename();
			entity = priiPACommonRepository.findWavenameByID(waveid);
			return entity;
		}
		@Transactional("PRII_PA_Trans")
		public List<Wavename> findWavenameByCond(String json) throws Exception {
			List<Wavename> lsentity = priiPACommonRepository.findWavenameByCond(json);
			return lsentity;
		}
		//End Wavename
		//Start Outbound
		@Transactional("PRII_PA_Trans")
		public Outbound saveOutboundEntity(Outbound outbound) throws Exception {
			outbound = priiPACommonRepository.saveOutboundEntity(outbound);
			return outbound;
		}
		
		@Transactional("PRII_PA_Trans")
		public void saveOutboundEntity(List<Outbound> outbound) throws Exception {
			priiPACommonRepository.saveOutboundEntity(outbound);
		}
		
		@Transactional("PRII_PA_Trans")
		public boolean updateOutboundEntity(Outbound outbound) throws Exception {
			return priiPACommonRepository.updateOutboundEntity(outbound);

		}
		@Transactional("PRII_PA_Trans")
		public Outbound findOutboundByID(long outboundid) throws Exception {
			Outbound entity = new  Outbound();
			entity = priiPACommonRepository.findOutboundByID(outboundid);
			return entity;
		}
		public int countFindOutboundByCond2(String json) throws Exception{
			int rownum = priiPACommonRepository.countFindOutboundByCond2(json);
			return rownum;
		}
		
		@Transactional("PRII_PA_Trans")
		public List<Outbound> findOutboundByCond2(String json, String limit,int start) throws Exception {
			List<Outbound> lsentity = priiPACommonRepository.findOutboundByCond2(json, limit , start);
			return lsentity;
		}
		@Transactional("PRII_PA_Trans")
		public List<Outbound> findOutboundByCond(String json, String limit) throws Exception {
			List<Outbound> lsentity = priiPACommonRepository.findOutboundByCond(json, limit);
			return lsentity;
		}
		@Transactional("PRII_PA_Trans")
		public boolean addCampaign(String json, int campaignid) throws Exception {
			return priiPACommonRepository.addCampaignToOutbound(json,campaignid);

		}
		@Transactional("PRII_PA_Trans")
		public boolean addCampaign2(Object json) throws Exception {
			return priiPACommonRepository.addCampaignToOutbound2(json);

		}
		@Transactional("PRII_PA_Trans")
		public boolean addCampaignStr(String json) throws Exception {
			return priiPACommonRepository.addCampaignToOutboundStr(json);

		}
		@Transactional("PRII_PA_Trans")
		public boolean reAssignOutbound(String json) throws Exception {
			return priiPACommonRepository.reAssignOutbound(json);

		}
		
		@Transactional("PRII_PA_Trans")
		public boolean reAssignOutbound2(Object json) throws Exception {
			return priiPACommonRepository.reAssignOutbound2(json);

		}
		@Transactional("PRII_PA_Trans")
		public boolean reAssignOutboundStr(String json) throws Exception {
			return priiPACommonRepository.reAssignOutboundStr(json);

		}
		@Transactional("PRII_PA_Trans")
		public boolean moveUserToOutbound(String json, int userid) throws Exception {
			return priiPACommonRepository.moveUserToOutbound(json, userid);

		}
		@Transactional("PRII_PA_Trans")
		public boolean moveUserToOutbound2(Object json) throws Exception {
			return priiPACommonRepository.moveUserToOutbound2(json);

		}
		@Transactional("PRII_PA_Trans")
		public boolean moveUserToOutboundStr(String json) throws Exception {
			return priiPACommonRepository.moveUserToOutboundStr(json);

		}
		@Transactional("PRII_PA_Trans")
		public int deleteOutbound(int waveid) throws Exception {
			return priiPACommonRepository.deleteOutbound(waveid);

		}
		@Transactional("PRII_PA_Trans")
		public int getMaxOutboundByRefCode(String refcode) throws Exception {
			return priiPACommonRepository.getMaxOutboundByRefCode(refcode);

		}
		//End Outbound
		//Start Document
		@Transactional("PRII_PA_Trans")
		public Document saveDocumentEntity(Document document) throws Exception {
			document = priiPACommonRepository.saveDocumentEntity(document);
			return document;
		}
				
		@Transactional("PRII_PA_Trans")
		public boolean updateDocumentEntity(Document document) throws Exception {
			return priiPACommonRepository.updateDocumentEntity(document);

		}
		@Transactional("PRII_PA_Trans")
		public Document findDocumentByID(long documentid) throws Exception {
			Document entity = new  Document();
			entity = priiPACommonRepository.findDocumentByID(documentid);
			return entity;
		}
		@Transactional("PRII_PA_Trans")
		public List<Document> findDocumentByCond(String json) throws Exception {
			List<Document> lsentity = priiPACommonRepository.findDocumentByCond(json);
			return lsentity;
		}
		//End Document
		//Start Target Call
		@Transactional("PRII_PA_Trans")
		public TargetCall saveTargetCallEntity(TargetCall targetcall) throws Exception {
			targetcall = priiPACommonRepository.saveTargetCallEntity(targetcall);
			return targetcall;
		}
						
		@Transactional("PRII_PA_Trans")
		public boolean updateTargetCallEntity(TargetCall targetcall) throws Exception {
			return priiPACommonRepository.updateTargetCallEntity(targetcall);

		}
		@Transactional("PRII_PA_Trans")
		public TargetCall findTargetCallByID(long targetcallid) throws Exception {
			TargetCall entity = new  TargetCall();
			entity = priiPACommonRepository.findTargetCallByID(targetcallid);
			return entity;
		}
		
		@Transactional("PRII_PA_Trans")
		public List<TargetCall> findTargetCallByCond(String json) throws Exception {
			List<TargetCall> lsentity = priiPACommonRepository.findTargetCallByCond(json);
			return lsentity;
		}
		//End Target Call	
		//Start App Call
		@Transactional("PRII_PA_Trans")
		public AppCall saveAppCallEntity(AppCall appcall) throws Exception {
			appcall = priiPACommonRepository.saveAppCallEntity(appcall);
			return appcall;
		}
								
		@Transactional("PRII_PA_Trans")
		public boolean updateAppCallEntity(AppCall appcall) throws Exception {
			return priiPACommonRepository.updateAppCallEntity(appcall);
		}
		
		@Transactional("PRII_PA_Trans")
		public AppCall findAppCallByID(long appcallid) throws Exception {
			AppCall entity = new  AppCall();
			entity = priiPACommonRepository.findAppCallByID(appcallid);
			return entity;
		}
				
		@Transactional("PRII_PA_Trans")
		public List<AppCall> findAppCallByCond(String json) throws Exception {
			List<AppCall> lsentity = priiPACommonRepository.findAppCallByCond(json);
			return lsentity;
		}
		//End Target Call	
		
		//Start Application
		@Transactional("PRII_PA_Trans")
		public Application saveApplicationEntity(Application entity) 	throws Exception {
			return priiPACommonRepository.saveApplicationEntity(entity);
		}
		
		@Transactional("PRII_PA_Trans")
		public boolean updateApplicationEntity(Application entity) throws Exception {
			return priiPACommonRepository.updateApplicationEntity(entity);
		}
		
		@Transactional("PRII_PA_Trans")
		public Application findApplicationByID(long applicationid) throws Exception {
			return priiPACommonRepository.findApplicationByID(applicationid);
		}
		
		@Transactional("PRII_PA_Trans")
		public List<Application> findApplicationByCond(String json,String limit,int start) throws Exception {
			return priiPACommonRepository.findApplicationByCond(json,limit,start);
		}
		@Transactional("PRII_PA_Trans")
		public int countFindApplicationByCond(String json) throws Exception {
			return priiPACommonRepository.countFindApplicationByCond(json);
		}
		//End Application
		//Start Planhd
		@Transactional("PRII_PA_Trans")
		public Planhd savePlanhdEntity(Planhd entity) 	throws Exception {
			return priiPACommonRepository.savePlanhdEntity(entity);
		}
				
		@Transactional("PRII_PA_Trans")
		public boolean updatePlanhdEntity(Planhd entity) throws Exception {
			return priiPACommonRepository.updatePlanhdEntity(entity);
		}
				
		@Transactional("PRII_PA_Trans")
		public Planhd findPlanhdByID(long planid) throws Exception {
			return priiPACommonRepository.findPlanhdByID(planid);
		}
				
		@Transactional("PRII_PA_Trans")
		public List<Planhd> findPlanhdByCond(String json) throws Exception {
			return priiPACommonRepository.findPlanhdByCond(json);
		}
		
		//End Planhd
		//Start Planoption
		@Transactional("PRII_PA_Trans")
		public Planoption savePlanoptionEntity(Planoption entity) 	throws Exception {
			return priiPACommonRepository.savePlanoptionEntity(entity);
		}
						
		@Transactional("PRII_PA_Trans")
		public boolean updatePlanoptionEntity(Planoption entity) throws Exception {
			return priiPACommonRepository.updatePlanoptionEntity(entity);
		}
						
		@Transactional("PRII_PA_Trans")
		public Planoption findPlanoptionByID(long planoptionid) throws Exception {
			return priiPACommonRepository.findPlanoptionByID(planoptionid);
		}
						
		@Transactional("PRII_PA_Trans")
		public List<Planoption> findPlanoptionByCond(String json) throws Exception {
			return priiPACommonRepository.findPlanoptionByCond(json);
		}
				
		//End Planoption
		//Start Planinsure
		@Transactional("PRII_PA_Trans")
		public Planinsure savePlaninsureEntity(Planinsure entity) 	throws Exception {
			return priiPACommonRepository.savePlaninsureEntity(entity);
		}
								
		@Transactional("PRII_PA_Trans")
		public boolean updatePlaninsureEntity(Planinsure entity) throws Exception {
			return priiPACommonRepository.updatePlaninsureEntity(entity);
		}
								
		@Transactional("PRII_PA_Trans")
		public Planinsure findPlaninsureByID(long planinsureid) throws Exception {
			return priiPACommonRepository.findPlaninsureByID(planinsureid);
		}
								
		@Transactional("PRII_PA_Trans")
		public List<Planinsure> findPlaninsureByCond(String json) throws Exception {
			return priiPACommonRepository.findPlaninsureByCond(json);
		}
						
		//End Planinsure
		//Start Planprem
		@Transactional("PRII_PA_Trans")
		public Planprem savePlanpremEntity(Planprem entity) 	throws Exception {
			return priiPACommonRepository.savePlanpremEntity(entity);
		}
										
		@Transactional("PRII_PA_Trans")
		public boolean updatePlanpremEntity(Planprem entity) throws Exception {
			return priiPACommonRepository.updatePlanpremEntity(entity);
		}
										
		@Transactional("PRII_PA_Trans")
		public Planprem findPlanpremByID(long planpremid) throws Exception {
			return priiPACommonRepository.findPlanpremByID(planpremid);
		}
										
		@Transactional("PRII_PA_Trans")
		public List<Planprem> findPlanpremByCond(String json) throws Exception {
			return priiPACommonRepository.findPlanpremByCond(json);
		}
								
		//End Planprem
		//Start ref planprem bank cardtype
		@Transactional("PRII_PA_Trans")
		public RefBankCardPlan saveRefBankCardPlanEntity(RefBankCardPlan entity) throws Exception {
			return priiPACommonRepository.saveRefBankCardPlanEntity(entity);
		}
												
		@Transactional("PRII_PA_Trans")
		public boolean updateRefBankCardPlanEntity(RefBankCardPlan entity) throws Exception {
			return priiPACommonRepository.updateRefBankCardPlanEntity(entity);
		}
												
		@Transactional("PRII_PA_Trans")
		public RefBankCardPlan findRefBankCardPlanByID(long bcpid) throws Exception {
			return priiPACommonRepository.findRefBankCardPlanByID(bcpid);
		}
												
		@Transactional("PRII_PA_Trans")
		public List<RefBankCardPlan> findRefBankCardPlanByCond(String json) throws Exception {
			return priiPACommonRepository.findRefBankCardPlanByCond(json);
		}
		
		@Transactional("PRII_PA_Trans")
		public List<Bank> findBankByPlanpremid(long planpremid) throws Exception {
			return priiPACommonRepository.findBankByPlanpremid(planpremid);
		}
		@Transactional("PRII_PA_Trans")
		public List<Cardtype> findCardTypeByPlanpremidBankid(long planpremid, long bankid) throws Exception {
			return priiPACommonRepository.findCardTypeByPlanpremidBankid(planpremid, bankid);
		}
		//End ref plan prem bank cardtype
		//Start Question
		@Transactional("PRII_PA_Trans")
		public Question saveQuestionEntity(Question entity) throws Exception {
			return priiPACommonRepository.addQuestion(entity);
		}
												
		@Transactional("PRII_PA_Trans")
		public boolean updateQuestion(Question entity) throws Exception {
			return priiPACommonRepository.updateQuestion(entity);
		}
												
		@Transactional("PRII_PA_Trans")
		public List<Question> findQuestionByCond(String json) throws Exception {
			return priiPACommonRepository.findQuestionByCond(json);
		}
		@Transactional("PRII_PA_Trans")
		public Question findQuestionByID(long qid) throws Exception {
			return priiPACommonRepository.findQuestionByID(qid);
		}
		@Transactional("PRII_PA_Trans")
		public int deleteQuestion(long qid) throws Exception {
			return priiPACommonRepository.deleteQuestion(qid);
		}
		//End Question
		//Start Mainquestion
		@Transactional("PRII_PA_Trans")
		public Mainquestion saveMainquestionEntity(Mainquestion entity) throws Exception {
			return priiPACommonRepository.saveMainquestionEntity(entity);
		}
														
		@Transactional("PRII_PA_Trans")
		public boolean updateMainquestion(Mainquestion entity) throws Exception {
			return priiPACommonRepository.updateMainquestionEntity(entity);
		}
														
		@Transactional("PRII_PA_Trans")
		public List<Mainquestion> findMainquestionByCond(String json) throws Exception {
			return priiPACommonRepository.findMainquestionByCond(json);
		}
		@Transactional("PRII_PA_Trans")
		public Mainquestion findMainquestionByID(long mqid) throws Exception {
			return priiPACommonRepository.findMainquestionByID(mqid);
		}
		@Transactional("PRII_PA_Trans")
		public int deleteMainquestion(long mqid) throws Exception {
			return priiPACommonRepository.deleteMainquestion(mqid);
		}
		//End Mainquestion
}
