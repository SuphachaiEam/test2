package th.priisoft.crm.spring.resource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import th.priisoft.crm.common.model.AfgUploadReq;
import th.priisoft.crm.common.restfull.ResponseControl;
import th.priisoft.crm.common.restfull.ResponseObject;
import th.priisoft.crm.common.utils.JsonUtils;
import th.priisoft.crm.spring.entity.prii.padta.Client;
import th.priisoft.crm.spring.resource.constants.CommonRest;
import th.priisoft.crm.spring.service.common.AfresgoService;
import th.priisoft.crm.spring.service.common.CommonService;
@RestController
@RequestMapping(value = "/common")
public class CommonSpringResource {
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private AfresgoService afresgoService;
	
	@Autowired
	AfresgoService alfresgoService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET ,produces = "text/plain;charset=UTF-8")
	public String cacheRest() {
		String result = "ok";
		try {
			commonService.saveRoleEnttiy();
			commonService.saveBankEnttiy();
			commonService.saveClientEnttiy();
			result = commonService.findClientEnttiy().getName();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "error";
		}
		return result;
	}

	@RequestMapping(value = CommonRest.CacheRestjson.URL  , method = RequestMethod.GET ,produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseObject cacheRestJson() {
		ResponseControl RespCon = new ResponseControl();
		HashMap<String , Object> data = new HashMap<String,Object>();
		try {
			
			Client newEntiry =  commonService.saveClientEnttiy();
			commonService.updateClientEnttiy();
			commonService.saveClientEnttiy("toz");
			
			List<Client> clientList = commonService.findByName("ศุภชัย toz");
			if(clientList!=null)
				System.out.println("list found : "+clientList.size());
			
			commonService.updateByName("toz", "ศุภชัย toz2");
			
			//commonService.deleteClientEnttiy(newEntiry);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return RespCon.resObj("500", data , "Internal Error!");
		}
		return RespCon.resObj(CommonRest.CacheRestjson.STATUS_SUCCESS, data , CommonRest.CacheRestjson.MESSAGE_SUCCESS);
	}
	

	
   @RequestMapping(value = "/testDoc"  , method = RequestMethod.GET ,produces =  MediaType.TEXT_HTML_VALUE)
   public String testDoc() throws Exception {
	    String test  = JsonUtils.genJsonString(alfresgoService.getDoc("7cb1eb0f-bb7a-4868-beb1-ac05c0c6b660"));
      return test;
   }
   
   @RequestMapping(value = "/testUploadDoc"  , method = RequestMethod.GET ,produces =  MediaType.TEXT_HTML_VALUE)
   public String getTestUpload() throws Exception {
	    
	    String test  = "";
	    AfgUploadReq afUploadReq = new AfgUploadReq();
	    afUploadReq.setSiteid("bancassurance");
	   
	    byte[] fileByte = Files.readAllBytes(Paths.get("C://BRMS.pdf"));
	    String fileBase64 = new String(Base64.getEncoder().encode(fileByte));
	    
	    afUploadReq.setFilestring(fileBase64);
	    afUploadReq.setFileName("testUpload.pdf");
	    afUploadReq.setUploaddirectory("/Doc for Tax Deduction/2018/agent");
	    afUploadReq.setContainerid("documentLibrary");
	    test=JsonUtils.genJsonString( alfresgoService.uploadDoc(afUploadReq));
	 
      return test;
   }
	
	
}
