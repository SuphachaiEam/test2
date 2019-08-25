package th.priisoft.crm.model;

import java.io.Serializable;

import th.priisoft.crm.common.string.StringFunctionHelper;

public class SmsM implements Serializable {
	private static final long serialVersionUID = -7291572029925549783L;
	
	private String id;
	private String mobileNo;
	private String message;
	private String reqTimeSmp;
	private String sentTimeSmp;
	private String smsOperator;
	private String sentBy;
	private String process;
	private String appName;
	private String language;
	
	public String getAppName() {
		return appName;
	}

	
	public String getId() {
		return id;
	}

	
	public String getLanguage() {
		return language;
	}

	
	public String getMessage() {
		return message;
	}

	
	public String getMobileNo() {
		return mobileNo;
	}

	
	public String getProcess() {
		return process;
	}

	
	public String getReqTimeSmp() {
		return reqTimeSmp;
	}

	
	public String getSentBy() {
		return sentBy;
	}

	
	public String getSentTimeSmp() {
		return sentTimeSmp;
	}

	
	public String getSmsOperator() {
		return smsOperator;
	}

	
	public void setAppName(String string) {
		appName = string;
	}

	
	public void setId(String string) {
		id = string;
	}

	
	public void setLanguage(String string) {
		language = string;
	}

	
	public void setMessage(String string) {
		message = StringFunctionHelper.getInstance().convertToThaiLang(string);
	}

	
	public void setMobileNo(String string) {
		mobileNo = string;
	}

	
	public void setProcess(String string) {
		process = string;
	}

	
	public void setReqTimeSmp(String string) {
		reqTimeSmp = string;
	}

	
	public void setSentBy(String string) {
		sentBy = string;
	}

	
	public void setSentTimeSmp(String string) {
		sentTimeSmp = string;
	}

	
	public void setSmsOperator(String string) {
		smsOperator = string;
	}

}
