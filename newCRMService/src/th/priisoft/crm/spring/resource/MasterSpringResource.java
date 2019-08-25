package th.priisoft.crm.spring.resource;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import th.priisoft.crm.common.constant.Constants;
import th.priisoft.crm.common.date.DateControl;
import th.priisoft.crm.common.restfull.ResponseControl;
import th.priisoft.crm.common.restfull.ResponseObject;
import th.priisoft.crm.common.utils.JsonUtils;
import th.priisoft.crm.spring.entity.prii.crmdta.AccessMenu;
import th.priisoft.crm.spring.entity.prii.crmdta.Bank;
import th.priisoft.crm.spring.entity.prii.crmdta.Cardtype;
import th.priisoft.crm.spring.entity.prii.crmdta.FullUser;
import th.priisoft.crm.spring.entity.prii.crmdta.Gender;
import th.priisoft.crm.spring.entity.prii.crmdta.Groupmenu;
import th.priisoft.crm.spring.entity.prii.crmdta.Label;
import th.priisoft.crm.spring.entity.prii.crmdta.Menu;
import th.priisoft.crm.spring.entity.prii.crmdta.Module;
import th.priisoft.crm.spring.entity.prii.crmdta.Param;
import th.priisoft.crm.spring.entity.prii.crmdta.Partner;
import th.priisoft.crm.spring.entity.prii.crmdta.Product;
import th.priisoft.crm.spring.entity.prii.crmdta.Province;
import th.priisoft.crm.spring.entity.prii.crmdta.Reason;
import th.priisoft.crm.spring.entity.prii.crmdta.RefMaster;
import th.priisoft.crm.spring.entity.prii.crmdta.Role;
import th.priisoft.crm.spring.entity.prii.crmdta.Status;
import th.priisoft.crm.spring.entity.prii.crmdta.Title;
import th.priisoft.crm.spring.entity.prii.crmdta.TmpRoleMenu;
import th.priisoft.crm.spring.entity.prii.crmdta.User;
import th.priisoft.crm.spring.entity.prii.crmdta.UsersHi;
import th.priisoft.crm.spring.service.common.CommonService;
import th.priisoft.crm.spring.service.common.MasterService;
import th.priisoft.crm.spring.service.common.PAService;

@RestController
@RequestMapping(value = "/master")
public class MasterSpringResource {
	Logger logger = Logger.getLogger(MasterSpringResource.class);
	@Autowired
	private CommonService commonService;
	@Autowired
	private MasterService masterService;
	@Autowired
	private PAService paService;

	//Start Bank
	@RequestMapping(value = "/bank/{bankid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject bankfindByID(@PathVariable("bankid")int bankid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Bank bank = masterService.findBankByID(bankid);
			if (bank != null && bank.getBankid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, bank , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, bank , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/bank", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject bankfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("Bank filter : " + filter);
		try {
			List<Bank> lsBank = masterService.findBankByCond(filter);
			if (lsBank != null && lsBank.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsBank , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsBank , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/bank", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject bankAdd(@RequestBody Bank bank) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Bank banks = masterService.saveBankEnttiy(bank);
			if (bank != null && bank.getBankid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, bank , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, bank , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/bank/{bankid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject bankUpdate(@PathVariable("bankid") int bankid, @RequestBody Bank bank) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Bank banks = masterService.findBankByID(bankid);
			if (banks != null) {
				banks.setBankcode(bank.getBankcode());
				banks.setBanknameEn(bank.getBanknameEn());
				banks.setBanknameTh(bank.getBanknameTh());
				banks.setSwiftcode(bank.getSwiftcode());
				boolean result = masterService.updateBankEnttiy(banks);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, bank , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
		
	}
	//End Bank
	
	//Start Module
	@RequestMapping(value = "/module/{moduleid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject modulefindByID(@PathVariable("moduleid")int moduleid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Module module = masterService.findModuleByID(moduleid);
			if (module != null && module.getModuleid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, module , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, module , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/module", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject modulefindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("module filter : " + filter);
		try {
			List<Module> lsModule = masterService.findModuleByCond(filter);
			if (lsModule != null && lsModule.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsModule , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsModule , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/module", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject ModuleAdd(@RequestBody Module module) {
		ResponseControl RespCon = new ResponseControl();
		try {
			
			Module modules = masterService.saveModuleEnttiy(module);
			if (modules != null && modules.getModuleid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, modules , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, modules , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/module/{moduleid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject ModuleUpdate(@PathVariable("moduleid") int moduleid, @RequestBody Module module) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Module modules = masterService.findModuleByID(moduleid);
			if (modules != null) {
				modules.setModulename(module.getModulename());
				boolean result = masterService.updateModuleEnttiy(modules);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, module , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Module
	
	//Start Status
	@RequestMapping(value = "/status/{statusid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject statusfindByID(@PathVariable("statusid")int statusid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Status status = masterService.findStatusByID(statusid);
			if (status != null && status.getStatusid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, status , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, status , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/status", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject statusfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("status filter : " + filter);
		try {
			if (filter.toUpperCase().indexOf("MODULEID") > 0) {
				List<Status> lsStatus = masterService.findStatusByCond(filter);
				if (lsStatus != null && lsStatus.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsStatus , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsStatus , Constants.Response.GET_NOTFOUND_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, "" , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/status", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject statusAdd(@RequestBody Status status) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Status statusR = masterService.saveStatusEnttiy(status);
			if (statusR != null && statusR.getStatusid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, statusR , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, statusR , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/status/{statusid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject statusUpdate(@PathVariable("statusid") int statusid, @RequestBody Status status) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Status statusR = masterService.findStatusByID(statusid);
			if (statusR != null) {
				statusR.setModuleid(status.getModuleid());
				statusR.setStatuscode(status.getStatuscode());
				statusR.setStatusdescEn(status.getStatusdescEn());
				statusR.setStatusdescTh(status.getStatusdescTh());
				boolean result = masterService.updateStatusEnttiy(statusR);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, status , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Status
	//Start Reason
	@RequestMapping(value = "/reason/{reasonid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject reasonfindByID(@PathVariable("reasonid")int reasonid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Reason reason = masterService.findReasonByID(reasonid);
			if (reason != null && reason.getReasonid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, reason , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, reason , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/reason", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject reasonfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("reason filter : " + filter);
		try {
			
				List<Reason> lsReason = masterService.findReasonByCond(filter);
				if (lsReason != null && lsReason.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsReason , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsReason , Constants.Response.GET_NOTFOUND_MSG);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/reason", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject reasonAdd(@RequestBody Reason reason) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Reason reasonR = masterService.saveReasonEnttiy(reason);
			if (reasonR != null && reasonR.getStatusid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, reasonR , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, reasonR , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/reason/{reasonid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject reasonUpdate(@PathVariable("reasonid") int reasonid, @RequestBody Reason reason) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Reason reasonR = masterService.findReasonByID(reasonid);
			if (reasonR != null) {
				reasonR.setStatusid(reason.getStatusid());
				reasonR.setReasoncode(reason.getReasoncode());
				reasonR.setReasondescEn(reason.getReasondescEn());
				reasonR.setReasondescTh(reason.getReasondescTh());
				
				boolean result = masterService.updateReasonEnttiy(reasonR);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, reason , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Reason
	//Start Card type
	@RequestMapping(value = "/cardtype/{cardtypeid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject cardtypefindByID(@PathVariable("cardtypeid")int cardtypeid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Cardtype cardtype = masterService.findCardtypeByID(cardtypeid);
			if (cardtype != null && cardtype.getCardtypeid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, cardtype , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, cardtype , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/cardtype", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject cardtypefindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("cardtype filter : " + filter);
		try {
			
			List<Cardtype> lsCardtype = masterService.findCardtypeByCond(filter);
			if (lsCardtype != null && lsCardtype.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsCardtype , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsCardtype , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/cardtype", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject cardtypeAdd(@RequestBody Cardtype cardtype) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Cardtype cardtypeR = masterService.saveCardtypeEnttiy(cardtype);
			if (cardtypeR != null && cardtypeR.getCardtypeid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, cardtypeR , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, cardtypeR , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/cardtype/{cardtypeid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject reasonUpdate(@PathVariable("cardtypeid") int cardtypeid, @RequestBody Cardtype cardtype) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Cardtype cardtypeR = masterService.findCardtypeByID(cardtypeid);
			if (cardtypeR != null) {
				cardtypeR.setCardtypecode(cardtype.getCardtypecode());
				cardtypeR.setCardtypedescEn(cardtype.getCardtypedescEn());
				cardtypeR.setCardtypedescTh(cardtype.getCardtypedescTh());
				
				boolean result = masterService.updateCardtypeEnttiy(cardtypeR);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, cardtype , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Card type
	//Start Label
	@RequestMapping(value = "/label/{labelid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject labelfindByID(@PathVariable("labelid")int labelid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Label label = masterService.findLabelByID(labelid);
			if (label != null && label.getLabelid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, label , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, label , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/label", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject labelfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("label filter : " + filter);
		try {
			filter = (filter != null ? filter : "");
			List<Label> lsLabel = masterService.findLabelByCond(filter);
			if (lsLabel != null && lsLabel.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsLabel , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsLabel , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/label", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject labelAdd(@RequestBody Label label) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Label labelR = masterService.saveLabelEnttiy(label);
			if (labelR != null && labelR.getLabelid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, labelR , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, labelR , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/label/{labelid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject labelUpdate(@PathVariable("labelid") int labelid, @RequestBody Label label) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Label labelR = masterService.findLabelByID(labelid);
			if (labelR != null) {
				labelR.setLabelcode(label.getLabelcode());
				labelR.setLabeldescEn(label.getLabeldescEn());
				labelR.setLabeldescTh(label.getLabeldescTh());
				labelR.setTypes(label.getTypes());
				labelR.setLovs(label.getLovs());
				
				boolean result = masterService.updateLabelEnttiy(labelR);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, label , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Label
	//Start Param
	@RequestMapping(value = "/param/{paramid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject paramfindByID(@PathVariable("paramid")int paramid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Param param = masterService.findParamByID(paramid);
			if (param != null && param.getParamid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, param , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, param , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/param", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject paramfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("label filter : " + filter);
		try {
			filter = (filter != null ? filter : "");
			List<Param> lsParam = masterService.findParamByCond(filter);
			if (lsParam != null && lsParam.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsParam , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsParam , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/param", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject paramAdd(@RequestBody Param param) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Param paramR = masterService.saveParamEnttiy(param);
			if (paramR != null && paramR.getParamid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, paramR , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, paramR , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/param/{paramid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject paramUpdate(@PathVariable("paramid") int paramid, @RequestBody Param param) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Param paramR = masterService.findParamByID(paramid);
			if (paramR != null) {
				paramR.setParamcode(param.getParamcode());
				paramR.setParamname(param.getParamname());
				paramR.setParamvalue(param.getParamvalue());
				
				boolean result = masterService.updateParamEnttiy(paramR);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, param , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Param
	//Start Partner
	@RequestMapping(value = "/partner/{partnerid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject partnerfindByID(@PathVariable("partnerid")int partnerid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Partner partner = masterService.findPartnerByID(partnerid);
			if (partner != null && partner.getPartnerid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, partner , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, partner , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/partner", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject partnerfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("partner filter : " + filter);
		try {
			filter = (filter != null ? filter : "");
			List<Partner> lsPartner = masterService.findPartnerByCond(filter);
			if (lsPartner != null && lsPartner.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsPartner , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsPartner , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/partner", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject partnerAdd(@RequestBody Partner partner) {
		ResponseControl RespCon = new ResponseControl();
		try {
			if (partner.getCreateDate() == null) {
				partner.setCreateDate(DateControl.toDaytoTimeStamp());
			}
			Partner partnerR = masterService.savePartnerEnttiy(partner);
			if (partnerR != null && partnerR.getPartnerid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, partnerR , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, partnerR , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/partner/{partnerid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject partnerUpdate(@PathVariable("partnerid") int partnerid, @RequestBody Partner partner) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Partner partnerR = masterService.findPartnerByID(partnerid);
			if (partnerR != null) {
				partnerR.setPartnerNameEn(partner.getPartnerNameEn());
				partnerR.setPartnerNameTh(partner.getPartnerNameTh());
				
				boolean result = masterService.updatePartnerEnttiy(partnerR);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, partner , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Partner
	//Start Product
	@RequestMapping(value = "/product/{productid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject productfindByID(@PathVariable("productid")int productid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Product product = masterService.findProductByID(productid);
			if (product != null && product.getProductid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, product , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, product , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/product", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject productfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("product filter : " + filter);
		try {
			filter = (filter != null ? filter : "");
			List<Product> lsProduct = masterService.findProductByCond(filter);
			if (lsProduct != null && lsProduct.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsProduct , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsProduct , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/product", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject productAdd(@RequestBody Product product) {
		ResponseControl RespCon = new ResponseControl();
		try {
			if (product.getCreateDate() == null) {
				product.setCreateDate(DateControl.toDaytoTimeStamp());
			}
			Product productR = masterService.saveProductEnttiy(product);
			if (productR != null && productR.getProductid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, productR , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, productR , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/product/{productid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject productUpdate(@PathVariable("productid") int productid, @RequestBody Product product) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Product productR = masterService.findProductByID(productid);
			if (productR != null) {
				productR.setProductNameEn(product.getProductNameEn());
				productR.setProductNameTh(product.getProductNameTh());
				
				boolean result = masterService.updateProductEnttiy(productR);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, product , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Product
	//Start Menu
	@RequestMapping(value = "/menu/{menuid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject menufindByID(@PathVariable("menuid")int menuid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Menu menu = masterService.findMenuByID(menuid);
			if (menu != null && menu.getMenuid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, menu , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, menu , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/menu", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject menufindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("menu filter : " + filter);
		try {
			filter = (filter != null ? filter : "");
			List<Menu> lsMenu = masterService.findMenuByCond(filter);
			if (lsMenu != null && lsMenu.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsMenu , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsMenu , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/menu", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject menuAdd(@RequestBody Menu menu) {
		ResponseControl RespCon = new ResponseControl();
		try {
			if (menu.getCreateDate() == null) {
				menu.setCreateDate(DateControl.toDaytoTimeStamp());
			}
			Menu menuR = masterService.saveMenuEnttiy(menu);
			if (menuR != null && menuR.getMenuid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, menuR , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, menuR , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/menu/{menuid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject menuUpdate(@PathVariable("menuid") int menuid, @RequestBody Menu menu) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Menu menuR = masterService.findMenuByID(menuid);
			if (menuR != null) {
				menuR.setMenuNameEn(menu.getMenuNameEn());
				menuR.setMenuNameTh(menu.getMenuNameTh());
				
				boolean result = masterService.updateMenuEnttiy(menuR);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, menu , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Menu
	//Start Role
	@RequestMapping(value = "/role/{roleid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject rolefindByID(@PathVariable("roleid")int roleid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Role role = masterService.findRoleByID(roleid);
			if (role != null && role.getRoleid() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, role , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, role , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/role", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject rolefindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("role filter : " + filter);
		try {
			filter = (filter != null ? filter : "");
			List<Role> lsRole = masterService.findRoleByCond(filter);
			if (lsRole != null && lsRole.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsRole , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsRole , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/roleuser", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject roleuserfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("rolemenu filter : " + filter);
		try {
			filter = (filter != null ? filter : "");
			ArrayList<Role> lsRole = masterService.findRoleUserByCond(filter);
			if (lsRole != null && lsRole.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsRole , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsRole , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/role", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject roleAdd(@RequestBody Role role) {
		ResponseControl RespCon = new ResponseControl();
		try {
			if (role.getCreateDate() == null) {
				role.setCreateDate(DateControl.toDaytoTimeStamp());
			}
			Role roleR = masterService.saveRoleEnttiy(role);
			if (roleR != null && roleR.getRoleid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, roleR , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, roleR , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/role/{roleid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject roleUpdate(@PathVariable("roleid") int roleid, @RequestBody Role role) {
		ResponseControl RespCon = new ResponseControl();
		try {
			Role roleR = masterService.findRoleByID(roleid);
			if (roleR != null) {
				roleR.setRoleNameEn(role.getRoleNameEn());
				roleR.setRoleNameTh(role.getRoleNameTh());
				roleR.setRolecode(role.getRolecode());
				boolean result = masterService.updateRoleEnttiy(roleR);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, role , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Role
	//Start Access menu
	@RequestMapping(value = "/accessmenu/{accessid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject accessmenufindByID(@PathVariable("accessid")int accessid) {
		ResponseControl RespCon = new ResponseControl();
		try {
			AccessMenu accessmenu = masterService.findAccessMenuByID(accessid);
			if (accessmenu != null && accessmenu.getAccessid() > 0) {
				Menu menu = masterService.findMenuByID(accessmenu.getMenuid());
				accessmenu.setMenu(menu);
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, accessmenu , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, accessmenu , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/accessuser", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject accessuserfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("accessmenu filter : " + filter);
		try {
			filter = (filter != null ? filter : "");
			ArrayList<AccessMenu> lsAccessMenu = masterService.findAccessUserByCond(filter);
			if (lsAccessMenu != null && lsAccessMenu.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsAccessMenu , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsAccessMenu , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/accessmenu", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject accessmenufindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("accessmenu filter : " + filter);
		try {
			filter = (filter != null ? filter : "");
			ArrayList<AccessMenu> lsAccessMenu = masterService.findAccessMenuByCond(filter);
			if (lsAccessMenu != null && lsAccessMenu.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsAccessMenu , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsAccessMenu , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/accessmenu", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject accessmenuAdd(@RequestBody AccessMenu accessmenu) {
		ResponseControl RespCon = new ResponseControl();
		try {
			if (accessmenu.getCreateDate() == null) {
				accessmenu.setCreateDate(DateControl.toDaytoTimeStamp());
			}
			AccessMenu accessmenuR = masterService.saveAccessMenuEnttiy(accessmenu);
			if (accessmenuR != null && accessmenuR.getAccessid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, accessmenuR , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, accessmenuR , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/accessmenu/{accessid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject accessmenuUpdate(@PathVariable("accessid") int accessid, @RequestBody AccessMenu accessmenu) {
		ResponseControl RespCon = new ResponseControl();
		try {
			AccessMenu accessmenuR = masterService.findAccessMenuByID(accessid);
			if (accessmenuR != null) {
				accessmenuR.setMenuid(accessmenu.getMenuid());
				accessmenuR.setRAccess(accessmenu.getRAccess());
				accessmenuR.setRCreate(accessmenu.getRCreate());
				accessmenuR.setRCopy(accessmenu.getRCopy());
				accessmenuR.setRView(accessmenu.getRView());
				accessmenuR.setRList(accessmenu.getRList());
				accessmenuR.setRImport(accessmenu.getRImport());
				accessmenuR.setRExport(accessmenu.getRExport());
				accessmenuR.setRAssign(accessmenu.getRAssign());
				accessmenuR.setRReject(accessmenu.getRReject());
				accessmenuR.setREdit(accessmenu.getREdit());
				accessmenuR.setRDelete(accessmenu.getRDelete());
				accessmenuR.setActive(accessmenu.getActive());
				boolean result = masterService.updateAccessMenuEnttiy(accessmenuR);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, accessmenu , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	//End Access menu
	//Start Full menu
	@RequestMapping(value = "/fulluser/{rmid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject fulluserfindByID(@PathVariable("rmid")int rmid) {
		ResponseControl RespCon = new ResponseControl();

		try {
			FullUser fulluser = masterService.findFullUserByID(rmid);
			if (fulluser != null && fulluser.getRefmaster().getRmid() > 0) {
				
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, fulluser , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, fulluser , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
		
	}
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject userfindByID(@PathVariable("userid")int userid) {
		ResponseControl RespCon = new ResponseControl();

		try {
			User user = masterService.findUserByID(userid);
			if (user != null && user.getUserid() > 0) {
				
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, user , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, user , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
		
	}
	@RequestMapping(value = "/user", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject userfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("user filter : " + filter);
		try {
			filter = (filter != null ? filter : "");
			List<User> lsUser = masterService.findUserEnttiyByCond(filter);
			if (lsUser != null && lsUser.size() > 0) {
				
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsUser , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsUser , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/user/{userid}/{modifyuserid}", method = RequestMethod.DELETE ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject userRemove(@PathVariable("userid")int userid, @PathVariable("modifyuserid")int modifyuserid) {
		ResponseControl RespCon = new ResponseControl();
		UsersHi userhi = new UsersHi();
		boolean isLead = false,isDeleteRefMaster = false;
		User user = null;
		try {
		
			String jsonRefMaster = "{\"userid\":[\"=\","+userid+"]}";
			List<RefMaster> lsRefMaster = masterService.findRefMasterByCond(jsonRefMaster);
			if (lsRefMaster != null && lsRefMaster.size() > 0) {
				for (RefMaster refM : lsRefMaster) {
					FullUser fulluser = masterService.findFullUserByID(refM.getRmid());
					
					if (fulluser != null && fulluser.getRefmaster().getRmid() > 0) {
						String jsonStr = "{\"assigneduserid\":[\"=\"," + fulluser.getUser().getUserid()+"]}";
						int cntLead = paService.countFindOutboundByCond2(jsonStr);
						if (cntLead > 0) {
							isLead = true;
						}
					}
				}
				if (isLead) {
					return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, "เนื่องจากมี Outbound ค้างอยู่ กรุณา reassign ออกก่อนลบ role นี้ " , Constants.Response.LOG_ERROR_MSG );
				} else {
					for (RefMaster refM : lsRefMaster) {
						FullUser fulluser = masterService.findFullUserByID(refM.getRmid());
						if (fulluser != null && fulluser.getRefmaster().getRmid() > 0) {
							String json = JsonUtils.genJsonString(fulluser);
							userhi = masterService.saveUserHistoryEnttiy("DELETE", json, userid,fulluser.getRefmaster().getRmid());
							if (userhi != null && userhi.getUserhisid() > 0) {
								isDeleteRefMaster = masterService.removeFullUserEnttiy(fulluser.getRefmaster(), userid);
								
							} else {
								return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, "ไม่สามารถ บันทึก history ได้" , Constants.Response.LOG_ERROR_MSG );
							}
						} else {
							return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, "หาข้อมูลไม่พบ" , Constants.Response.LOG_ERROR_MSG );
						}
					}
					if (isDeleteRefMaster) {
						
						boolean isDeleteUser = masterService.removeUserByID(userid);
						if (isDeleteUser) {
							return RespCon.resObj(Constants.Response.DELETE_SUCCESS_STATUS, "ลบข้อมูล user เรียบร้อยแล้ว" , Constants.Response.DELETE_SUCCESS_MSG);
						} else {
							return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, "ไม่สามารถลบข้อมูล User ได้" , Constants.Response.LOG_ERROR_MSG );
						}
					} else {
						return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, "ไม่สามารถลบข้อมูล ref_master ของ User ได้" , Constants.Response.LOG_ERROR_MSG );
					}
				}
			} else {
				//find user
				user = masterService.findUserByID(userid);
				String jsonUser = JsonUtils.genJsonString(user);
				UsersHi userU = masterService.saveUserHistoryEnttiy("DELETE", jsonUser, modifyuserid, 0);
				if (userU != null && userU.getUserhisid() > 0) {
					boolean isDeleteUser = masterService.removeUserByID(userid);
					if (isDeleteUser) {
						return RespCon.resObj(Constants.Response.DELETE_SUCCESS_STATUS, "ลบข้อมูล user เรียบร้อยแล้ว" , Constants.Response.DELETE_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, "ไม่สามารถ Delete ได้" , Constants.Response.LOG_ERROR_MSG );
					}
				} else {
					return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, "หาข้อมูลไม่พบ" , Constants.Response.LOG_ERROR_MSG );
				}
			}
			
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/fulluser", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject fulluserfindByCode(@RequestParam(required = false) String filter) {
		ResponseControl RespCon = new ResponseControl();
		System.out.println("fulluser filter : " + filter);
		try {
			filter = (filter != null ? filter : "");
			List<FullUser> lsFullUser = masterService.findFullUserByCond(filter);
			if (lsFullUser != null && lsFullUser.size() > 0) {
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsFullUser , Constants.Response.GET_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsFullUser , Constants.Response.GET_NOTFOUND_MSG);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/fulluser", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject fulluseruAdd(@RequestBody FullUser fulluser) {
		ResponseControl RespCon = new ResponseControl();
		try {
			if (fulluser.getUser().getCreateDate() == null) {
				fulluser.getUser().setCreateDate(DateControl.toDaytoTimeStamp());
			}
			
			FullUser fulluserR = masterService.saveFullUserEnttiy(fulluser);
			if (fulluserR != null && fulluserR.getRefmaster().getRmid() > 0) {
				return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, fulluserR , Constants.Response.POST_SUCCESS_MSG);
			} else {
				return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, fulluserR , Constants.Response.POST_ALREADY_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/fulluser/{rmid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject fulluserUpdate(@PathVariable("rmid") int rmid, @RequestBody FullUser fulluser) {
		ResponseControl RespCon = new ResponseControl();
		try {
			FullUser fulluserR = masterService.findFullUserByID(rmid);
			if (fulluserR != null) {
				String json = JsonUtils.genJsonString(fulluserR);
				UsersHi userH = masterService.saveUserHistoryEnttiy("UPDATE", json, fulluser.getUser().getCreateUserid(),rmid);
				fulluserR.getUser().setLogonid(fulluser.getUser().getLogonid());
				fulluserR.getUser().setLogonad(fulluser.getUser().getLogonad());
				fulluserR.getUser().setFname(fulluser.getUser().getFname());
				fulluserR.getUser().setLname(fulluser.getUser().getLname());
				fulluserR.getUser().setLicenseno(fulluser.getUser().getLicenseno());
				fulluserR.getUser().setLicenseSDate(fulluser.getUser().getLicenseSDate());
				fulluserR.getUser().setLicenseEDate(fulluser.getUser().getLicenseEDate());
				fulluserR.getUser().setTypes(fulluser.getUser().getTypes());
				fulluserR.getUser().setDetail(fulluser.getUser().getDetail());
				fulluserR.getUser().setCreateDate(fulluser.getUser().getCreateDate());
				fulluserR.getUser().setCreateUserid(fulluser.getUser().getCreateUserid());
				fulluserR.getUser().setActive(fulluser.getUser().getActive());
				fulluserR.getRefmaster().getPartner().setPartnerid(fulluser.getPartner().getPartnerid());
				fulluserR.getRefmaster().getProduct().setProductid(fulluser.getProduct().getProductid());
				fulluserR.getRefmaster().getRole().setRoleid(fulluser.getRole().getRoleid());
				fulluserR.setAccessmenu(fulluser.getAccessmenu().clone());
				
				boolean result = masterService.updateFullUserEnttiy(fulluserR);
				if (result) {
					return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
				}
			} else {
				return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, fulluser , Constants.Response.PUT_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
	}
	@RequestMapping(value = "/fulluser/{rmid}/{userid}", method = RequestMethod.DELETE ,produces = "application/JSON;charset=UTF-8")
	public ResponseObject fulluserRemove(@PathVariable("rmid")int rmid,@PathVariable("userid")int userid) {
		ResponseControl RespCon = new ResponseControl();
		UsersHi userhi = new UsersHi();
		try {
			FullUser fulluser = masterService.findFullUserByID(rmid);
			
			if (fulluser != null && fulluser.getRefmaster().getRmid() > 0) {
				String jsonStr = "{\"assigneduserid\":[\"=\"," + fulluser.getUser().getUserid()+"]}";
				int cntLead = paService.countFindOutboundByCond2(jsonStr);
				if (cntLead == 0) {
					String json = JsonUtils.genJsonString(fulluser);
					userhi = masterService.saveUserHistoryEnttiy("DELETE", json, userid,fulluser.getRefmaster().getRmid());
					if (userhi != null && userhi.getUserhisid() > 0) {
						masterService.removeFullUserEnttiy(fulluser.getRefmaster(), userid);
						return RespCon.resObj(Constants.Response.DELETE_SUCCESS_STATUS, "" , Constants.Response.DELETE_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, "" , Constants.Response.LOG_ERROR_MSG );
					}
				} else {
					return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, "เนื่องจากมี Outbound ค้างอยู่ กรุณา reassign ออกก่อนลบ role นี้ " , Constants.Response.LOG_ERROR_MSG );
				}
				
			} else {
				return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, "" , Constants.Response.DELETE_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
		}
		
	}
	//End Full user
	//Start Template role menu
		@RequestMapping(value = "/tmprolemenu/{tmprolemenuid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject tmprolemenufindByID(@PathVariable("tmprolemenuid")int tmprolemenuid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				TmpRoleMenu tmpRoleMenu = masterService.findTmpRoleMenuByID(tmprolemenuid);
				if (tmpRoleMenu != null && tmpRoleMenu.getTrmid() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, tmpRoleMenu , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, tmpRoleMenu , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/tmprolemenu", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject tmprolemenufindByCode(@RequestParam(required = false) String filter) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("tmprolemenu filter : " + filter);
			try {
				List<TmpRoleMenu> lsTmpRoleMenu = masterService.findTmpRoleMenuByCond(filter);
				if (lsTmpRoleMenu != null && lsTmpRoleMenu.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsTmpRoleMenu , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsTmpRoleMenu , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/tmprolemenu", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject tmprolemenuAdd(@RequestBody TmpRoleMenu tmprolemenu) {
			ResponseControl RespCon = new ResponseControl();
			try {				
				if (tmprolemenu.getCreateDate() == null) {
					tmprolemenu.setCreateDate(DateControl.toDaytoTimeStamp());
				}
				TmpRoleMenu tmprolemenus = masterService.saveTmpRoleMenuEnttiy(tmprolemenu);
				if (tmprolemenus != null && tmprolemenus.getTrmid() > 0) {
					return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, tmprolemenus , Constants.Response.POST_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, tmprolemenu , Constants.Response.POST_ALREADY_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/tmprolemenu/{tmprolemenuid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject tmprolemenuUpdate(@PathVariable("tmprolemenuid") int tmprolemenuid, @RequestBody TmpRoleMenu tmprolemenu) {
			ResponseControl RespCon = new ResponseControl();
			try {
				TmpRoleMenu tmprolemenus = masterService.findTmpRoleMenuByID(tmprolemenuid);
				if (tmprolemenus != null) {
					Role role = masterService.findRoleByID(tmprolemenu.getRole().getRoleid());
					Menu menu = masterService.findMenuByID(tmprolemenu.getMenu().getMenuid());
					tmprolemenus.setRole(role);
					tmprolemenus.setMenu(menu);
					tmprolemenus.setRAccess(tmprolemenu.getRAccess());
					tmprolemenus.setRCreate(tmprolemenu.getRCreate());
					tmprolemenus.setRCopy(tmprolemenu.getRCopy());
					tmprolemenus.setRView(tmprolemenu.getRView());
					tmprolemenus.setRList(tmprolemenu.getRList());
					tmprolemenus.setRImport(tmprolemenu.getRImport());
					tmprolemenus.setRExport(tmprolemenu.getRExport());
					tmprolemenus.setRAssign(tmprolemenu.getRAssign());
					tmprolemenus.setRReject(tmprolemenu.getRReject());
					tmprolemenus.setREdit(tmprolemenu.getREdit());
					tmprolemenus.setRDelete(tmprolemenu.getRDelete());
					tmprolemenus.setActive(tmprolemenu.getActive());
					
					boolean result = masterService.updateTmpRoleMenuEnttiy(tmprolemenus);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, tmprolemenu , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
			
		}
		@RequestMapping(value = "/tmprolemenu/{tmprolemenuid}", method = RequestMethod.DELETE ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject tmprolemenuUpdate(@PathVariable("tmprolemenuid") int tmprolemenuid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				boolean result = masterService.deleteTmpRoleMenuEnttiy(tmprolemenuid);
				if (result) {
					return RespCon.resObj(Constants.Response.DELETE_SUCCESS_STATUS, "" , Constants.Response.DELETE_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.DELETE_NOTFOUND_STATUS, "" , Constants.Response.DELETE_NOTFOUND_MSG);
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		//End Template role menu
		//Start Group menu
		@RequestMapping(value = "/groupmenu/{grpmenuid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject groupmenufindByID(@PathVariable("grpmenuid")int grpmenuid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Groupmenu groupmenu = masterService.findGroupmenuByID(grpmenuid);
				if (groupmenu != null && groupmenu.getGrpmenuid() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, groupmenu , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, groupmenu , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/groupmenu", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject groupmenufindByCode(@RequestParam(required = false) String filter) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("groupmenu filter : " + filter);
			try {
			
				List<Groupmenu> lsGroupmenu = masterService.findGroupmenuByCond(filter);
				if (lsGroupmenu != null && lsGroupmenu.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsGroupmenu , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsGroupmenu , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/groupmenu", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject groupmenuAdd(@RequestBody Groupmenu groupmenu) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Groupmenu groupmenus = masterService.saveGroupmenuEnttiy(groupmenu);
				if (groupmenus != null && groupmenus.getGrpmenuid() > 0) {
					return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, groupmenu , Constants.Response.POST_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, groupmenu , Constants.Response.POST_ALREADY_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/groupmenu/{grpmenuid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject groupmenuUpdate(@PathVariable("grpmenuid") int grpmenuid, @RequestBody Groupmenu groupmenu) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Groupmenu groupmenus = masterService.findGroupmenuByID(grpmenuid);
				if (groupmenus != null) {
					groupmenus.setGrpmenuNameEn(groupmenu.getGrpmenuNameEn());
					groupmenus.setGrpmenuNameTh(groupmenu.getGrpmenuNameTh());
					boolean result = masterService.updateGroupmenuEnttiy(groupmenus);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, groupmenu , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
			
		}
		//End Group menu
		//Start title
		@RequestMapping(value = "/title/{titleid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject titlefindByID(@PathVariable("titleid")int titleid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Title title = masterService.findTitleByID(titleid);
				if (title != null && title.getTitleid() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, title , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, title , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/title", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject titlefindByCode(@RequestParam(required = false) String filter) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("Title filter : " + filter);
			try {
				List<Title> lsTitle = masterService.findTitleByCond(filter);
				if (lsTitle != null && lsTitle.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsTitle , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsTitle , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/title", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject titleAdd(@RequestBody Title title) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Title titles = masterService.saveTitleEnttiy(title);
				if (title != null && title.getTitleid() > 0) {
					return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, title , Constants.Response.POST_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, title , Constants.Response.POST_ALREADY_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/title/{titleid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject titleUpdate(@PathVariable("titleid") int titleid, @RequestBody Title title) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Title titles = masterService.findTitleByID(titleid);
				if (titles != null) {
					titles.setTitlecode(title.getTitlecode());
					titles.setTitleen(title.getTitleen());
					titles.setTitleth(title.getTitleth());
					boolean result = masterService.updateTitleEnttiy(titles);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, title , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
			
		}	
		//End title
		//Start gender
		@RequestMapping(value = "/gender/{genderid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject genderfindByID(@PathVariable("genderid")int genderid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Gender gender = masterService.findGenderByID(genderid);
				if (gender != null && gender.getGenderid() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, gender , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, gender , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/gender", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject genderfindByCode(@RequestParam(required = false) String filter) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("gender filter : " + filter);
			try {
				List<Gender> lsGender = masterService.findGenderByCond(filter);
				if (lsGender != null && lsGender.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsGender , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsGender , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/gender", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject genderAdd(@RequestBody Gender gender) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Gender genders = masterService.saveGenderEnttiy(gender);
				if (gender != null && gender.getGenderid() > 0) {
					return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, gender , Constants.Response.POST_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, gender , Constants.Response.POST_ALREADY_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/gender/{genderid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject genderUpdate(@PathVariable("genderid") int genderid, @RequestBody Gender gender) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Gender genders = masterService.findGenderByID(genderid);
				if (genders != null) {
					genders.setGendercode(gender.getGendercode());
					genders.setGendernameth(gender.getGendernameth());
					genders.setGendernameen(gender.getGendernameen());
					
					boolean result = masterService.updateGenderEnttiy(genders);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, gender , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
			
		}	
		//end gender
		//Start Province
		@RequestMapping(value = "/province/{pid}", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject provinceindByID(@PathVariable("paramid")int pid) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Province entity = masterService.findProvinceByID(pid);
				if (entity != null && entity.getPid() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, entity , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, entity , Constants.Response.GET_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/province", method = RequestMethod.GET ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject provincefindByCode(@RequestParam(required = false) String filter) {
			ResponseControl RespCon = new ResponseControl();
			System.out.println("province filter : " + filter);
			try {
				filter = (filter != null ? filter : "");
				List<Province> lsEntity = masterService.findProvinceByCond(filter);
				if (lsEntity != null && lsEntity.size() > 0) {
					return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, lsEntity , Constants.Response.GET_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, lsEntity , Constants.Response.GET_NOTFOUND_MSG);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/province", method = RequestMethod.POST ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject provinceAdd(@RequestBody Province entity) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Province province = masterService.saveProvinceEnttiy(entity);
				if (province != null && province.getPid() > 0) {
					return RespCon.resObj(Constants.Response.POST_SUCCESS_STATUS, province , Constants.Response.POST_SUCCESS_MSG);
				} else {
					return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, province , Constants.Response.POST_ALREADY_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		@RequestMapping(value = "/province/{pid}", method = RequestMethod.PUT ,produces = "application/JSON;charset=UTF-8")
		public ResponseObject provinceUpdate(@PathVariable("pid") int pid, @RequestBody Province entity) {
			ResponseControl RespCon = new ResponseControl();
			try {
				Province province = masterService.findProvinceByID(pid);
				if (province != null) {
					province.setProvincecode(entity.getProvincecode());
					province.setProvinceTh(entity.getProvinceTh());
					province.setProvinceEn(entity.getProvinceEn());
					
					boolean result = masterService.updateProvinceEnttiy(province);
					if (result) {
						return RespCon.resObj(Constants.Response.PUT_SUCCESS_STATUS, "" , Constants.Response.PUT_SUCCESS_MSG);
					} else {
						return RespCon.resObj(Constants.Response.POST_ALREADY_STATUS, "" , Constants.Response.POST_ALREADY_MSG);
					}
				} else {
					return RespCon.resObj(Constants.Response.PUT_NOTFOUND_STATUS, entity , Constants.Response.PUT_NOTFOUND_MSG);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return RespCon.resObj(Constants.Response.ERROR_STATUS, null , Constants.Response.ERROR_MSG);
			}
		}
		//End province
}
