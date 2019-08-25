package th.priisoft.crm.common.restfull;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseObject implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public String result_code;
	public Object result_data;
	public String result_message;
	
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public Object getResult_data() {
		return result_data;
	}
	public void setResult_data(Object result_data) {
		this.result_data = result_data;
	}
	public String getResult_message() {
		return result_message;
	}
	public void setResult_message(String result_message) {
		this.result_message = result_message;
	}
	
}
