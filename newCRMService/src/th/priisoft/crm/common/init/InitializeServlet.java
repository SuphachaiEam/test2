package th.priisoft.crm.common.init;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import th.priisoft.crm.common.constant.Constants;

public class InitializeServlet extends HttpServlet implements Servlet {

	public static Properties prop = new Properties();
	
	private static final long serialVersionUID = -1414003833609755595L;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Locale.setDefault(Locale.US);		
		InputStream input = null;

		try {
			ClassLoader cl = InitializeServlet.class.getClassLoader();
			input = cl.getResourceAsStream("config.properties");
			prop.load(input);
			Constants.Encryption.PRIVATEKEY = prop.getProperty("SecureKey");
			Constants.Genesys.SECRET_PBP_KEY = prop.getProperty("GenesytKeyPBP");
			Constants.Alfresgo.GET_DOC_URL = prop.getProperty("afsGetDOCUrl");
			Constants.Alfresgo.UPLOAD_URL = prop.getProperty("afsUploadDOCUrl");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return;
	} 
	
}