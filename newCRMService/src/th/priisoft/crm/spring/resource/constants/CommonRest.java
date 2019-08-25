package th.priisoft.crm.spring.resource.constants;

public class CommonRest {
	
	public static final String STATUS_INTERNAL_ERROR = "500";
	public static final String MESG_INTERNAL_ERROR = "Internal Error";
	
	public static class CacheRestjson {
		public static final String URL = "/testJson";
		
		public static final String STATUS_SUCCESS = "204";
		public static final String MESSAGE_SUCCESS = "success";
	}
	
	
	public static class LoginService{
		public static final String URL = "/login";
		
		public static final String STATUS_LOGIN_SUCCESS = "204";
		public static final String MESG_LOGIN_SUCCESS = "Login success";
		
		public static final String STATUS_LOGIN_ERROR = "205";
		public static final String MESG_LOGIN_ERROR = "Login error";
	}
	
	public static class LogoutService{
		public static final String URL = "/logout";
		
		public static final String STATUS_LOGOUT_SUCCESS = "206";
		public static final String MESG_LOGOUT_SUCCESS = "Logout success";
		
		public static final String STATUS_LOGOUT_ERROR = "207";
		public static final String MESG_LOGOUT_ERROR = "Logout error";
	}
	
	public static class ByPassGenesysService{
		public static final String URL = "/gnbypass";
	}
}
