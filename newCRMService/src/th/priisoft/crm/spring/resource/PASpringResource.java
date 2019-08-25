package th.priisoft.crm.spring.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.jmx.snmp.Timestamp;

import sun.util.logging.resources.logging;
import th.priisoft.crm.common.constant.Constants;
import th.priisoft.crm.common.date.DateControl;
import th.priisoft.crm.common.model.AfgUploadReq;
import th.priisoft.crm.common.restfull.ResponseControl;
import th.priisoft.crm.common.restfull.ResponseObject;
import th.priisoft.crm.common.utils.CommonFileUtil;
import th.priisoft.crm.common.utils.JsonUtils;
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
import th.priisoft.crm.spring.entity.prii.padta.RequestCopyTarget;
import th.priisoft.crm.spring.entity.prii.padta.RequestOutbound;
import th.priisoft.crm.spring.entity.prii.padta.TargetCall;
import th.priisoft.crm.spring.entity.prii.padta.Wavename;
import th.priisoft.crm.spring.service.common.AfresgoService;
import th.priisoft.crm.spring.service.common.MasterService;
import th.priisoft.crm.spring.service.common.PAService;

@RestController
@RequestMapping(value = "/pa")
public class PASpringResource {
	@Autowired
	private PAService paService;
	@Autowired
	private MasterService msService;
	@Autowired
	private AfresgoService alfrescoService;
	//Start Campaign
	@RequestMapping(value = "/campaign/{campaignid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject campaignfindByID(@PathVariable("campaignid")long campaignid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Campaign campaign = paService.findCampaignByID(campaignid);
			if (campaign != null && campaign.getCampaignid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, campaign , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, campaign , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/campaign", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject campaignfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("Campaign filter : " + filter);
		try {
			List<Campaign> lsCampaign = paService.findCampaignByCond(filter);
			if (lsCampaign != null && lsCampaign.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsCampaign , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsCampaign , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/campaign", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject CampaignAdd(@RequestBody Campaign campaign) {
		ResponseControl RespCon = new ResponseControl();
		try {
			if (campaign.getDateCreate() == null) {
				campaign.setDateCreate(DateControl.toDaytoTimeStamp());
			}
			Campaign campaigns = paService.saveCampaignEntity(campaign);
			if (campaigns != null && campaigns.getCampaignid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, campaigns , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, campaigns , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/campaign/{campaignid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject campaignUpdate(@PathVariable("campaignid") int campaignid, @RequestBody Campaign campaign) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Campaign campaigns = paService.findCampaignByID(campaignid);
			if (campaigns != null) {
				campaigns.setCampaignname(campaign.getCampaignname());
				campaigns.setTarget(campaign.getTarget());
				campaigns.setStartDate(campaign.getStartDate());
				campaigns.setEndDate(campaign.getEndDate());
				campaigns.setDescTh(campaign.getDescTh());
				campaigns.setAgentDesc(campaign.getAgentDesc());
				campaigns.setStatus(campaign.getStatus());
				campaigns.setDateCreate(campaign.getDateCreate());
				campaigns.setUseridCreate(campaign.getUseridCreate());
				boolean result = paService.updateCampaignEntity(campaigns);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, campaign , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
			
	}
		
	//End Camapign
	//Start Wave name
	@RequestMapping(value = "/wavename/{waveid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject wavenamefindByID(@PathVariable("waveid")long waveid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Wavename wavename = paService.findWavenameByID(waveid);
			if (wavename != null && wavename.getWaveid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, wavename , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, wavename , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/wavename", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject wavenamefindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("wavename filter : " + filter);
		try {
			List<Wavename> lsWavename = paService.findWavenameByCond(filter);
			if (lsWavename != null && lsWavename.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsWavename , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsWavename , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/wavename", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject wavenameAdd(@RequestBody Wavename wavename) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Wavename wavenames = paService.saveWavenameEntity(wavename);
			if (wavenames != null && wavenames.getWaveid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, wavenames , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, wavenames , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	
	//End Wave name
	//Start Outbound
		
		@RequestMapping(value = "/oblead/{objid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject outboundfindByID(@PathVariable("objid")long objid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Outbound outbound = paService.findOutboundByID(objid);
				if (outbound != null && outbound.getObjid() > 0) {
					outbound.setCampaign(paService.findCampaignByID(outbound.getCampaignid()));
					outbound.setWavename(paService.findWavenameByID(outbound.getWaveid()));
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, outbound , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, outbound , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/oblead", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject outboundfindByCode(@RequestParam(required = false) String filter,@RequestParam(required = false) String limit,@RequestParam(required = false,defaultValue="0")int start) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("Outbound filter : " + filter);
			try {
				//List<Outbound> lsOutbound = paService.findOutboundByCond(filter,limit);
				int num = paService.countFindOutboundByCond2(filter);
				List<Outbound> lsOutbound  = (num<1)?null:paService.findOutboundByCond2(filter,limit,start);
				
				if (lsOutbound != null && lsOutbound.size() > 0) {
					Object[] returnObj = new Object[2]; 
					returnObj[0]=lsOutbound; 
					returnObj[1]=num;
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, returnObj , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsOutbound , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		
		@RequestMapping(value = "/oblead2", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject outboundfindByCode2(@RequestParam(required = false) String filter,@RequestParam(required = false) String limit,@RequestParam(required = false,defaultValue="0")int start) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("Outbound filter : " + filter);
			try {
				
				int num = paService.countFindOutboundByCond2(filter);
				List<Outbound> lsOutbound  = (num<1)?null:paService.findOutboundByCond2(filter,limit,start);
		
				if (lsOutbound != null && lsOutbound.size() > 0) {
					
					Object[] returnObj = new Object[2]; 
						returnObj[0]=lsOutbound; 
						returnObj[1]=num;
						
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, returnObj , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsOutbound , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		
		@RequestMapping(value = "/oblead", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject outboundAdd(@RequestBody Outbound[] outbound) {
			ResponseControl RespCon = new ResponseControl();
			ArrayList<Outbound> lsOutbound = new ArrayList<>();
			try {
				if (outbound != null) {
					for (Outbound oblead : outbound) {
						if (oblead.getDateCreate() == null) {
							oblead.setDateCreate(DateControl.toDaytoTimeStamp());
						}
						Outbound ob = paService.saveOutboundEntity(oblead);
						lsOutbound.add(ob);
					}
				}
		
				if (lsOutbound != null && lsOutbound.size() > 0) {
					Outbound[] arrOb = lsOutbound.toArray(new Outbound[lsOutbound.size()]);
					if (arrOb != null && arrOb.length > 0) {
						return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, arrOb , Constants.Response.POST_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, arrOb , Constants.Response.POST_ALREADY_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.POST_NOTINSERT_STATUS, null , Constants.Response.POST_NOTINSERT_MSG);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/oblead/{objid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject outboundUpdate(@PathVariable("objid") int objid, @RequestBody Outbound outbound) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Outbound outbounds = paService.findOutboundByID(objid);
				if (outbounds != null) {
					
					boolean result = paService.updateOutboundEntity(outbound);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, null , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
			
		}
		@RequestMapping(value = "/importoblead", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject outboundImport(@RequestBody RequestOutbound reqOb) {
			ResponseControl RespCon = new ResponseControl();
			ArrayList<Outbound> lsOutbound = new ArrayList<>();
			int success = 0;
			java.sql.Timestamp usertime = new java.sql.Timestamp(new Date().getTime());
			
			try {
				System.out.println(" #### importoblead2 ### ");
				System.out.println("start add " + DateControl.timestampToString(usertime, "yyyy-MM-dd-HH.mm.ss"));
				Wavename wn = paService.findWavenameByID(reqOb.getWave().getWaveid());
				if (wn!=null && wn.getWaveid() > 0 && reqOb.getUserid() > 0) {
					if (reqOb.getOutbound() != null && reqOb.getOutbound().trim().length() > 0) {
						
						String json = CommonFileUtil.getInstance().readFileBase64(reqOb.getOutbound());
						if(!json.startsWith("[")&&json.indexOf("[")>-1) {
							int index = json.indexOf("[");
							json = json.substring(index, json.length());
						}
						Outbound[] objArray =  JsonUtils.mapJsonString(json, Outbound[].class);
						
						for (Outbound oblead : objArray) {
							oblead.setWaveid(wn.getWaveid());
							oblead.setUseridCreate(reqOb.getUserid());
							oblead.setDateCreate(usertime);
							lsOutbound.add(oblead);
							if(lsOutbound.size()>10000) {
								paService.saveOutboundEntity(lsOutbound);
								lsOutbound = new ArrayList<Outbound>();
							}
							success++;
						}
						if(lsOutbound.size()>0) {
							paService.saveOutboundEntity(lsOutbound);
							lsOutbound = new ArrayList<Outbound>();
						}
					}
					 usertime = new java.sql.Timestamp(new Date().getTime());
					System.out.println("size = "+success+" end add " + DateControl.timestampToString(usertime, "yyyy-MM-dd-HH.mm.ss"));
					if (success > 0) {
						return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, success , Constants.Response.POST_SUCCESS_MSG);
					} else {
						return  RespCon.resObj(Constants.Response.POST_NOTINSERT_STATUS, null , Constants.Response.POST_NOTINSERT_MSG);
					}
				} else {
					return  RespCon.resObj(Constants.Response.POST_NOTINSERT_STATUS, null , Constants.Response.POST_NOTINSERT_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/copyobtarget", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject outboundCopy(@RequestBody RequestCopyTarget reqObj) {
			ResponseControl RespCon = new ResponseControl();
			ArrayList<Outbound> lsOutbound = new ArrayList<>();
			java.sql.Timestamp usertime = new java.sql.Timestamp(new Date().getTime());
			int i;
			String strResult = "Copy success total : ";
			try {
				for (int objid : reqObj.getObjid()) {
					Outbound out = paService.findOutboundByID(objid);
					out.setObjid(0);
					out.setReferenceCode(out.getReferenceCode() + "-Ref-" + paService.getMaxOutboundByRefCode(out.getReferenceCode()));
					out.setCopyObjid(out.getObjid());
					out.setUseridCreate(reqObj.getUserid());
					out.setDateCreate(usertime);
					lsOutbound.add(out);
				}
				if (lsOutbound.size() > 0) {
					paService.saveOutboundEntity(lsOutbound);
					if (lsOutbound != null && lsOutbound.size() > 0) {
						Outbound[] arrOb = lsOutbound.toArray(new Outbound[lsOutbound.size()]);
						if (arrOb != null && arrOb.length > 0) {
							strResult += lsOutbound.size() + " rows";
							return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, strResult , Constants.Response.POST_SUCCESS_MSG);
						} else {
							return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, null , Constants.Response.POST_ALREADY_MSG);
						}
					} else {
						return RespCon.resObj(Constants.Response.POST_NOTINSERT_STATUS, null , Constants.Response.POST_NOTINSERT_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.POST_NOTINSERT_STATUS, null , Constants.Response.POST_NOTINSERT_MSG);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/addcampaign", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject addCampaign(@RequestBody Map<String,Object> body) {
			Object upd = (Object) body.get("upd");
			ResponseControl RespCon = new ResponseControl();
			System.out.println("add Campaign filter : " + upd);
			try {
				
				if( upd==null  )
					throw new Exception("upd is not exit!");
				
				boolean result = paService.addCampaign2(upd);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/addcampaignbycond", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject addCamapignByCode(@RequestBody String body) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("add Campaign filter : " + body);
			try {
				if( body==null || body.trim().length() ==  0 )
					throw new Exception("filter is not exit!");
				boolean result = paService.addCampaignStr(body);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}

		@RequestMapping(value = "/reassigntargetbycond", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject reassigntargetbycond(@RequestBody String body) {
			
			ResponseControl RespCon = new ResponseControl();
			System.out.println("reassign target by cond filter : " + body);
			try {
				
				if( body==null || body.trim().length() ==  0 )
					throw new Exception("filter is not exit!");
				
				boolean result = paService.reAssignOutboundStr(body);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/reassigntarget", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject reassigntarget2(@RequestBody Map<String,Object> body) {
			Object upd = (Object) body.get("upd");
		
			ResponseControl RespCon = new ResponseControl();
			System.out.println("reassign target filter : " + upd);
			try {
				
				if( upd==null  )
					throw new Exception("upd is not exit!");
				
				boolean result = paService.reAssignOutbound2(upd);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}

		@RequestMapping(value = "/moveuserbycond", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject moveUserToOutboundByCond(@RequestBody String body) {
			
			ResponseControl RespCon = new ResponseControl();
			System.out.println("move User to Outbound by cond filter : " + body);
			try {

				if( body==null || body.trim().length() ==  0 )
					throw new Exception("filter is not exit!");
				boolean result = paService.moveUserToOutboundStr(body);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		
		@RequestMapping(value = "/moveuser", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject moveUserToOutbound2(@RequestBody Map<String,Object> body) {
			Object upd = (Object) body.get("upd");
			
			ResponseControl RespCon = new ResponseControl();
			System.out.println("move User to Outbound filter : " + upd);
			try {

				if( upd==null )
					throw new Exception("upd is not exit!");
				boolean result = paService.moveUserToOutbound2(upd);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		
		@RequestMapping(value = "/deleteOutbound/{waveid}", method = RequestMethod.DELETE ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject deleteOutboundByWaveid(@PathVariable("waveid") int waveid) {
			
			ResponseControl RespCon = new ResponseControl();
			String str = "ลบข้อมูล Outbouad Lead จำนวน ";
			try {
				//int waveid = (int) body.get("waveid");
				System.out.println("delete outbound filter : " + waveid);
				if( waveid ==  0 )
					throw new Exception("upd is not exit!");
				
				int result = paService.deleteOutbound(waveid);
				str += result + " เรคคอร์ด ";
				if (result > 0) {
					
					return RespCon.resObj(Constants.Response.DELETE_SUCCESS_STATUS, str , Constants.Response.DELETE_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, str , Constants.Response.DELETE_NOTFOUND_MSG);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		//End Outbound
		//Start Document
		@RequestMapping(value = "/document/{documentid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject documentfindByID(@PathVariable("documentid")long documentid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Document document = paService.findDocumentByID(documentid);
				if (document != null && document.getDocumentid() > 0) {
					
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, document , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, document , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/document", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject documentfindByCode(@RequestParam(required = false) String filter) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("Document filter : " + filter);
			try {
				List<Document> lsDocument = paService.findDocumentByCond(filter);
				if (lsDocument != null && lsDocument.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsDocument , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsDocument , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/document", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject DocumentAdd(@RequestBody Document document) {
			ResponseControl RespCon = new ResponseControl();
			String uid = "";
			try {
				//start insert document into Rest api of Alfresco
				AfgUploadReq afUploadReq = new AfgUploadReq();
				afUploadReq.setFilestring(document.getDoc());
			    afUploadReq.setFileName(document.getDocumentname());
			    afUploadReq.setUploaddirectory("/Doc for Tax Deduction/2018/agent");
			    afUploadReq.setContainerid("documentLibrary");
			    String json =JsonUtils.genJsonString( alfrescoService.uploadDoc(afUploadReq));
			    JSONObject object = (JSONObject) JSONValue.parse(json);
			    uid = (String)((JSONObject)object.get("resultObj")).get("UID");
				//end insert into data store
				document.setUid(uid);
				if (document.getDateCreate() == null) {
					document.setDateCreate(DateControl.toDaytoTimeStamp());
				}
				paService.saveDocumentEntity(document);
				if (document != null && document.getDocumentid() > 0) {
					
					return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, document , Constants.Response.POST_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, document , Constants.Response.POST_ALREADY_MSG);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/document/{documentid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject documentUpdate(@PathVariable("documentid") int documentid, @RequestBody Document document) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Document documents = paService.findDocumentByID(documentid);
				if (document != null) {
					
					boolean result = paService.updateDocumentEntity(document);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, null , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
			
		}
		@RequestMapping(value = "/loaddocument/{uid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject documentUpdate(@PathVariable("uid") String uid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				//Get Document from Rest api of Alfresco 
				String pdf = JsonUtils.genJsonString(alfrescoService.getDoc(uid));
				if (pdf != null && pdf.length() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, pdf , Constants.Response.GET_SUCCESS_MSG	);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, null , Constants.Response.GET_NOTFOUND_MSG);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
			
		}
		//End Document
		
		//Start remider app
		@RequestMapping(value = "/remiderapp/{userid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject remiderapp(@PathVariable("userid") int userid) {
			ResponseControl RespCon = new ResponseControl();
			String cond = "{\"userid_create\":[\"=\",\"" + userid + "\"],\"remider\":[\"=\",\"Y\"]}";
			try {
				List<AppCall> lsAppCall = paService.findAppCallByCond(cond);
				if (lsAppCall != null && lsAppCall.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsAppCall , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, null , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
			
		}
		
		@RequestMapping(value = "/callapp/{callappid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject callappfindByID(@PathVariable("callappid")long callappid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				AppCall appcall = paService.findAppCallByID(callappid);
				if (appcall != null && appcall.getAppcallsid() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, appcall , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, appcall , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/callapp", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject appcallfindByCode(@RequestParam(required = false) String filter) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("callapp filter : " + filter);
			try {
				List<AppCall> lsAppCall = paService.findAppCallByCond(filter);
				if (lsAppCall != null && lsAppCall.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsAppCall , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsAppCall , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/callapp", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject callappAdd(@RequestBody AppCall callapp) {
			ResponseControl RespCon = new ResponseControl();
			try {
				
				if (callapp.getDateCreate() == null) {
					callapp.setDateCreate(DateControl.toDaytoTimeStamp());
				}
				AppCall callapps = paService.saveAppCallEntity(callapp);
				if (callapps != null && callapps.getAppcallsid() > 0) {
					return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, callapps , Constants.Response.POST_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, callapps , Constants.Response.POST_ALREADY_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/callapp/{callappid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject callappUpdate(@PathVariable("callappid") int callappid, @RequestBody AppCall callapp) {
			ResponseControl RespCon = new ResponseControl();
			try {
				AppCall callapps = paService.findAppCallByID(callappid);
				if (callapps != null) {
					callapps.setSubject(callapp.getSubject());
					callapps.setStatusid(callapp.getStatusid());
					callapps.setReasonid(callapp.getReasonid());
					callapps.setAppointment(callapp.getAppointment());
					callapps.setRemider(callapp.getRemider());
					callapps.setDescTh(callapp.getDescTh());
					
					boolean result = paService.updateAppCallEntity(callapps);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, callapps , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		//end remider app
		
		//Start Application
		@RequestMapping(value = "/app/{applicationid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject applicationfindByID(@PathVariable("applicationid")long applicationid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Application app = paService.findApplicationByID(applicationid);
				if (app != null && app.getAppid() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, app , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, app , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
						
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/app", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject applicationfindByCode(@RequestParam(required = false) String filter,@RequestParam(required = false) String limit,@RequestParam(required = false,defaultValue="0")int start) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("Application filter : " + filter);
			try {
				//List<Outbound> lsOutbound = paService.findOutboundByCond(filter,limit);
				int num = paService.countFindApplicationByCond(filter);
				List<Application> lsApplication  = (num<1)?null:paService.findApplicationByCond(filter,limit,start);
						
				if (lsApplication != null && lsApplication.size() > 0) {
					Object[] returnObj = new Object[2]; 
					returnObj[0]=lsApplication; 
					returnObj[1]=num;
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, returnObj , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, null , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
				
		@RequestMapping(value = "/app", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject applicationAdd(@RequestBody Application app) {
			ResponseControl RespCon = new ResponseControl();
			
			try {
				
					if (app.getDatecreate() == null) {
						app.setDatecreate(DateControl.toDaytoTimeStamp());
					}
							
					Application appNew = paService.saveApplicationEntity(app);
			
					if (appNew != null && appNew.getAppid() > 0) {
						return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, appNew , Constants.Response.POST_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.POST_NOTINSERT_STATUS, null , Constants.Response.POST_NOTINSERT_MSG);
					}
						
				} catch (Exception e) {
					e.printStackTrace();
					return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
				}
		}
		
		@RequestMapping(value = "/app/{applicationid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject applicationUpdate(@PathVariable("applicationid") int applicationid, @RequestBody Application app) {
			ResponseControl RespCon = new ResponseControl();
			try {
					Application apps = paService.findApplicationByID(applicationid);
					if (apps != null) {
						boolean result = paService.updateApplicationEntity(app);
						if (result) {
							return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
						} else {
							return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
						}
					} else {
						return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, null , Constants.Response.PUT_NOTFOUND_MSG);
					}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
					
		}
		
		
		//End Application
		//Start Planhd
		@RequestMapping(value = "/planhd/{planid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planhdfindByID(@PathVariable("planid")long planid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Planhd entity = paService.findPlanhdByID(planid);
				if (entity != null && entity.getPlanid() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, entity , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, entity , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planhd", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planhdfindByCode(@RequestParam(required = false) String filter) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("Planhd filter : " + filter);
			try {
				List<Planhd> lsPlanhd = paService.findPlanhdByCond(filter);
				if (lsPlanhd != null && lsPlanhd.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsPlanhd , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsPlanhd , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planhd", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planhdAdd(@RequestBody Planhd planhd) {
			ResponseControl RespCon = new ResponseControl();
			try {
				
				Planhd planhds = paService.savePlanhdEntity(planhd);
				if (planhds != null && planhds.getPlanid() > 0) {
					return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, planhds , Constants.Response.POST_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, planhds , Constants.Response.POST_ALREADY_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planhd/{planid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planhdUpdate(@PathVariable("planid") int planid, @RequestBody Planhd planhd) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Planhd planhds = paService.findPlanhdByID(planid);
				if (planhds != null) {
					planhds.setPlancode(planhd.getPlancode());
					planhds.setPlandescEn(planhd.getPlandescEn());
					planhds.setPlandescTh(planhd.getPlandescTh());
					planhds.setDateForm(planhd.getDateForm());
					planhds.setDateTo(planhd.getDateTo());
					planhds.setTarget(planhd.getTarget());
					planhds.setActive(planhd.getActive());
					
					boolean result = paService.updatePlanhdEntity(planhds);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, planhd , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
				
		}
			
		//End Planhd
		//Start Planoption
		@RequestMapping(value = "/planoption/{planoptionid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planoptionfindByID(@PathVariable("planoptionid")long planoptionid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Planoption entity = paService.findPlanoptionByID(planoptionid);
				if (entity != null && entity.getPlanoptionid() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, entity , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, entity , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
						
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planoption", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planoptionfindByCode(@RequestParam(required = false) String filter) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("Planoption filter : " + filter);
			try {
				List<Planoption> lsentity = paService.findPlanoptionByCond(filter);
				if (lsentity != null && lsentity.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsentity , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsentity , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planoption", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planoptionAdd(@RequestBody Planoption planoption) {
			ResponseControl RespCon = new ResponseControl();
			try {
						
				Planoption entity = paService.savePlanoptionEntity(planoption);
				if (entity != null && entity.getPlanoptionid() > 0) {
					return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, entity , Constants.Response.POST_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, entity , Constants.Response.POST_ALREADY_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planoption/{planoptionid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planoptionUpdate(@PathVariable("planoptionid") long planoptionid, @RequestBody Planoption planoption) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Planoption entity = paService.findPlanoptionByID(planoptionid);
				if (entity != null) {
					entity.setPlanhd(planoption.getPlanhd());
					entity.setPlanoptioncode(planoption.getPlanoptioncode());
					entity.setPlanoptionTh(planoption.getPlanoptionTh());
					entity.setPlanoptionEn(planoption.getPlanoptionEn());
					entity.setPerson(planoption.getPerson());		
					boolean result = paService.updatePlanoptionEntity(entity);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, planoption , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
						
		}
					
		//End planoption
		//Start Planinsure
		@RequestMapping(value = "/planinsure/{planinsureid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planinsurefindByID(@PathVariable("planinsureid")long planinsureid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Planinsure entity = paService.findPlaninsureByID(planinsureid);
				if (entity != null && entity.getPlaninsureid() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, entity , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, entity , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
								
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planinsure", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planinsurefindByCode(@RequestParam(required = false) String filter) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("Planinsure filter : " + filter);
			try {
				List<Planinsure> lsentity = paService.findPlaninsureByCond(filter);
				if (lsentity != null && lsentity.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsentity , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsentity , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planinsure", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planinsureAdd(@RequestBody Planinsure planinsure) {
			ResponseControl RespCon = new ResponseControl();
			try {
								
				Planinsure entity = paService.savePlaninsureEntity(planinsure);
				if (entity != null && entity.getPlaninsureid() > 0) {
					return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, entity , Constants.Response.POST_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, entity , Constants.Response.POST_ALREADY_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planinsure/{planinsureid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planinsureUpdate(@PathVariable("planinsureid") long planinsureid, @RequestBody Planinsure planinsure) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Planinsure entity = paService.findPlaninsureByID(planinsureid);
				if (entity != null) {
					entity.setPlanhd(planinsure.getPlanhd());
					entity.setPlanoption(planinsure.getPlanoption());
					entity.setPlaninsurecode(planinsure.getPlaninsurecode());
					entity.setPlaninsureEn(planinsure.getPlaninsureEn());
					entity.setPlaninsureTh(planinsure.getPlaninsureTh());
					entity.setSuminsure(planinsure.getSuminsure());
					entity.setGrosspremium(planinsure.getGrosspremium());
					entity.setNetpremium(planinsure.getNetpremium());
									
					boolean result = paService.updatePlaninsureEntity(entity);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
					}
				} else {
						return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, planinsure , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
								
		}
							
		//End planinsure
		//Start Planprem
		@RequestMapping(value = "/planprem/{planpremid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planpremfindByID(@PathVariable("planpremid")long planpremid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Planprem entity = paService.findPlanpremByID(planpremid);
				if (entity != null && entity.getPlanpremid() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, entity , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, entity , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
										
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planprem", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planpremfindByCode(@RequestParam(required = false) String filter) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("Planprem filter : " + filter);
			try {
				List<Planprem> lsentity = paService.findPlanpremByCond(filter);
				if (lsentity != null && lsentity.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsentity , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsentity , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planprem", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planpremAdd(@RequestBody Planprem planprem) {
			ResponseControl RespCon = new ResponseControl();
			try {
										
				Planprem entity = paService.savePlanpremEntity(planprem);
				if (entity != null && entity.getPlanpremid() > 0) {
					return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, entity , Constants.Response.POST_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, entity , Constants.Response.POST_ALREADY_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/planprem/{planpremid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject planpremUpdate(@PathVariable("planpremid") long planpremid, @RequestBody Planprem planprem) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Planprem entity = paService.findPlanpremByID(planpremid);
				if (entity != null) {
					entity.setMaxage(planprem.getMaxage());
					entity.setMinage(planprem.getMinage());
					entity.setType(planprem.getType());
					entity.setPlanpremname(planprem.getPlanpremname());
					entity.setNetprem1(planprem.getNetprem1());
					
					entity.setPlaninsureid(planprem.getPlaninsure().getPlaninsureid());
									
					boolean result = paService.updatePlanpremEntity(entity);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
					}
				} else {
						return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, planprem , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
								
		}
									
	//End planprem
	//Start Ref plan prem bank cardtype
	@RequestMapping(value = "/getBankByPlanprem/{planpremid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject getBankByPlanprem(@PathVariable("planpremid") long planpremid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			List<Bank> lsentity = paService.findBankByPlanpremid(planpremid);
			if (lsentity != null && lsentity.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsentity , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsentity , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/getCardTypeByPlanpremBank/{planpremid}/{bankid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject getBankByPlanprem(@PathVariable("planpremid") long planpremid,@PathVariable("bankid") long bankid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			List<Cardtype> lsentity = paService.findCardTypeByPlanpremidBankid(planpremid, bankid);
			if (lsentity != null && lsentity.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsentity , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsentity , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Ref plan prem bank cardtype
	//Start Mainquestion
	@RequestMapping(value = "/mainquestion/{mqid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject mainquestionfindByID(@PathVariable("mqid")long mqid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Mainquestion entity = paService.findMainquestionByID(mqid);
			if (entity != null && entity.getMqid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, entity , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, entity , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
									
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/mainquestion", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject mainquestionfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("mainquestion filter : " + filter);
		try {
			List<Mainquestion> lsentity = paService.findMainquestionByCond(filter);
			if (lsentity != null && lsentity.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsentity , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsentity , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/mainquestion", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject mainquestionAdd(@RequestBody Mainquestion mainquestion) {
		ResponseControl RespCon = new ResponseControl();
		try {
									
			Mainquestion entity = paService.saveMainquestionEntity(mainquestion);
			if (entity != null && entity.getMqid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, entity , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, entity , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/mainquestion/{mqid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject mainquestionUpdate(@PathVariable("mqid") long mqid, @RequestBody Mainquestion mainquestion) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Mainquestion entity = paService.findMainquestionByID(mqid);
			if (entity != null) {
				entity.setPlanid(mainquestion.getPlanid());
				entity.setQuestionCode(mainquestion.getQuestionCode());
				entity.setQuestionDesc(mainquestion.getQuestionDesc());
				entity.setQuestiontype(mainquestion.getQuestiontype());
										
				boolean result = paService.updateMainquestion(entity);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, "" , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, mainquestion , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
									
	}
	@RequestMapping(value = "/mainquestion/{mqid}", method = RequestMethod.DELETE ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject deletemainquestionByMqid(@PathVariable("mqid") int mqid) {
		
		ResponseControl RespCon = new ResponseControl();
		String str = "ลบข้อมูล Outbouad Lead จำนวน ";
		try {
			//int waveid = (int) body.get("waveid");
			System.out.println("delete mainquestion filter : " + mqid);
			if( mqid ==  0 )
				throw new Exception("upd is not exit!");
			
			int result = paService.deleteMainquestion(mqid);
			str += result + " เรคคอร์ด ";
			if (result > 0) {
				
				return RespCon.resObj(Constants.Response.DELETE_SUCCESS_STATUS, str , Constants.Response.DELETE_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, str , Constants.Response.DELETE_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}							
	//End mainquestion
}
