package th.priisoft.crm.spring.service.common;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.naming.AuthenticationNotSupportedException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.stereotype.Service;

import th.priisoft.crm.common.log.LogUtil;

@Service
public class LdapServiceImpl implements LdapService {
	
	private boolean verifyAD(String serverName, String userad, String pwd) throws Exception {
		boolean result = false;
		Hashtable<String, String> environment = new Hashtable<String, String>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.PROVIDER_URL, "ldap://"+serverName);
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
        environment.put(Context.SECURITY_PRINCIPAL, userad+"@th.msig.com");
        environment.put(Context.SECURITY_CREDENTIALS, pwd);      
        
        try {
        	InitialDirContext context = new InitialDirContext(environment);
        	LogUtil.adInfoHeader("Connected..");
        	result = true;
            context.close();
        } 
        catch (AuthenticationNotSupportedException exception)	{	LogUtil.adError("The authentication is not supported by the server");	}
        catch (AuthenticationException exception)	{	LogUtil.adError("Incorrect password or username");	}
        catch (NamingException exception)	{	LogUtil.adError("Error when trying to create the context");	}
        return result;
	}
	
	
	private Map<String, Object> connectAD(String serverName, String root, String pwd, String searchBase, String userAd) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		Hashtable<String, String> environment = new Hashtable<String, String>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.PROVIDER_URL, "ldap://"+serverName);
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
        environment.put(Context.SECURITY_PRINCIPAL, root);
        environment.put(Context.SECURITY_CREDENTIALS, pwd);      
        
        try {
        	InitialDirContext context = new InitialDirContext(environment);
        	LogUtil.adInfoHeader("Connected..");
            
            SearchControls searchCtls = new SearchControls();  
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);  
			String searchFilter = "(&(objectClass=user)(sAMAccountName="+userAd+"))";
			String returnedAtts[] = {"mail","displayName"};
		     searchCtls.setReturningAttributes(returnedAtts);
		     NamingEnumeration<SearchResult> answer = context.search(searchBase, searchFilter, searchCtls);
		     SearchResult searchResult = null;
		     if(answer.hasMoreElements()) {
		    	 searchResult = (SearchResult) answer.nextElement();
		    	 NamingEnumeration<String> id = searchResult.getAttributes().getIDs();
		    	 while(id.hasMoreElements()) {
		    		 String strID = id.next();
		    		 result.put(strID, searchResult.getAttributes().get(strID).get());
		    	 }
		         if(answer.hasMoreElements()) LogUtil.adError("Matched multiple users for the accountName: "+userAd);
		    }
            context.close();
        } 
        catch (AuthenticationNotSupportedException exception)	{	LogUtil.adError("The authentication is not supported by the server");	}
        catch (AuthenticationException exception)	{	LogUtil.adError("Incorrect password or username");	}
        catch (NamingException exception)	{	LogUtil.adError("Error when trying to create the context");	}
        return result;
	}

	
}
