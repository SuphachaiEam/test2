package th.priisoft.crm.common.log;

import org.apache.log4j.Logger;

import th.priisoft.crm.common.object.ObjectControl;

public class LogUtil {
	
	private static Logger keepCacheLog = Logger.getLogger("keepCacheLog");
	private static Logger keepAccessLog = Logger.getLogger("keepAccessLog");
	private static Logger keepExternalLog = Logger.getLogger("keepExternalLog");
	private static Logger keepADLog = Logger.getLogger("keepADLog");
	
	//---	TODO cache log	---//
	public static void cacheInfoHeader(Object obj) {
		try {
			keepCacheLog.info("###	Cache	###");
			if(obj instanceof String) {		
				keepCacheLog.info(String.valueOf(obj));
			} else {		//for getter
				keepCacheLog.info(ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepCacheLog.error(e.getMessage());
		}
	}
	public static void cacheInfoReload(Object obj) {
		try {
			keepCacheLog.info("###	Cache Reload	###");
			if(obj instanceof String) {		
				keepCacheLog.info(String.valueOf(obj));
			} else {		//for getter
				keepCacheLog.info(ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepCacheLog.error(e.getMessage());
		}
	}
	public static void cacheInfo(Object obj) {
		try {
			if(obj instanceof String) {		
				keepCacheLog.info(String.valueOf(obj));
			} else {		//for getter
				keepCacheLog.info(ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepCacheLog.error(e.getMessage());
		}
	}
	public static void cacheError(Object obj) {
		try {
			if(obj instanceof String) {		
				keepCacheLog.error(String.valueOf(obj));
			} else {		//for getter
				keepCacheLog.error(ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepCacheLog.error(e.getMessage());
		}
	}
	
	//---	TODO access log	---//
	public static void accessInfoHeader(Object obj) {
		try {
			keepAccessLog.info("###	Access	###");
			if(obj instanceof String) {		
				keepAccessLog.info(String.valueOf(obj));
			} else {		//for getter
				keepAccessLog.info(ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepAccessLog.error(e.getMessage());
		}
	}
	public static void accessInfoHeader(String restfulName,Object obj) {
		try {
			keepAccessLog.info("###	Access	###");
			keepAccessLog.info("Restful: "+restfulName);
			if(obj instanceof String) {		
				keepAccessLog.info(String.valueOf(obj));
			} else {		//for getter
				keepAccessLog.info(ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepAccessLog.error(e.getMessage());
		}
	}
	public static void accessInfo(Object obj) {
		try {
			if(obj instanceof String) {		
				keepAccessLog.info(String.valueOf(obj));
			} else {		//for getter
				keepAccessLog.info(ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepAccessLog.error(e.getMessage());
		}
	}
	public static void accessError(Object obj) {
		try {
			if(obj instanceof String) {		
				keepAccessLog.error(String.valueOf(obj));
			} else {		//for getter
				keepAccessLog.error(ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepAccessLog.error(e.getMessage());
		}
	}
	
	//---	TODO external log	---//
	public static void externalInfoHeader(String restfulName,Object obj) {
		try {
			keepExternalLog.info("###	External	###");
			keepExternalLog.info("# Restful: "+restfulName);
			if(obj instanceof String) {		
				keepExternalLog.info(String.valueOf(obj));
			} else {		//for getter
				keepExternalLog.info(ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepExternalLog.error(e.getMessage());
		}
	}
	public static void externalInfo(Object obj) {
		try {
			if(obj instanceof String) {		
				keepAccessLog.info("# "+String.valueOf(obj));
			} else {		//for getter
				keepAccessLog.info("# "+ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepAccessLog.error(e.getMessage());
		}
	}
	
	//---	TODO AD log	---//
	public static void adInfoHeader(Object obj) {
		try {
			keepADLog.info("###	AD	###");
			if(obj instanceof String) {		
				keepADLog.info(String.valueOf(obj));
			} else {		//for getter
				keepADLog.info(ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepADLog.error(e.getMessage());
		}
	}
	public static void adInfoReload(Object obj) {
		try {
			keepADLog.info("###	AD Reload	###");
			if(obj instanceof String) {		
				keepADLog.info(String.valueOf(obj));
			} else {		//for getter
				keepADLog.info(ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepADLog.error(e.getMessage());
		}
	}
	public static void adInfo(Object obj) {
		try {
			if(obj instanceof String) {		
				keepADLog.info("# "+String.valueOf(obj));
			} else {		//for getter
				keepADLog.info("# "+ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepADLog.error(e.getMessage());
		}
	}
	public static void adError(Object obj) {
		try {
			if(obj instanceof String) {		
				keepADLog.error("E# "+String.valueOf(obj));
			} else {		//for getter
				keepADLog.error("E# "+ObjectControl.toString(obj));
			}
		} catch(Exception e) {
			e.printStackTrace();
			keepADLog.error(e.getMessage());
		}
	}
}
