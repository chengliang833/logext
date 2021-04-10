package top.ulane.logext.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParamFilter implements Filter {
	
    private static Logger log = LoggerFactory.getLogger(ParamFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
//		HttpServletResponse response = (HttpServletResponse) res;
	    String path = request.getRequestURI();
	    log.info("path:"+path);
	    //改到AOP中打印
//        if (request.getMethod().equals("POST")){
//        	HttpServletRequest requestWrapper = new RequestWrapper(request);
//            String body = ConvertUtil.parseString(requestWrapper.getInputStream());
//            log.info("POST:params:"+JSON.toJSONString(request.getParameterMap()));
//            log.info("POST:body:"+body);
//            chain.doFilter(requestWrapper, res);
//        }else if (request.getMethod().equals("GET")){
//            log.info("GET:params:"+JSON.toJSONString(request.getParameterMap()));
            chain.doFilter(req, res);
//        }
        
	}

	@Override
	public void destroy() {

	}
	
//	class RequestWrapper extends HttpServletRequestWrapper {
//	   private final byte[] body;
//	 
//	   public RequestWrapper(HttpServletRequest request) throws IOException {
//		   super(request);
//			this.body = ConvertUtil.streamToByte(request.getInputStream());
//	   }
//	    
//	   @Override
//	   public BufferedReader getReader() {
//	      return new BufferedReader(new InputStreamReader(getInputStream()));
//	   }
//	    
//	   @Override
//	   public ServletInputStream getInputStream() {
//	      final ByteArrayInputStream bais = new ByteArrayInputStream(body);
//	      return new ServletInputStream() {
//	         @Override
//	         public int read() {
//	            return bais.read();
//	         }
//	      };
//	   }
//	}
	
}