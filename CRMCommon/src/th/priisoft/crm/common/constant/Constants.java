package th.priisoft.crm.common.constant;

import java.util.Locale;

public class Constants {
	public final static String ENCODE_UTF8 = "UTF-8";
	public final static String ENCODE_ISO8859_1 = "ISO8859-1";
	
	public static class Encryption{
		public static String PRIVATEKEY = "";
		public static final String SECRET_KEY = "secretkey";
		public static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
		public static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
		public static final String HMAC_SHA512_ALGORITHM = "HmacSHA512";
		public static final String PBKDF_HMAC_SHA1_ALGORITHM = "PBKDF2WithHmacSHA1";
	}
	
	public static class Alfresgo {
		public static String  GET_DOC_URL = "";
		public static String  UPLOAD_URL = "";
	}
	
	public static class Genesys {
		public static String  SECRET_PBP_KEY = "";
		public static String  NAME_PARAM_LOGONAD = "LogonAd";
		public static String  NAME_PARAM_CALLID = "CallID";
		public static String  NAME_PARAM_OUTBOUND_ID = "ObTagetId";
	}
	
	public static class Date {
		public final static String DATE_WEBSERVICE = "yyyy-MM-dd'T'HH:mm:ss";

		public final static String DATE_PATTERN_R_ddMMyyyy = "DDMMYYYY";
		public final static String DATE_PATTERN_P_ddMMyyyy = "ddMMyyyy";
		public final static String DATE_PATTERN_ddMMyyyy = "dd/MM/yyyy";
		public final static String DATE_PATTERN_DDMMYYYY = "DD/MM/YYYY";
		public final static String DATE_PATTERN_DDMMBBBB = "DD/MM/BBBB";
		public final static String DATE_PATTERN_DDMMTTTT = "DD/MM/TTTT";
		public final static String DATE_PATTERN_yyMMdd_WITHSLASH = "yyMM/dd";
		public final static String DATE_PATTERN_dd = "dd";
		public final static String DATE_PATTERN_yy = "yy";
		public final static String DATE_PATTERN_YY = "YY";
		public final static String DATE_PATTERN_DD = "DD";
		public final static String DATE_PATTERN_yyyy = "yyyy";
		public final static String DATE_PATTERN_MM = "MM";
		public final static String DATE_PATTERN_YYYYMMDD = "YYYYMMDD";
		public final static String DATE_PATTERN_yyyyMMdd = "yyyyMMdd";

		public final static String TIME_ddMMyyyy_hhmmssaaa = "dd/MM/yyyy hh:mm:ss aaa";
		
		public final static String TIME_PATTERN_HHMMSS = "HH:mm:ss";
		public final static String TIME_PATTERN_HHmmss = "HHmmss";
		public final static String TIME_PATTERN = "dd/MM/yy HH:mm:ss";
		public final static String TIME_PATTERN_ddMMyyyy = "dd/MM/yyyy HH:mm:ss";
		public final static String TIME_PATTERN_ddMMyyyy_HHmm = "dd/MM/yyyy HH:mm";
		public final static String TIME_PATTERN_yyyyMMdd = "yyyyMMdd";
		public final static String TIME_PATTERN_yyyy_MM_dd = "yyyy-MM-dd";
		public final static String TIME_PATTERN_yyyyMM = "yyyyMM";
		public final static String TIME_PATTERN_yyMM = "yyMM";
		public final static String TIME_PATTERN_HH_MM = "HH:MM";
		public final static String TIME_PATTERN_HHmm = "HH:mm";
		public final static String TIME_PATTERN_HHMMSS_INT = "HHMMSS";
		public final static String TIME_PATTERN_ddMMyyyy400 = "yyyy-MM-dd-HH.mm.ss";
		public final static String TIME_PATTERN_yyyyMMdd_HHmmssXXX = "yyyy-MM-dd'T'HH:mm:ssXXX";
		public final static String TIME_PATTERN_yyyyMMdd_HHmmss = "yyyy-MM-dd HH:mm:ss";

		public final static Locale EN_LOCALE = new Locale("en", "EN");
		public final static Locale TH_LOCALE = new Locale("th", "TH");
	}
	
	public static class Refer {
		public static final char  REFER_LETTER='L';      //ขออนุมัติ Requisition
	    // STATUS      
	    public static final String  STATE_AUTHORIZE_PENDING = "A";     // รออนุมัติ
	    public static final String  STATE_AUTHORIZE_SUCCESS = "B";		// อนุมัติเรียบร้อยแล้ว
	    public static final String  STATE_AUTHORIZE_REJECT = "R";		// ยกเลิก
	}

	public static class Response {
		public static final int STATUS_OK = 200;
		public static final int STATUS_BAD_REQ = 202;
		public static final int STATUS_INTERNAL_ERR = 500;
		
		public static final String GET_SUCCESS_STATUS = "100";
		public static final String GET_SUCCESS_MSG = "Success";
		public static final String GET_NOTFOUND_STATUS = "101";
		public static final String GET_NOTFOUND_MSG = "Data not found";
		public static final String POST_SUCCESS_STATUS = "200";
		public static final String POST_SUCCESS_MSG = "Create success";
		public static final String POST_REQUIRED_STATUS = "201";
		public static final String POST_REQUIRED_MSG = "Data is required";
		public static final String POST_NOTVALIDATE_STATUS = "202";
		public static final String POST_NOTVALIDATE_MSG = "Data is not validate";
		public static final String POST_ALREADY_STATUS = "203";
		public static final String POST_ALREADY_MSG = "Already datas";
		public static final String POST_NOTINSERT_STATUS = "204";
		public static final String POST_NOTINSERT_MSG = "Can't Inser data";
		public static final String PUT_SUCCESS_STATUS = "300";
		public static final String PUT_SUCCESS_MSG = "Update success";
		public static final String PUT_REQUIRED_STATUS = "301";
		public static final String PUT_REQUIRED_MSG = "Data is required";
		public static final String PUT_NOTVALIDATE_STATUS = "302";
		public static final String PUT_NOTVALIDATE_MSG = "Data is not validate";
		public static final String PUT_NOTFOUND_STATUS = "303";
		public static final String PUT_NOTFOUND_MSG = "Data not found";
		public static final String DELETE_SUCCESS_STATUS = "400";
		public static final String DELETE_SUCCESS_MSG = "Delete success";
		public static final String DELETE_NOTFOUND_STATUS = "401";
		public static final String DELETE_NOTFOUND_MSG = "Data not found";
		public static final String ERROR_STATUS = "500";
		public static final String ERROR_MSG = "Internal server error";
		public static final String LOG_ERROR_MSG = "Can not save Log";
	}
	
	public enum CONFIG {

		AD_SERVER_NAME("configAD.ADServerName"),
		AD_ROOT("configAD.ADRoot"),
		AD_ROOT_PWD("configAD.ADRootPassword"),
		AD_SEARCH_BASE("configAD.SearchBase")
		;
		
		private final String grpType = "CONFIG";
		private final String code;

	    CONFIG(final String code) {
	        this.code = code;
	    }

		public String getGrpType() {
			return grpType;
		}

		public String getCode() {
			return code;
		}
	}
}