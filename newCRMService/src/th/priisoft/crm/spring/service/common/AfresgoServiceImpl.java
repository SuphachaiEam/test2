package th.priisoft.crm.spring.service.common;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.priisoft.crm.common.constant.Constants;
import th.priisoft.crm.common.model.AfgUploadReq;
import th.priisoft.crm.common.restfull.ResponseObject;
import th.priisoft.crm.common.utils.JsonUtils;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AfresgoServiceImpl implements AfresgoService {
	
	public ResponseObject getDoc(String docid) throws Exception{
		ResponseObject resp = new ResponseObject();
		try {
			URL url = new URL(Constants.Alfresgo.GET_DOC_URL+docid);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			InputStream input = null;
	
			conn.setRequestMethod("GET");
			if(conn.getResponseCode()==200) {
			
				byte[] buffer = new byte[1024]; 
				int bufferLength = 0;
				input = conn.getInputStream();
				while ( (bufferLength = input.read(buffer)) > 0 ) { 
					output.write(buffer, 0, bufferLength); 
				}
				
				byte[] fileByte = output.toByteArray();
				String fileBase64 = new String(Base64.getEncoder().encode(fileByte));
				output.flush();
				HashMap<String, String>[] restDta = new HashMap[1];
				restDta[0] = new HashMap<String, String>();
				resp.setResult_code("200");
				resp.setResult_message("Success");
				//restDta[0].put("doc", StringEscapeUtils.escapeHtml4(fileBase64)); // for use copy to html file
				restDta[0].put("doc", fileBase64);
				
				String filename = "";
				String raw = conn.getHeaderField("Content-Disposition");
				if(raw != null && raw.indexOf("=") != -1) {
					filename = raw.split("=")[1]; 
				} else {
					filename = "tmp";
				}
				restDta[0].put("filename", filename);
				
				resp.setResult_data(restDta);
				
			} else if( conn.getResponseCode() == 404 || conn.getResponseCode() == 503 ) {
				resp.setResult_code(Integer.toString(conn.getResponseCode()));
				resp.setResult_message(" AlfresgoService can't connect" );
			}else {
				resp.setResult_code("202");
				resp.setResult_message("Data not fould!");
			}
		}catch (Exception e) {
			resp.setResult_code("500");
			resp.setResult_message(" AlfresgoService get doc error :" + e );
		}
		return resp;
	};
	
	
	public ResponseObject uploadDoc(AfgUploadReq afUploadReq) throws Exception{
		ResponseObject resp = new ResponseObject();
		try {
			URL url = new URL(Constants.Alfresgo.UPLOAD_URL);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setAllowUserInteraction(false);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			byte[] buffer = new byte[1024]; 
			int bufferLength = 0;
			
			InputStream input = new ByteArrayInputStream(JsonUtils.genJsonLocal(afUploadReq).getBytes("UTF-8"));
			OutputStream output2 = conn.getOutputStream();
			while ( (bufferLength = input.read(buffer)) > 0 ) {
				output2.write(buffer, 0, bufferLength); 
			}
			output2.flush();			
		
			if(conn.getResponseCode()==200) {
			
				buffer = new byte[1024]; 
				bufferLength = 0;
				input = conn.getInputStream();
				while ( (bufferLength = input.read(buffer)) > 0 ) { 
					output.write(buffer, 0, bufferLength); 
				}
				
				byte[] jsonByte = output.toByteArray();
				String JsonString = new String(jsonByte,"UTF-8");
				output.flush();
				
				HashMap<String, String>[] restDta = new HashMap[1];
				restDta[0] = new HashMap<String, String>();
				resp.setResult_code("200");
				resp.setResult_message("Success");
				
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode jsonNode = objectMapper.readValue(JsonString, JsonNode.class);
				String uid = jsonNode.get("resultObj").get("UID").asText();	
				restDta[0].put("UID", uid);
				resp.setResult_data(restDta);
				
			} else if( conn.getResponseCode() == 404 || conn.getResponseCode() == 503 ) {
				
				resp.setResult_code(Integer.toString(conn.getResponseCode()));
				resp.setResult_message(" AlfresgoService can't connect" );
				
			}else {
				
				resp.setResult_code(Integer.toString(conn.getResponseCode()));
				resp.setResult_message("Data not fould!");
				buffer = new byte[1024]; 
				bufferLength = 0;
				input = conn.getInputStream();
				while ( (bufferLength = input.read(buffer)) > 0 ) { 
					output.write(buffer, 0, bufferLength); 
				}
				
				byte[] jsonByte = output.toByteArray();
				String JsonString = new String(jsonByte,"UTF-8");
				output.flush();
				
				
				HashMap<String, String>[] restDta = new HashMap[1];
				restDta[0] = new HashMap<String, String>();
				restDta[0].put("resultjson", JsonString);
				resp.setResult_data(restDta);
				
			}
		}catch (Exception e) {
			resp.setResult_code("500");
			resp.setResult_message(" AlfresgoService get doc error :" + e );
		}
		return resp;
	};
}
