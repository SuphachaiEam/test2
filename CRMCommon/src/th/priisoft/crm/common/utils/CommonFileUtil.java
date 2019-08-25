package th.priisoft.crm.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Base64;

public class CommonFileUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	private static CommonFileUtil instance;
	
	private static String IV = "2520671908164181";
	
	public static CommonFileUtil getInstance(){
		if (instance == null){
			instance = new CommonFileUtil();
		}
		return instance;
	}
	
	public synchronized String readFileBase64(String fileBase64) throws Exception {
		   InputStream is = null;
		   BufferedReader buf = null;
		
		StringBuilder contentBuilder = new StringBuilder();
		 try {
		    is = new ByteArrayInputStream(Base64.getDecoder().decode(fileBase64));
		    buf = new BufferedReader(new InputStreamReader(is,"UTF8")); 
		    String line = new String(buf.readLine()); 
		  
		    while(line != null){ 
		    	contentBuilder.append(line);
		    	line = buf.readLine(); 
		    } 
		   
	    }catch (Exception e) {
	    	throw e;
	    }finally {
	    	if(buf!=null) {
	    		try { buf.close(); } catch (IOException e) {}
	    		buf = null;
	    	}
			if(is!=null) {
				try { is.close(); } catch (IOException e) {}
				is = null;
			}
		}
		
	    return contentBuilder.toString();
	}

}
