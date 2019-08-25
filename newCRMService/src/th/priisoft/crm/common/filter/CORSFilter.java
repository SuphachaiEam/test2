package th.priisoft.crm.common.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

// Enable it for Servlet 3.x implementations

public class CORSFilter implements Filter {
 
    
    public CORSFilter() {
        // TODO Auto-generated constructor stub
    }
 
    
    public void destroy() {
        // TODO Auto-generated method stub
    }
 
    
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
 
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("CORSFilter HTTP Request: " + request.getMethod());
        String url = "*";
        if(request.getHeader("origin")!=null&&request.getHeader("origin").trim().length()>0) {
        	url = request.getHeader("origin");
        	((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin",url);
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Credentials", "true");
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Cookie");
              
        }else {
        	((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin","http://localhost:4200");
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Credentials", "true");
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Cookie");	
        }
        // Authorize (allow) all domains to consume the content
      
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST, DELETE");
 
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
 
        // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
        if (request.getMethod().equals("OPTIONS")) {
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }
 
        // pass the request along the filter chain
        chain.doFilter(request, servletResponse);
    }
 
    
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
 
}