package th.priisoft.crm.spring.repository.priipa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import th.priisoft.crm.common.utils.JsonUtils;
import th.priisoft.crm.spring.entity.prii.crmdta.Bank;
import th.priisoft.crm.spring.entity.prii.crmdta.Cardtype;
import th.priisoft.crm.spring.entity.prii.crmdta.Reason;
import th.priisoft.crm.spring.entity.prii.crmdta.Status;
import th.priisoft.crm.spring.entity.prii.padta.AppCall;
import th.priisoft.crm.spring.entity.prii.padta.Application;
import th.priisoft.crm.spring.entity.prii.padta.Campaign;
import th.priisoft.crm.spring.entity.prii.padta.Client;
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
import th.priisoft.crm.spring.entity.prii.padta.RefTargetApp;
import th.priisoft.crm.spring.entity.prii.padta.Submainquestion;
import th.priisoft.crm.spring.entity.prii.padta.TargetCall;
import th.priisoft.crm.spring.entity.prii.padta.Wavename;
import th.priisoft.crm.spring.repository.BasePRIIPARepository;
import th.priisoft.crm.spring.repository.priicrm.PriiCRMCommonRepository;

@Repository
public class PriiPACommonRepositoryImpl extends BasePRIIPARepository implements PriiPACommonRepository {
		@Autowired
		PriiCRMCommonRepository priiCrm;
		
		
		
		//Start Campaign
		public Campaign saveCampaignEntity(Campaign entity) 	throws Exception {
			entityManagerPA.persist(entity);
			return entity;
		}
		public boolean updateCampaignEntity(Campaign entity) throws Exception {
			boolean result = false;
			try {
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			return result;
		}
		public Campaign findCampaignByID(long campaignid) throws Exception {
			Campaign cam = null;
			try {
				cam = entityManagerPA.find(Campaign.class, campaignid);
				if (cam != null) {
					String json = "{\"campaignid\":[\"=\","+cam.getCampaignid()+"]}";
					ArrayList<RefCampaignUser> rcu = findRefCampaignUserByCond(json);
					if (rcu != null && rcu.size() > 0) {
						cam.setRefCampaignUser(rcu.toArray(new RefCampaignUser[rcu.size()]));
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return cam;
		}
		public List<Campaign> findCampaignByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Campaign  ";
			
			List<Campaign> lsCampaign  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsCampaign = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, Campaign.class)
								.getResultList();
				} else {
					lsCampaign = entityManagerPA.createNativeQuery(sqlStr, Campaign.class)
							.getResultList();
				}
				for (Campaign camp : lsCampaign) {
					String str = "{\"campaignid\":[\"=\","+camp.getCampaignid()+"]}";
					ArrayList<RefCampaignUser> rcu = findRefCampaignUserByCond(str);
					if (rcu != null && rcu.size() > 0) {
						camp.setRefCampaignUser(rcu.toArray(new RefCampaignUser[rcu.size()]));
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsCampaign;
		}
		public ArrayList<RefCampaignUser> findRefCampaignUserByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM ref_campaign_user  ";
			
			ArrayList<RefCampaignUser> lsRefCampaignUser  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsRefCampaignUser = (ArrayList<RefCampaignUser>)entityManagerPA.createNativeQuery(sqlStr + sqlWhere, RefCampaignUser.class)
								.getResultList();
				} else {
					lsRefCampaignUser = (ArrayList<RefCampaignUser>)entityManagerPA.createNativeQuery(sqlStr, RefCampaignUser.class)
							.getResultList();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsRefCampaignUser;
		}
		
		//End Campaign
		//Start wavename
		public Wavename saveWavenameEntity(Wavename entity) throws Exception {
			
			entityManagerPA.persist(entity);
			return entity;
		}
		public Wavename findWavenameByID(long waveid) throws Exception {
			Wavename wave = null;
			try {
				wave = entityManagerPA.find(Wavename.class, waveid);
			} catch (Exception e) {
				// TODO: handle exception‰
				e.printStackTrace();
			}
			return wave;
		}
		public List<Wavename> findWavenameByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Wavename  ";
			
			List<Wavename> lsWavename  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsWavename = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, Wavename.class)
								.getResultList();
				} else {
					lsWavename = entityManagerPA.createNativeQuery(sqlStr, Wavename.class)
							.getResultList();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsWavename;
		}
		//End wavename
		
		//Start Outbound
		public Outbound saveOutboundEntity(Outbound entity) 	throws Exception {
			entityManagerPA.persist(entity);
			return entity;
		}
		
		public void saveOutboundEntity(List<Outbound> entity) 	throws Exception {
			for(Outbound obj :entity) {
				entityManagerPA.persist(obj);
			}
		}
		
		public boolean updateOutboundEntity(Outbound entity) throws Exception {
			boolean result = false;
			try {
				Outbound oldEntity = entityManagerPA.find(Outbound.class, entity.getObjid());
				
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
						// TODO: handle exception
				e.printStackTrace();
			}

			return result;
		}
		public Outbound findOutboundByID(long outboundid) throws Exception {
			Outbound cam = null;
			try {
				cam = entityManagerPA.find(Outbound.class, outboundid);
				cam.setCampaign(findCampaignByID(cam.getCampaignid()));
				cam.setWavename(findWavenameByID(cam.getWaveid()));	
				cam.setStatus(priiCrm.findStatusByID(cam.getStatusid()));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return cam;
		}
		
		public int countFindOutboundByCond2(String json) throws Exception {
			String sqlStr = "SELECT count(objid) FROM Outbound  ";
			int result  = 0;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					result = (Integer) entityManagerPA.createNativeQuery(sqlStr + sqlWhere)
										.getSingleResult();
				} else {
					result = (Integer) entityManagerPA.createNativeQuery(sqlStr)
									.getSingleResult();
				}
				
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}
		
		public List<Outbound> findOutboundByCond2(String json,String limit,int start) throws Exception {
			String sqlStr = "SELECT * FROM Outbound  ";
			
			start = start-1;
			if(start<0)
				start = 0;
					
			List<Outbound> lsOutbound  = null;
			try {
				
				if (json != null && json.length() > 1) 
					sqlStr = sqlStr +  " WHERE " + JsonUtils.mapJsonCondNew2(json);
				
				if (limit != null && Integer.valueOf(limit) > 0) 
					sqlStr = sqlStr + " ORDER BY objid ASC OFFSET "+start+" ROWS FETCH NEXT "+limit+" ROWS ONLY ";
					
				lsOutbound = entityManagerPA.createNativeQuery(sqlStr, Outbound.class)
						.getResultList();
				
				for (Outbound ob : lsOutbound) {
					ob.setCampaign(findCampaignByID(ob.getCampaignid()));
					ob.setWavename(findWavenameByID(ob.getWaveid()));
					ob.setStatus(priiCrm.findStatusByID(ob.getStatusid()));
				}
			} catch(Exception e) {
					e.printStackTrace();
			}
			return lsOutbound;
		}
		
		public List<Outbound> findOutboundByCond(String json,String limit) throws Exception {
			String sqlStr = "SELECT * FROM Outbound  ";
			if (limit != null && Integer.valueOf(limit) > 0) {
				sqlStr = "SELECT TOP " + limit + " * FROM Outbound ";
			}
			List<Outbound> lsOutbound  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsOutbound = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, Outbound.class)
										.getResultList();
				} else {
					lsOutbound = entityManagerPA.createNativeQuery(sqlStr, Outbound.class)
									.getResultList();
				}
				for (Outbound ob : lsOutbound) {
					ob.setCampaign(findCampaignByID(ob.getCampaignid()));
					ob.setWavename(findWavenameByID(ob.getWaveid()));
					ob.setStatus(priiCrm.findStatusByID(ob.getStatusid()));
				}
			} catch(Exception e) {
					e.printStackTrace();
			}
			return lsOutbound;
		}
		public int deleteOutbound(int waveid) {
			int result = 0;
			String sqlStr = "DELETE FROM Outbound WHERE Waveid = ?1";
			try {
				String json = "{\"waveid\":[\"=\"," + waveid + "]}";
				List<Wavename> lsWave = findWavenameByCond(json);
				if (lsWave != null && lsWave.size() > 0) {
					Query qry = entityManagerPA.createNativeQuery(sqlStr);
					qry.setParameter(1, waveid);
					result = qry.executeUpdate();
				} else {
					result = -1;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		public int getMaxOutboundByRefCode(String refcode) throws Exception {
			String sqlStr = "SELECT count(objid) FROM Outbound WHERE referencecode = ?1 ";
			int result  = 0;
			try {
				if (refcode != null && refcode.length() > 1) {
					
					Query qry = entityManagerPA.createNativeQuery(sqlStr);
					qry.setParameter(1, refcode);
					result = (int)qry.getSingleResult();
				} 
				
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}
		public boolean addCampaignToOutbound(String json, int campaignid) {
			
			boolean result = false;
			try {
				String str = "{\"statuscode\":[\"=\",\"NW\"]}"; 
				List<Status> lsstatus =	priiCrm.findStatusByCond(str);
				if (json != null && json.length() > 1 && lsstatus.size() > 0) {
					
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					
					StoredProcedureQuery query = entityManagerPA.createStoredProcedureQuery("updCampaignToOutboundByCond")
							.registerStoredProcedureParameter("cond", String.class, ParameterMode.IN)
							.registerStoredProcedureParameter("campaignid", Integer.class, ParameterMode.IN)
							.registerStoredProcedureParameter("statusid", Integer.class, ParameterMode.IN)
							.registerStoredProcedureParameter("cntupd", Integer.class, ParameterMode.OUT)
							.setParameter("cond", sqlWhere)
							.setParameter("campaignid", campaignid)
							.setParameter("statusid", lsstatus.get(0).getStatusid());
					int ss = query.executeUpdate();
					//int d = (int)query.getOutputParameterValue("cntupd");
					if (ss == 0) {
						//System.out.println("Update result total : " + ss + " row");
						result = true;
					}
				} 
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}
		public boolean addCampaignToOutbound2(Object json) {
			
			boolean result = false;
			try {
				String str = "{\"statuscode\":[\"=\",\"NW\"]}"; 
				List<Status> lsstatus =	priiCrm.findStatusByCond(str);
				if (json != null && lsstatus.size() > 0) {
			
					Object campaignid = ((Map<String,Object>)json).get("campaignid");
					//int camid = Integer.parseInt(campaignid.toString());
					int camid = (int)campaignid;
					Object connd = ((Map<String,Object>)json).get("condition");
					List<Integer> arrCond = (List<Integer>)connd;
					String strCond = arrCond.stream().map(Object::toString).collect(Collectors.joining(","));
					
					StoredProcedureQuery query = entityManagerPA.createStoredProcedureQuery("updCampaignToOutbound")
							.registerStoredProcedureParameter("objid", String.class, ParameterMode.IN)
							.registerStoredProcedureParameter("campaignid", Integer.class, ParameterMode.IN)
							.registerStoredProcedureParameter("statusid", Integer.class, ParameterMode.IN)
							.registerStoredProcedureParameter("cntupd", Integer.class, ParameterMode.OUT)
							.setParameter("objid", strCond)
							.setParameter("campaignid", camid)
							.setParameter("statusid", lsstatus.get(0).getStatusid());
					int ss = query.executeUpdate();
					//int d = (int)query.getOutputParameterValue("cntupd");
					if (ss == 0) {
						//System.out.println("Update result total : " + ss + " row");
						result = true;
					}
				} 
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}
		public boolean addCampaignToOutboundStr(String json) {
			
			boolean result = false;
			try {
				String str = "{\"statuscode\":[\"=\",\"NW\"]}"; 
				List<Status> lsstatus =	priiCrm.findStatusByCond(str);
				if (json != null && json.length() > 0 && lsstatus.size() > 0) {
					JSONObject jsonObj = (JSONObject) JSONValue.parse(json);
					String filter = jsonObj.get("filter").toString();
					long campaignid = (long)jsonObj.get("campaignid");
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(filter);
					
					StoredProcedureQuery query = entityManagerPA.createStoredProcedureQuery("updCampaignToOutboundByCond")
							.registerStoredProcedureParameter("cond", String.class, ParameterMode.IN)
							.registerStoredProcedureParameter("campaignid", Long.class, ParameterMode.IN)
							.registerStoredProcedureParameter("statusid", Integer.class, ParameterMode.IN)
							.registerStoredProcedureParameter("cntupd", Integer.class, ParameterMode.OUT)
							.setParameter("cond", sqlWhere)
							.setParameter("campaignid", campaignid)
							.setParameter("statusid", lsstatus.get(0).getStatusid());
					int ss = query.executeUpdate();
					//int d = (int)query.getOutputParameterValue("cntupd");
					if (ss == 0) {
						//System.out.println("Update result total : " + ss + " row");
						result = true;
					}
				} 
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}
		public boolean reAssignOutbound(String json) {
			
			boolean result = false;
			try {
				String str = "{\"statuscode\":[\"=\",\"ED\"]}"; 
				List<Status> lsstatus =	priiCrm.findStatusByCond(str);
				if (json != null && json.length() > 1 && lsstatus.size() > 0) {
					JSONObject jsonObj = (JSONObject)JSONValue.parse(json);
										
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);

					StoredProcedureQuery query = entityManagerPA.createStoredProcedureQuery("updReassignOutboundByCond")
							.registerStoredProcedureParameter("cond", String.class, ParameterMode.IN)
							.registerStoredProcedureParameter("statusid", Integer.class, ParameterMode.IN)
							.registerStoredProcedureParameter("cntupd", Integer.class, ParameterMode.OUT)
							.setParameter("cond", sqlWhere)
							.setParameter("statusid", lsstatus.get(0).getStatusid());
					int ss = query.executeUpdate();
					//int d = (int)query.getOutputParameterValue("cntupd");
					if (ss == 0) {
						//System.out.println("Update result total : " + ss + " row");
						result = true;
					}
				} 
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}
		public boolean reAssignOutbound2(Object json) {
			
			boolean result = false;
			try {
				String str = "{\"statuscode\":[\"=\",\"ED\"]}"; 
				List<Status> lsstatus =	priiCrm.findStatusByCond(str);
				if (json != null  && lsstatus.size() > 0) {
									
					Object connd = ((Map<String,Object>)json).get("condition");
					List<Integer> arrCond = (List<Integer>)connd;
					String strCond = arrCond.stream().map(Object::toString).collect(Collectors.joining(","));

					StoredProcedureQuery query = entityManagerPA.createStoredProcedureQuery("updReassignOutbound")
							.registerStoredProcedureParameter("objid", String.class, ParameterMode.IN)
							.registerStoredProcedureParameter("statusid", Integer.class, ParameterMode.IN)
							.registerStoredProcedureParameter("cntupd", Integer.class, ParameterMode.OUT)
							.setParameter("objid", strCond)
							.setParameter("statusid", lsstatus.get(0).getStatusid());
					int ss = query.executeUpdate();
					//int d = (int)query.getOutputParameterValue("cntupd");
					if (ss == 0) {
						//System.out.println("Update result total : " + ss + " row");
						result = true;
					}
				} 
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}
		public boolean reAssignOutboundStr(String json) {
			
			boolean result = false;
			try {
				String str = "{\"statuscode\":[\"=\",\"ED\"]}"; 
				List<Status> lsstatus =	priiCrm.findStatusByCond(str);
				if (json != null && json.length() > 1 && lsstatus.size() > 0) {
					JSONObject jsonObj = (JSONObject)JSONValue.parse(json);
					String filter = jsonObj.get("filter").toString();					
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(filter);

					StoredProcedureQuery query = entityManagerPA.createStoredProcedureQuery("updReassignOutboundByCond")
							.registerStoredProcedureParameter("cond", String.class, ParameterMode.IN)
							.registerStoredProcedureParameter("statusid", Integer.class, ParameterMode.IN)
							.registerStoredProcedureParameter("cntupd", Integer.class, ParameterMode.OUT)
							.setParameter("cond", sqlWhere)
							.setParameter("statusid", lsstatus.get(0).getStatusid());
					int ss = query.executeUpdate();
					//int d = (int)query.getOutputParameterValue("cntupd");
					if (ss == 0) {
						//System.out.println("Update result total : " + ss + " row");
						result = true;
					}
				} 
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}
		public boolean moveUserToOutbound(String json, int userid) {
			String sqlStr = "UPDATE Outbound SET assigneduserid = ?1 WHERE objid in ?2 ";
			boolean result = false;
			try {
				if (json != null && json.length() > 1) {
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);

					StoredProcedureQuery query = entityManagerPA.createStoredProcedureQuery("updMoveUserToOutboundByCond")
							.registerStoredProcedureParameter("cond", String.class, ParameterMode.IN)
							.registerStoredProcedureParameter("userid", Integer.class, ParameterMode.IN)
							.registerStoredProcedureParameter("cntupd", Integer.class, ParameterMode.OUT)
							.setParameter("cond", sqlWhere)
							.setParameter("userid", userid);
					int ss = query.executeUpdate();
					//int d = (int)query.getOutputParameterValue("cntupd");
					if (ss == 0) {
						//System.out.println("Update result total : " + ss + " row");
						result = true;
					}
				} 
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}
		public boolean moveUserToOutbound2(Object json) {
			String sqlStr = "UPDATE Outbound SET assigneduserid = ?1 WHERE objid in ?2 ";
			boolean result = false;
			try {
				if (json != null ) {
					Object userid = ((Map<String,Object>)json).get("userid");
					int uid = (int)userid;
					
					List<Integer> arrCond = (List<Integer>) ((Map<String,Object>)json).get("condition");
					String strCond = arrCond.stream().map(Object::toString).collect(Collectors.joining(","));

					StoredProcedureQuery query = entityManagerPA.createStoredProcedureQuery("updMoveUserToOutbound")
							.registerStoredProcedureParameter("objid", String.class, ParameterMode.IN)
							.registerStoredProcedureParameter("userid", Integer.class, ParameterMode.IN)
							.registerStoredProcedureParameter("cntupd", Integer.class, ParameterMode.OUT)
							.setParameter("objid", strCond)
							.setParameter("userid", uid);
					int ss = query.executeUpdate();
					//int d = (int)query.getOutputParameterValue("cntupd");
					if (ss == 0) {
						//System.out.println("Update result total : " + ss + " row");
						result = true;
					}
				} 
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}
		public boolean moveUserToOutboundStr(String json) {
			String sqlStr = "UPDATE Outbound SET assigneduserid = ?1 WHERE objid in ?2 ";
			boolean result = false;
			try {
				if (json != null && json.length() > 1) {
					JSONObject jsonObj = (JSONObject)JSONValue.parse(json);
					String filter = jsonObj.get("filter").toString();	
					long userid = (long)jsonObj.get("userid");
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(filter);

					StoredProcedureQuery query = entityManagerPA.createStoredProcedureQuery("updMoveUserToOutboundByCond")
							.registerStoredProcedureParameter("cond", String.class, ParameterMode.IN)
							.registerStoredProcedureParameter("userid", Long.class, ParameterMode.IN)
							.registerStoredProcedureParameter("cntupd", Integer.class, ParameterMode.OUT)
							.setParameter("cond", sqlWhere)
							.setParameter("userid", userid);
					int ss = query.executeUpdate();
					//int d = (int)query.getOutputParameterValue("cntupd");
					if (ss == 0) {
						//System.out.println("Update result total : " + ss + " row");
						result = true;
					}
				} 
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}
		//End Outbound
		//Start Document
		public Document saveDocumentEntity(Document entity) throws Exception {
			entityManagerPA.persist(entity);
			return entity;
		}
		public boolean updateDocumentEntity(Document entity) throws Exception {
			boolean result = false;
			try {
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			return result;
		}
		public Document findDocumentByID(long documentid) throws Exception {
			Document doc = null;
			try {
				doc = entityManagerPA.find(Document.class, documentid);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return doc;
		}
		public List<Document> findDocumentByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Document  ";
			
			List<Document> lsDocument  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsDocument = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, Document.class)
								.getResultList();
				} else {
					lsDocument = entityManagerPA.createNativeQuery(sqlStr, Document.class)
							.getResultList();
				}
		
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsDocument;
		}
		//End Document
		//Start call target
		public TargetCall saveTargetCallEntity(TargetCall entity) throws Exception {
			entityManagerPA.persist(entity);
			return entity;
		}
		public boolean updateTargetCallEntity(TargetCall entity) throws Exception {
			boolean result = false;
			try {
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			return result;
		}
		public TargetCall findTargetCallByID(long targetcallid) throws Exception {
			TargetCall tc = null;
			try {
				tc = entityManagerPA.find(TargetCall.class, targetcallid);
				if (tc.getTargetcallsid() > 0) {
					Reason reason = priiCrm.findReasonByID(tc.getReasonid());
					tc.setReason(reason);
					Status status = priiCrm.findStatusByID(tc.getStatusid());
					tc.setStatus(status);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return tc;
		}
		public List<TargetCall> findTargetCallByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Target_calls  ";
			
			List<TargetCall> lsTargetCall  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsTargetCall = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, TargetCall.class)
								.getResultList();
				} else {
					lsTargetCall = entityManagerPA.createNativeQuery(sqlStr, TargetCall.class)
							.getResultList();
				}
				for(TargetCall tc : lsTargetCall) {
					
					
					if (tc.getReasonid() > 0) {
						Reason reason = priiCrm.findReasonByID(tc.getReasonid());
						tc.setReason(reason);
						Status status = priiCrm.findStatusByID(tc.getStatusid());
						tc.setStatus(status);
					}
					
					
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsTargetCall;
		}
		//end call target
		
		//Start call app
		public AppCall saveAppCallEntity(AppCall entity) throws Exception {
			entityManagerPA.persist(entity);
			return entity;
		}
		public boolean updateAppCallEntity(AppCall entity) throws Exception {
			boolean result = false;
			try {
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			return result;
		}
		public AppCall findAppCallByID(long appcallid) throws Exception {
			AppCall ac = null;
			try {
				ac = entityManagerPA.find(AppCall.class, appcallid);
				if (ac.getAppcallsid() > 0 && ac.getReasonid() > 0) {
					Reason reason = priiCrm.findReasonByID(ac.getReasonid());
					ac.setReason(reason);
					Status status = priiCrm.findStatusByID(ac.getStatusid());
					ac.setStatus(status);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return ac;
		}
		public List<AppCall> findAppCallByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM App_calls  ";
			
			List<AppCall> lsAppCall  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsAppCall = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, AppCall.class)
								.getResultList();
				} else {
					lsAppCall = entityManagerPA.createNativeQuery(sqlStr, AppCall.class)
							.getResultList();
				}
				for(AppCall tc : lsAppCall) {
					if (tc.getReasonid() > 0) {
						Reason reason = priiCrm.findReasonByID(tc.getReasonid());
						tc.setReason(reason);
						Status status = priiCrm.findStatusByID(tc.getStatusid());
						tc.setStatus(status);
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsAppCall;
		}		
		//end call app
		//Start Application
		public Application saveApplicationEntity(Application entity) 	throws Exception {
			if (entity.getQcuser().getUserid() > 0) {
				entity.setQcuserid(entity.getQcuser().getUserid());
			}
			if (entity.getUsercreate().getUserid() > 0)  {
				entity.setUseridcreate(entity.getUsercreate().getUserid());
			}
			if (entity.getCampaign().getCampaignid() > 0) {
				entity.setCampaignid(entity.getCampaign().getCampaignid());
			}
			if (entity.getWavename().getWaveid() > 0) {
				entity.setWaveid(entity.getWavename().getWaveid());
			}
			if (entity.getStatus().getStatusid() > 0) {
				entity.setStatusid(entity.getStatus().getStatusid());
			}
			if (entity.getBank().getBankid() > 0) {
				entity.setBankid(entity.getBank().getBankid());
			}
			if (entity.getCardtype().getCardtypeid() > 0) {
				entity.setCardtypeid(entity.getCardtype().getCardtypeid());
			}
			if (entity.getPlanhd().getPlanid() > 0) {
				entity.setPlanid(entity.getPlanhd().getPlanid());
			}
			if (entity.getPlaninsure().getPlaninsureid() > 0) {
				entity.setPlaninsureid(entity.getPlaninsure().getPlaninsureid());
			}
			if (entity.getPlanoption().getPlanoptionid() > 0) {
				entity.setPlanoptionid(entity.getPlanoption().getPlanoptionid());
			}
			if (entity.getPlanprem().getPlanpremid() > 0) {
				entity.setPlanpremid(entity.getPlanprem().getPlanpremid());
			}
			entityManagerPA.persist(entity);
			
			for (Client cl : entity.getClient()) {
				cl.setAppid(entity.getAppid());
				addCliect(cl);
			}
			for (Question que: entity.getQuestion()) {
				que.setAppid(entity.getAppid());
				que.setPlanid(entity.getPlanid());
				addQuestion(que);
			}
			
			entity.getReftargetapp().setAppid(entity.getAppid());
			addRefTargetApp(entity.getReftargetapp());
			
			return entity;
		}
		public boolean updateApplicationEntity(Application entity) throws Exception {
			boolean result = false;
			try {
				if (entity.getQcuser().getUserid() > 0) {
					entity.setQcuserid(entity.getQcuser().getUserid());
				}
				if (entity.getUsercreate().getUserid() > 0)  {
					entity.setUseridcreate(entity.getUsercreate().getUserid());
				}
				if (entity.getCampaign().getCampaignid() > 0) {
					entity.setCampaignid(entity.getCampaign().getCampaignid());
				}
				if (entity.getWavename().getWaveid() > 0) {
					entity.setWaveid(entity.getWavename().getWaveid());
				}
				if (entity.getStatus().getStatusid() > 0) {
					entity.setStatusid(entity.getStatus().getStatusid());
				}
				if (entity.getBank().getBankid() > 0) {
					entity.setBankid(entity.getBank().getBankid());
				}
				if (entity.getCardtype().getCardtypeid() > 0) {
					entity.setCardtypeid(entity.getCardtype().getCardtypeid());
				}
				if (entity.getPlanhd().getPlanid() > 0) {
					entity.setPlanid(entity.getPlanhd().getPlanid());
				}
				if (entity.getPlaninsure().getPlaninsureid() > 0) {
					entity.setPlaninsureid(entity.getPlaninsure().getPlaninsureid());
				}
				if (entity.getPlanoption().getPlanoptionid() > 0) {
					entity.setPlanoptionid(entity.getPlanoption().getPlanoptionid());
				}
				if (entity.getPlanprem().getPlanpremid() > 0) {
					entity.setPlanpremid(entity.getPlanprem().getPlanpremid());
				}
				entityManagerPA.merge(entity);

				deleteClient(entity.getAppid());
				for (Client cl : entity.getClient()) {
					cl.setAppid(entity.getAppid());
					addCliect(cl);
				}
				deleteQuestion(entity.getAppid());
				for (Question que: entity.getQuestion()) {
					que.setAppid(entity.getAppid());
					que.setPlanid(entity.getPlanid());
					addQuestion(que);
				}
				 
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			return result;
		}
		public Application findApplicationByID(long applicationid) throws Exception {
			Application app = null;
			try {
				app = entityManagerPA.find(Application.class, applicationid);
				if (app != null) {
					app.setBank(priiCrm.findBankByID(app.getBankid()));
					app.setCampaign(findCampaignByID(app.getCampaignid()));
					app.setCardtype(priiCrm.findCardtypeByID(app.getCardtypeid()));
					app.setPlanhd(findPlanhdByID(app.getPlanid()));
					app.setPlanoption(findPlanoptionByID(app.getPlanoptionid()));
					app.setPlaninsure(findPlaninsureByID(app.getPlaninsureid()));
					app.setPlanprem(findPlanpremByID(app.getPlanpremid()));
					app.setQcuser(priiCrm.findUserByID(app.getQcuserid()));
					app.setStatus(priiCrm.findStatusByID(app.getStatusid()));
					app.setWavename(findWavenameByID(app.getWaveid()));
					String json = "{\"appid\":[\"=\",\"" + app.getAppid() + "\"]}";
					List<Question> lsQuestion = findQuestionByCond(json);
					if (lsQuestion != null && lsQuestion.size() > 0) {
						app.setQuestion((Question[])lsQuestion.toArray());
					}
					List<Client> lsClient = findClientByCond(json);
					if (lsClient != null && lsClient.size() > 0) {
						app.setClient((Client[])lsClient.toArray()); 
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return app;
		}

		public List<Application> findApplicationByCond(String json,String limit,int start) throws Exception {
			String sqlStr = "SELECT * FROM Application  ";
			
			start = start-1;
			if(start<0)
				start = 0;
					
			List<Application> lsApplication  = null;
			try {
				
				if (json != null && json.length() > 1) 
					sqlStr = sqlStr +  " WHERE " + JsonUtils.mapJsonCondNew2(json);
				
				if (limit != null && Integer.valueOf(limit) > 0) 
					sqlStr = sqlStr + " ORDER BY objid ASC OFFSET "+start+" ROWS FETCH NEXT "+limit+" ROWS ONLY ";
					
				lsApplication = entityManagerPA.createNativeQuery(sqlStr, Application.class)
						.getResultList();
				
				for (Application app : lsApplication) {
					app.setBank(priiCrm.findBankByID(app.getBankid()));
					app.setCampaign(findCampaignByID(app.getCampaignid()));
					app.setCardtype(priiCrm.findCardtypeByID(app.getCardtypeid()));
					app.setPlanhd(findPlanhdByID(app.getPlanid()));
					app.setPlanoption(findPlanoptionByID(app.getPlanoptionid()));
					app.setPlaninsure(findPlaninsureByID(app.getPlaninsureid()));
					app.setPlanprem(findPlanpremByID(app.getPlanpremid()));
					
					app.setQcuser(priiCrm.findUserByID(app.getQcuserid()));
					app.setStatus(priiCrm.findStatusByID(app.getStatusid()));
					app.setWavename(findWavenameByID(app.getWaveid()));
					String jsonStr = "{\"appid\":[\"=\",\"" + app.getAppid() + "\"]}";
					List<Question> lsQuestion = findQuestionByCond(jsonStr);
					if (lsQuestion != null && lsQuestion.size() > 0) {
						app.setQuestion((Question[])lsQuestion.toArray());
					}
					List<Client> lsClient = findClientByCond(jsonStr);
					if (lsClient != null && lsClient.size() > 0) {
						app.setClient((Client[])lsClient.toArray()); 
					}
				}
			
			} catch(Exception e) {
					e.printStackTrace();
			}
			return lsApplication;
		}
		public int countFindApplicationByCond(String json) throws Exception {
			String sqlStr = "SELECT count(appid) FROM Application  ";
			int result  = 0;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					result = (Integer) entityManagerPA.createNativeQuery(sqlStr + sqlWhere)
										.getSingleResult();
				} else {
					result = (Integer) entityManagerPA.createNativeQuery(sqlStr)
									.getSingleResult();
				}
				
			} catch(Exception e) {
					e.printStackTrace();
			}
			return result;
		}		
		//End Application
		
		//Start client
		public Client addCliect(Client entity) {
			entityManagerPA.persist(entity);
			return entity;
		}
		public List<Client> findClientByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Client  ";
			
				List<Client> lsClient  = null;
			try {
				
				if (json != null && json.length() > 1) 
					sqlStr = sqlStr +  " WHERE " + JsonUtils.mapJsonCondNew2(json);
				
				lsClient = entityManagerPA.createNativeQuery(sqlStr, Client.class)
						.getResultList();
			
			} catch(Exception e) {
					e.printStackTrace();
			}
			return lsClient;
		}
		public int deleteClient(long l) {
			int result = 0;
			String sqlStr = "DELETE FROM Client WHERE appid = ?1";
			try {
				Query qry = entityManagerPA.createNativeQuery(sqlStr);
				qry.setParameter(1, l);
				result = qry.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		//End client
		//Start Question
		public Question addQuestion(Question entity) {
			entityManagerPA.persist(entity);
			return entity;
		}
		public boolean updateQuestion(Question entity) {
			boolean result = false;
			try {
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
		}
		public Question findQuestionByID(long qid) {
			Question que = null;
			try {
				que = entityManagerPA.find( Question.class,qid);
				if (que != null) {
					String json = "{\"planid\":[\"=\"," + que.getPlanid() + "],\"questioncode\":[\"=\",\""+que.getQuestioncode()+"\"]}";
					List<Mainquestion> lsMainquestion = findMainquestionByCond(json);
					if (lsMainquestion != null && lsMainquestion.size() > 0) {
						que.setMainquestion(lsMainquestion.get(0));
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return que;
		}
		public List<Question> findQuestionByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Question  ";
			
				List<Question> lsQuestion  = null;
			try {
				
				if (json != null && json.length() > 1) 
					sqlStr = sqlStr +  " WHERE " + JsonUtils.mapJsonCondNew2(json);
				
				lsQuestion = entityManagerPA.createNativeQuery(sqlStr, Question.class)
						.getResultList();
				if (lsQuestion != null && lsQuestion.size() > 0) {
					for (Question que : lsQuestion) {
						String jsonStr = "{\"planid\":[\"=\"," + que.getPlanid() + "],\"questioncode\":[\"=\",\""+que.getQuestioncode()+"\"]}";
						List<Mainquestion> lsMainquestion = findMainquestionByCond(jsonStr);
						if (lsMainquestion != null && lsMainquestion.size() > 0) {
							que.setMainquestion(lsMainquestion.get(0));
						}
					}
				}
			} catch(Exception e) {
					e.printStackTrace();
			}
			return lsQuestion;
		}
		public int deleteQuestion(long l) {
			int result = 0;
			String sqlStr = "DELETE FROM Question WHERE appid = ?1";
			try {
				Query qry = entityManagerPA.createNativeQuery(sqlStr);
				qry.setParameter(1, l);
				result = qry.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		//End Question
		
		//Start Refer Target Application
		public RefTargetApp addRefTargetApp(RefTargetApp entity) {
			entityManagerPA.persist(entity);
			return entity;
		}
		//End Refer Target Application
		//Start PlanHd
		public Planhd savePlanhdEntity(Planhd entity) 	throws Exception {
			entityManagerPA.persist(entity);
			return entity;
		}
		public boolean updatePlanhdEntity(Planhd entity) throws Exception {
			boolean result = false;
			try {
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
				return result;
		}
		public Planhd findPlanhdByID(long planid) throws Exception {
			Planhd entity = null;
			try {
				entity = entityManagerPA.find(Planhd.class, planid);
				String str = "{\"planid\":[\"=\"," + entity.getPlanid() + "]}";	
				entity.setMainquestion(findMainquestionByCond(str));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return entity;
		}
		public List<Planhd> findPlanhdByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Planhd  ";
					
			List<Planhd> lsPlanhd  = null;
			try {
				if (json != null && json.length() > 1) {
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsPlanhd = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, Planhd.class)
								.getResultList();
				} else {
					lsPlanhd = entityManagerPA.createNativeQuery(sqlStr, Planhd.class)
							.getResultList();
				}
				for (Planhd hd : lsPlanhd) {
					String str = "{\"planid\":[\"=\"," + hd.getPlanid() + "]}";	
					hd.setMainquestion(findMainquestionByCond(str));
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsPlanhd;
		}
		//End Planhd
		//Start Planoption
		public Planoption savePlanoptionEntity(Planoption entity) 	throws Exception {
			entityManagerPA.persist(entity);
			return entity;
		}
		public boolean updatePlanoptionEntity(Planoption entity) throws Exception {
			boolean result = false;
			try {
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
		}
		public Planoption findPlanoptionByID(long planoptionid) throws Exception {
			Planoption entity = null;
			try {
				entity = entityManagerPA.find(Planoption.class, planoptionid);
								
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return entity;
		}
		public List<Planoption> findPlanoptionByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Planoption  ";
							
			List<Planoption> lsPlanoption  = null;
			try {
				if (json != null && json.length() > 1) {
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsPlanoption = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, Planoption.class)
								.getResultList();
				} else {
					lsPlanoption = entityManagerPA.createNativeQuery(sqlStr, Planoption.class)
							.getResultList();
				}
								
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsPlanoption;
		}
		//End Planoption
		//Start Planinsure
		public Planinsure savePlaninsureEntity(Planinsure entity) 	throws Exception {
			entityManagerPA.persist(entity);
			return entity;
		}
		public boolean updatePlaninsureEntity(Planinsure entity) throws Exception {
			boolean result = false;
			try {
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
		}
		public Planinsure findPlaninsureByID(long planinsureid) throws Exception {
			Planinsure entity = null;
			try {
				entity = entityManagerPA.find(Planinsure.class, planinsureid);
										
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return entity;
		}
		public List<Planinsure> findPlaninsureByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Planinsure  ";
									
			List<Planinsure> lsentity  = null;
			try {
				if (json != null && json.length() > 1) {
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsentity = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, Planinsure.class)
										.getResultList();
				} else {
					lsentity = entityManagerPA.createNativeQuery(sqlStr, Planinsure.class)
									.getResultList();
				}
										
			} catch(Exception e) {
				e.printStackTrace();
			}
					return lsentity;
		}
		//End Planinsure
		//Start Planinsure
		public Planprem savePlanpremEntity(Planprem entity) 	throws Exception {
			entityManagerPA.persist(entity);
			return entity;
		}
		public boolean updatePlanpremEntity(Planprem entity) throws Exception {
			boolean result = false;
			try {
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
		}
		public Planprem findPlanpremByID(long planpremid) throws Exception {
			Planprem entity = null;
			try {
				entity = entityManagerPA.find(Planprem.class, planpremid);
				entity.setPlaninsure(findPlaninsureByID(entity.getPlaninsureid()));								
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return entity;
		}
		public List<Planprem> findPlanpremByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Planprem  ";
											
			List<Planprem> lsentity  = null;
			try {
				if (json != null && json.length() > 1) {
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsentity = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, Planprem.class)
												.getResultList();
				} else {
					lsentity = entityManagerPA.createNativeQuery(sqlStr, Planprem.class)
											.getResultList();
				}
				for (Planprem pp : lsentity) {
					String str = "{\"Planinsureid\":[\"=\"," + pp.getPlaninsureid() + "]}";
					pp.setPlaninsure(findPlaninsureByCond(str).get(0));
					//pp.setPlaninsure(findPlaninsureByID(pp.getPlaninsureid()));	
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsentity;
		}
		//End Planprem
		//Start Ref Bank card plan
		public RefBankCardPlan saveRefBankCardPlanEntity(RefBankCardPlan entity) 	throws Exception {
			entityManagerPA.persist(entity);
			return entity;
		}
		public boolean updateRefBankCardPlanEntity(RefBankCardPlan entity) throws Exception {
			boolean result = false;
			try {
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
		}
		public RefBankCardPlan findRefBankCardPlanByID(long bcpid) throws Exception {
			RefBankCardPlan entity = null;
			try {
				entity = entityManagerPA.find(RefBankCardPlan.class, bcpid);
				entity.setBank(priiCrm.findBankByID((int)entity.getBankid()));	
				entity.setCardtype(priiCrm.findCardtypeByID((int)entity.getCardtypeid()));
			} catch (Exception e) {
						// TODO: handle exception
				e.printStackTrace();
			}
			return entity;
		}
		public List<RefBankCardPlan> findRefBankCardPlanByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM ref_bankcardplan  ";
													
			List<RefBankCardPlan> lsentity  = null;
			try {
				if (json != null && json.length() > 1) {
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsentity = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, RefBankCardPlan.class)
											.getResultList();
				} else {
					lsentity = entityManagerPA.createNativeQuery(sqlStr, RefBankCardPlan.class)
											.getResultList();
				}	
				for (RefBankCardPlan pp : lsentity) {
					String str = "{\"planpremid\":[\"=\"," + pp.getPlanpremid() + "]}";
					pp.setPlanprem(findPlanpremByCond(str).get(0));
					str = "{\"bankid\":[\"=\"," + pp.getBankid() + "]}";
					pp.setBank(priiCrm.findBankByCond(str).get(0));
					str = "{\"cardtypeid\":[\"=\"," + pp.getCardtypeid() + "]}";
					pp.setCardtype(priiCrm.findCardtypeByCond(str).get(0));
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsentity;
		}
		public List<Bank> findBankByPlanpremid(long planpremid) throws Exception {
			String sqlStr = "SELECT DISTINCT bankid FROM ref_bankcardplan ";
			List<Integer> lsentity = null;
			List<Bank> lsResult = new ArrayList<Bank>();
			try {
			
				String sqlWhere = " WHERE planpremid = " + planpremid;
				lsentity = entityManagerPA.createNativeQuery(sqlStr+ sqlWhere).getResultList();
				for (Integer i : lsentity) {
					String str = "{\"bankid\":[\"=\"," + i + "]}";
					Bank bank = priiCrm.findBankByCond(str).get(0);
					lsResult.add(bank);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return lsResult;
		}
		public List<Cardtype> findCardTypeByPlanpremidBankid(long planpremid, long bankid) throws Exception {
			String sqlStr = "SELECT DISTINCT cardtypeid FROM ref_bankcardplan ";
			List<Integer> lsentity = null;
			List<Cardtype> lsResult = new ArrayList<Cardtype>();
			try {
			
				String sqlWhere = " WHERE planpremid = " + planpremid + " AND bankid = " + bankid;
				lsentity = entityManagerPA.createNativeQuery(sqlStr+ sqlWhere).getResultList();
				for (Integer i : lsentity) {
					String str = "{\"cardtypeid\":[\"=\"," + i + "]}";
					Cardtype cardtype = priiCrm.findCardtypeByCond(str).get(0);
					lsResult.add(cardtype);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return lsResult;
		}
		//End Ref Bank card plan
		//Start Mainquestion
		public Mainquestion saveMainquestionEntity(Mainquestion entity) 	throws Exception {
			
			if (entity != null  ) {
				entityManagerPA.persist(entity);
				for (Submainquestion sub : entity.getSubmainquestion()) {
					sub.setMqid(entity.getMqid());
					saveSubmainquestionEntity(sub);
				}
				
			}
			
			return entity;
		}
		public boolean updateMainquestionEntity(Mainquestion entity) throws Exception {
			boolean result = false;
			try {
				if (entity != null  ) {
					entityManagerPA.merge(entity);
					for (Submainquestion sub : entity.getSubmainquestion()) {
						Submainquestion newSub = new Submainquestion();
						newSub.setMqid(sub.getMqid());
						newSub.setFieldvalue(sub.getFieldvalue());
						newSub.setFielddisplay(sub.getFielddisplay());
						newSub.setFieldlimit(sub.getFieldlimit());
						newSub.setFieldsize(sub.getFieldsize());
						saveSubmainquestionEntity(newSub);
						deleteSubmainquestion(sub.getSmqid());
					}
					result = true;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
		}
		public Mainquestion findMainquestionByID(long mqid) throws Exception {
			Mainquestion entity = null;
			try {
				entity = entityManagerPA.find(Mainquestion.class, mqid);
				String json = "{\"mqid\":[\"=\","+ mqid + "]}";
				List<Submainquestion> lsSub = findSubmainquestionByCond(json);
				if (lsSub != null) {
					Submainquestion[] arrSub = lsSub.toArray(new Submainquestion[lsSub.size()]);
					entity.setSubmainquestion(arrSub);
				}
 			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return entity;
		}
		public List<Mainquestion> findMainquestionByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Mainquestion  ";
							
			List<Mainquestion> lsMainquestion  = null;
			try {
				if (json != null && json.length() > 1) {
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsMainquestion = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, Mainquestion.class)
								.getResultList();
				} else {
					lsMainquestion = entityManagerPA.createNativeQuery(sqlStr, Mainquestion.class)
							.getResultList();
				}
				for (Mainquestion mainq : lsMainquestion) {
					String jsonStr = "{\"mqid\":[\"=\","+ mainq.getMqid() + "]}";
					List<Submainquestion> lsSub = findSubmainquestionByCond(jsonStr);
					if (lsSub != null) {
						Submainquestion[] arrSub = lsSub.toArray(new Submainquestion[lsSub.size()]);
						mainq.setSubmainquestion(arrSub);
					}	
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsMainquestion;
		}
		public int deleteMainquestion(long l) {
			int result = 0;
			String sqlStr = "DELETE FROM Mainquestion WHERE mqid = ?1";
			try {
				Query qry = entityManagerPA.createNativeQuery(sqlStr);
				qry.setParameter(1, l);
				result = qry.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		//End Mainquestion
		//Start SubMainquestion
		public Submainquestion saveSubmainquestionEntity(Submainquestion entity) 	throws Exception {
			entityManagerPA.persist(entity);
			return entity;
		}
		public boolean updateSubmainquestionEntity(Submainquestion entity) throws Exception {
			boolean result = false;
			try {
				entityManagerPA.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
		}
		public Submainquestion findSubmainquestionByID(long smqid) throws Exception {
			Submainquestion entity = null;
			try {
				entity = entityManagerPA.find(Submainquestion.class, smqid);
										
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return entity;
		}
		public List<Submainquestion> findSubmainquestionByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Submainquestion  ";
									
			List<Submainquestion> lsentity  = null;
			try {
				if (json != null && json.length() > 1) {
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsentity = entityManagerPA.createNativeQuery(sqlStr + sqlWhere, Submainquestion.class)
								.getResultList();
				} else {
					lsentity = entityManagerPA.createNativeQuery(sqlStr, Submainquestion.class)
							.getResultList();
				}
										
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsentity;
		}
		public int deleteSubmainquestion(long l) {
			int result = 0;
			String sqlStr = "DELETE FROM Submainquestion WHERE smqid = ?1";
			try {
				Query qry = entityManagerPA.createNativeQuery(sqlStr);
				qry.setParameter(1, l);
				result = qry.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		//End Submainquestion
}
