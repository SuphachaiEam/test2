package th.priisoft.crm.spring.resource;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import th.priisoft.crm.common.constant.Constants;
import th.priisoft.crm.common.restfull.ResponseControl;
import th.priisoft.crm.common.restfull.ResponseObject;
import th.priisoft.crm.common.utils.AesUtil;
import th.priisoft.crm.common.utils.EncryptUtil;
import th.priisoft.crm.common.utils.JsonUtils;
import th.priisoft.crm.spring.entity.prii.crmdta.FullUser;
import th.priisoft.crm.spring.entity.prii.crmdta.Partner;
import th.priisoft.crm.spring.entity.prii.crmdta.Product;
import th.priisoft.crm.spring.entity.prii.crmdta.RefMaster;
import th.priisoft.crm.spring.entity.prii.crmdta.User;
import th.priisoft.crm.spring.entity.prii.padta.Client;
import th.priisoft.crm.spring.entity.prii.padta.Outbound;
import th.priisoft.crm.spring.resource.constants.CommonRest;
import th.priisoft.crm.spring.service.common.CommonService;
import th.priisoft.crm.spring.service.common.MasterService;
import th.priisoft.crm.spring.service.common.PAService;
@RestController
@RequestMapping(value = "/")
public class AuthServiceResource {
	
	Logger logger = Logger.getLogger(AuthServiceResource.class);
	
	@Autowired
	private CommonService commonService;
	@Autowired
	private MasterService masterService;
	@Autowired
	private PAService paService;
	
	public static HashMap<String, String> session_controle = new HashMap<String,String>();
	
	@RequestMapping(value = CommonRest.LoginService.URL, method = { RequestMethod.GET, RequestMethod.POST } ,produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject LoginService(@RequestParam(value = "username",required=false) String username,@RequestParam(value = "password",required=false) String password,@RequestParam(value = "partnerid",required=false,defaultValue="0") int partnerid,HttpServletRequest httpRequest) {
		ResponseControl RespCon = new ResponseControl();
		HashMap<String , Object> data = new HashMap<String,Object>();
		try {
			System.out.println("username : "+username);
			System.out.println("password : "+password);
			System.out.println("partnerid : "+partnerid);
			
			if(httpRequest.getSession()!= null && httpRequest.getSession().getAttribute("tstt")!=null) {
			System.out.println("nosession");
			}else {
				httpRequest.getSession(true).setAttribute("tstt", "tst");
				System.out.println("haxesession");
			}
			boolean adflage = false; // fix wait ad
			if("password".equals(password)) {
				adflage = true;
			}
			if(adflage) {
				if(httpRequest.getSession() == null) {
				  httpRequest.getSession(true);
				}
				
				String cond = "{\"LOGONAD\":[\"=\",\"" + username + "\"]}";
				ArrayList<User> userlist = masterService.findUserEnttiyByCond(cond);
				if(userlist!=null&&userlist.size()>0) {
					
					
					User user = userlist.get(0);
					Partner partner =  null;
					List<Product> product = null;
					HashMap<Integer, Product> mapp = new HashMap<Integer , Product>();
					
					if(partnerid>0) {
						partner = masterService.findPartnerByID(partnerid);
					}
					
					
					String condref = "{\"userid\":[\"=\",\"" + user.getUserid() + "\"],\"PARTNERID\":[\"=\",\"" + partnerid + "\"]}";
					List<RefMaster> ref =  masterService.findRefMasterByCond(condref);
					if(ref!=null&&ref.size()>0) {
						for(RefMaster r : ref) {
							r.getProduct();
							mapp.put(r.getProduct().getProductid(), r.getProduct());
						}
					}	
					
					for (Map.Entry<Integer, Product> entry : mapp.entrySet()) {
						if(product==null)
							 product = new ArrayList<Product>();
						product.add(entry.getValue());
				    }
					
					data.put("user", user);
					data.put("partner", partner);
					data.put("product", product);	
					session_controle.put(username, httpRequest.getSession().getId());
					httpRequest.getSession().setAttribute("username",username);
					return RespCon.resObj(CommonRest.LoginService.STATUS_LOGIN_SUCCESS, data , CommonRest.LoginService.MESG_LOGIN_SUCCESS);
					
				}else {
					return RespCon.resObj(CommonRest.LoginService.STATUS_LOGIN_ERROR, data , CommonRest.LoginService.MESG_LOGIN_ERROR);
				}
			}else {
					return RespCon.resObj(CommonRest.LoginService.STATUS_LOGIN_ERROR, data , CommonRest.LoginService.MESG_LOGIN_ERROR);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(CommonRest.STATUS_INTERNAL_ERROR, data , CommonRest.MESG_INTERNAL_ERROR );
		}
		
	}
	
	@RequestMapping(value = CommonRest.ByPassGenesysService.URL, method = { RequestMethod.GET, RequestMethod.POST } ,produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject byPassGenesysService(@RequestParam(value = "product",defaultValue="",required=false) String product,@RequestParam(value = "encrypt",defaultValue="",required=false) String encryptStr,HttpServletRequest httpRequest) {
		ResponseControl RespCon = new ResponseControl();
		HashMap<String , Object> data = new HashMap<String,Object>();
		Outbound obtarget = null;
		ArrayList<FullUser> fulluserR = new ArrayList<FullUser>();
		String logonAd = "";
		String callId = "";
		int obTagetId = 0;
		
		try {
			
			System.out.println("encryptStr : "+encryptStr);
			encryptStr = URLDecoder.decode(encryptStr, "UTF-8").replace(" ", "+");
			System.out.println("encryptStr : "+encryptStr);
			
			String decrypttest = EncryptUtil.getInstance().decryptGn(encryptStr, Constants.Genesys.SECRET_PBP_KEY);
			
			if(decrypttest!=null && decrypttest.trim().length()>0) {
				Map<String, String> param = splitQuery(new URL("http://tmp.com?"+decrypttest));
				logonAd =  param.get(Constants.Genesys.NAME_PARAM_LOGONAD)==null ? "" : param.get(Constants.Genesys.NAME_PARAM_LOGONAD);
				callId = param.get(Constants.Genesys.NAME_PARAM_CALLID)==null ? "" : param.get(Constants.Genesys.NAME_PARAM_CALLID);
				obTagetId = param.get(Constants.Genesys.NAME_PARAM_OUTBOUND_ID)==null ? 0 : Integer.parseInt(param.get(Constants.Genesys.NAME_PARAM_OUTBOUND_ID));
			}
			
			if( logonAd.trim().length()>0 && 
				callId.trim().length()>0  &&
				obTagetId>0 
			) {
				List<FullUser> fList =  masterService.findFullUserByCond("{\"LOGONAD\":[\"=\",\""+logonAd+"\"]}");
				if(fList != null && fList.size()>0) {
					for(FullUser fr :fList) {
						if(fr.getProduct().getProductNameEn().equalsIgnoreCase(product)) {
							fulluserR.add(fr);
						}
					}
				}
				
				obtarget = paService.findOutboundByID(obTagetId);
			}
			
			if(fulluserR != null && fulluserR.size()>0 && obtarget!=null) {
				
				session_controle.put(logonAd, httpRequest.getSession().getId());
				httpRequest.getSession().setAttribute("username", logonAd);
				
				data.put("fullUser", fulluserR);
				data.put("outbound", obtarget);
				data.put("callid", callId);
				return RespCon.resObj(Constants.Response.GET_SUCCESS_STATUS, data , Constants.Response.GET_SUCCESS_MSG);
			}else {
				return RespCon.resObj(Constants.Response.GET_NOTFOUND_STATUS, "{\"logonAd\":"+"\""+logonAd+"\","+"\"obTagetId\":"+"\""+obTagetId+"\","+"\"callId\":"+"\""+callId+"\""+"}" , Constants.Response.GET_NOTFOUND_MSG);
			}
		} catch (Exception e) {
			e.printStackTrace();				
			return RespCon.resObj(Constants.Response.ERROR_STATUS, data , Constants.Response.ERROR_MSG );
		}
	}
	
	public static Map<String, String> splitQuery(URL url) throws UnsupportedEncodingException {
	    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
	    String query = url.getQuery();
	    String[] pairs = query.split("&");
	    for (String pair : pairs) {
	        int idx = pair.indexOf("=");
	        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
	    }
	    return query_pairs;
	}
	
	@RequestMapping(value = CommonRest.LogoutService.URL, method = { RequestMethod.GET, RequestMethod.POST } ,produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject logoutServlet(HttpServletRequest httpRequest) {
		ResponseControl RespCon = new ResponseControl();
		HashMap<String , Object> data = new HashMap<String,Object>();
		try {
			if(httpRequest.getSession() == null) {
				  httpRequest.getSession(true);
				}
			if(httpRequest.getSession()!= null && httpRequest.getSession().getAttribute("username")!=null) {
				String username = (String) httpRequest.getSession().getAttribute("username");

				if(session_controle.get("username") != null && session_controle.get("username").equals(httpRequest.getSession(true).getId())) {
					session_controle.remove("username");
					httpRequest.getSession().invalidate();
				}	
						
			}
		} catch (Exception e) {
			e.printStackTrace();
			return RespCon.resObj(CommonRest.STATUS_INTERNAL_ERROR, data , CommonRest.MESG_INTERNAL_ERROR );
		}
		return RespCon.resObj(CommonRest.LogoutService.STATUS_LOGOUT_SUCCESS, data , CommonRest.LogoutService.MESG_LOGOUT_SUCCESS);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET ,produces = "text/plain;charset=UTF-8")
	public String usersRest(HttpServletRequest httpRequest) {
		String result = "";
		try {
			if(httpRequest.getSession()!= null && httpRequest.getSession().getAttribute("username")!=null) {
				result = (String) httpRequest.getSession().getAttribute("username");
			}
			
			result = "username = "+result + " | ssid = " + httpRequest.getSession(true).getId();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "sessionTimeOut";
		}
		return result;
	}
	
	@RequestMapping(value = "/encrypt", method = RequestMethod.GET ,produces = "text/plain;charset=UTF-8")
	public String usersRest(@RequestParam(value = "data",required=false) String data ,HttpServletRequest httpRequest) {
		String result = "";
		try {
			if(data!= null && data.trim().length()>0) {
				String encrpyt =  AesUtil.getACInstance().acEncrypt(Constants.Encryption.PRIVATEKEY,data);
				result = encrpyt;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "sessionTimeOut";
		}
		return result;
	}
	
}
