package th.priisoft.crm.common.object;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.List;

import th.priisoft.crm.common.constant.Constants;
import th.priisoft.crm.common.date.DateControl;
import th.priisoft.crm.model.Message;
import th.priisoft.crm.model.MessageBody;

public class ObjectControl {
	private static final String mobile_prefix = "+66";
	
	public static String toString(Object obj) throws Exception {
		StringBuilder str = new StringBuilder();
		if (obj != null) {
			// --- get value from source ---//
			Method[] methods = obj.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("get")) {
					String value = String.valueOf(method.invoke(obj));
					if (value != null && !"".equals(value)) {
						str.append(method.getName()).append(": ").append(value).append(" | ");
					}
				}
			}
		}
		return str.toString();
	}
	
	public static String getMime(String file) throws Exception {
		String mime = "";
		String[] ext = file.toLowerCase().split("\\.");
		//---	mime	---//
		if("docx".contains(ext[ext.length-1]) || "doc".contains(ext[ext.length-1]))	mime = "application/msword";
		else if("pdf".contains(ext[ext.length-1]))	mime = "application/pdf";
		else if("jpg".contains(ext[ext.length-1]) || "jpe".contains(ext[ext.length-1]) || "jpeg".contains(ext[ext.length-1]))	mime = "image/jpeg";
		else if("png".contains(ext[ext.length-1]))	mime = "image/png";
		
		if("".equals(mime))	throw new Exception("not found extention file!!!");
		return mime;
	}

	public static String numberFormat(double number) {
		DecimalFormat format = new DecimalFormat("##,###,###.00");
		return format.format(number);
	}
	
	public static String numberScale (double number) {
		DecimalFormat format = new DecimalFormat("########.00");
		return format.format(number);
	}
	

	// --- business for common generate ---//
	public static String pathPicturn(String appPath, String notiNo, String batchNo) {
		String yyyyMM = DateControl.dateToString(DateControl.today(), Constants.Date.TIME_PATTERN_yyyyMM);
		StringBuffer sb = new StringBuffer();
		sb.append(appPath).append(File.separator);
		sb.append(yyyyMM).append(File.separator);
		if (notiNo != null && !"".equals(notiNo))	sb.append(notiNo).append(File.separator);
		if (batchNo != null && !"".equals(batchNo))	sb.append(batchNo).append(File.separator);
		return sb.toString();
	}

	// --- for email ---//
	public static MessageBody[] convertListToArray(List<MessageBody> list) {
		MessageBody[] arrBody = new MessageBody[list.size()];
		arrBody = list.toArray(arrBody);
		return arrBody;
	}
	public static MessageBody generateMailBodyHT(String message) {
		MessageBody body = new MessageBody();
		body.setType("HT");
		body.setMessage(message);
		return body;
	}
	public static MessageBody generateMailBodyTX(String message) {
		MessageBody body = new MessageBody();
		body.setType("TX");
		body.setMessage(message);
		return body;
	}
	public static MessageBody generateMailBodyFA(String message) throws IOException {
		MessageBody body = new MessageBody();
		body.setType("FA");
		body.setMessage(message);
		return body;
	}
	public static MessageBody generateMailBodyFA(String message, byte[] file, String pathAndFileNmae)
			throws IOException {
		MessageBody body = new MessageBody();
		body.setType("FA");
		body.setMessage(message);
		FileOutputStream stream = new FileOutputStream(pathAndFileNmae);
		stream.write(file);
		stream.flush();
		stream.close();
		stream = null;
		return body;
	}
	public static Message generateMailSOI(String email, String subject, String userid, String transType, String type,
			String appName) {
		// ส่งแบบ Individual: SOI
		Message mail = generateMailCommon();
		if ("".equals(transType) || transType == null)
			mail.setTranstype("TX");
		else
			mail.setTranstype(transType);
		if ("".equals(type) || type == null)
			mail.setType("SOI");
		else
			mail.setType(type);
		if ("".equals(appName) || appName == null)
			mail.setAppname("CLAIM");
		else
			mail.setAppname(appName);
		mail.setMsgto(email);
		mail.setUpduserid(userid);
		mail.setSubject(subject);
		return mail;
	}
	private static Message generateMailCommon() {
		Message mail = new Message();
		mail.setMsgfr("MSIG_Insurance@msig-thai.com");
		mail.setProcess("2A");
		mail.setMailsys("SMTP");
		mail.setHostname("TH-SMTP.th.msig.com");
		return mail;
	}
}
