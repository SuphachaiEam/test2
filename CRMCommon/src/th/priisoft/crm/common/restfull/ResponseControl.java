package th.priisoft.crm.common.restfull;

import javax.ws.rs.core.Response;

import th.priisoft.crm.common.constant.Constants;
import th.priisoft.crm.common.constant.MessageConstants;

public class ResponseControl extends MessageConstants {
	
	public static Response OK(Object obj) {
		return Response.status(Constants.Response.STATUS_OK).entity(obj).build();
	}
	
	public static Response badReq(Object obj) {
		return Response.status(Constants.Response.STATUS_BAD_REQ).entity(obj).build();
	}
	
	
	public static Response internalErr(Object obj) {
		return Response.status(Constants.Response.STATUS_INTERNAL_ERR).entity(obj).build();
	}
	
	public static Response success(String result_code,Object result_data,String result_message) {
		ResponseObject rsObj = new ResponseObject();
		rsObj.setResult_code(result_code);
		rsObj.setResult_data(result_data);
		rsObj.setResult_message(result_message);
		return OK(rsObj);
	}
	
	public static ResponseObject resObj(String result_code,Object result_data,String result_message) {
		ResponseObject rsObj = new ResponseObject();
		rsObj.setResult_code(result_code);
		rsObj.setResult_data(result_data);
		rsObj.setResult_message(result_message);
		return rsObj;
	}
	
	
	
	

	
}
