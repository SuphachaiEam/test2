package th.priisoft.crm.common.restfull;



import org.apache.log4j.Logger;
import org.apache.wink.client.ClientResponse;

public class ClientCall {

	@SuppressWarnings("deprecation")
	public static String callForWink(String url, String params, Logger logger) throws Exception {
		if(logger == null) logger = Logger.getLogger(ClientCall.class.getName());
		org.apache.wink.client.ClientConfig clientConfig = new org.apache.wink.client.ApacheHttpClientConfig();
		org.apache.wink.client.RestClient client = new org.apache.wink.client.RestClient(clientConfig);
		org.apache.wink.client.Resource resource = client.resource(url);
		ClientResponse response = null;
		logger.info("url: " + url);
		logger.info("param: " + params);
		if (null != params) {
			response = (ClientResponse) resource.contentType("application/json").accept("*/*").post(params);
		} else {
			response = (ClientResponse) resource.contentType("application/json").accept("*/*").get();
		}
		if (response.getStatusCode() != 200) {
			throw new Exception(response.getEntity(String.class));
		}
		return response.getEntity(String.class);
	}

}
