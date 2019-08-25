package th.priisoft.crm.common.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

import th.priisoft.crm.spring.resource.AuthServiceResource;


public class AuthFilter implements Filter {

    
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		try {
		        try{
				String URIm = httpRequest.getRequestURI();
		  		System.out.println(" #### URI "+ URIm +" ### ");
		  		}catch (Exception e) {
					e.printStackTrace();
				}
			  if((!httpRequest.getMethod().equals("OPTIONS")) && (httpRequest.getMethod().equals("POST") || httpRequest.getMethod().equals("GET")
					  || httpRequest.getMethod().equals("PUT") || httpRequest.getMethod().equals("DELETE"))) {
			  
			     
			      System.out.println(" #### End header name ### ");
			      System.out.println(" httpRequest.getRequestURI() :"+ httpRequest.getRequestURI() );
		    	  String URI = httpRequest.getRequestURI();
		    	  if( (URI.indexOf("/rest/login")>-1||URI.indexOf("/rest/logout") >-1||URI.indexOf("/rest/gnbypass") > -1 ) ){
		    		  chain.doFilter(request, response);
		    	  }else {
		    		  
		    		  if(httpRequest.getSession()!= null && httpRequest.getSession().getAttribute("username")!=null) {
		    			  String username = (String) httpRequest.getSession().getAttribute("username");
		    			  if(httpRequest.getSession() == null) {
		    				  httpRequest.getSession(true);
		    			  }
		    			  
		    			  String sessionid = httpRequest.getSession().getId();
		    			  
		    			  
		    			  if(AuthServiceResource.session_controle.get(username)!=null && AuthServiceResource.session_controle.get(username).equals(sessionid)) {
		    				  chain.doFilter(request, response);
		    			  }else {
		    				   httpResponse.setStatus(200);
					    	   httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE+";UTF-8");
					    	   httpResponse.setCharacterEncoding("UTF-8");
					    	   PrintWriter writer=httpResponse.getWriter();
					    	   writer.write("{\"result_code\": \"505\",\"result_data\": {},\"result_message\": \"Duplicate Session!\"}"); 
		    			  }
		    		   
		    		  }else {
		    			   httpResponse.setStatus(200);
				    	   httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE+";UTF-8");
				    	   httpResponse.setCharacterEncoding("UTF-8");
				    	   PrintWriter writer=httpResponse.getWriter();
				    	   writer.write("{\"result_code\": \"504\",\"result_data\": {},\"result_message\": \"Session is Expire!\"}"); 
		    		  }
		    	  }
			     
			  }else {
				  chain.doFilter(request, response);
			  }
		}catch (Exception e) {
			e.printStackTrace();
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	 	   	httpResponse.setContentType("text/plain");
	 	   	PrintWriter writer=httpResponse.getWriter();
	 	   writer.write("Session is expire!!!");
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
