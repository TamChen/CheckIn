package interceptor;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csust.entity.User;


public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
//		if(request.getRequestURI().endsWith("/CheckIn/exit"))
		if(request.getRequestURI().endsWith("login.jsp")){
			System.out.println(request.getRequestURI());
			chain.doFilter(req, res);
		}else{
			User user = (User) request.getSession().getAttribute("user");
			if(user != null){
				chain.doFilter(req, res);
			}else{
				((HttpServletResponse) res).setHeader("Cache-Control","no-cache");
				((HttpServletResponse) res).setDateHeader("Expires", 0);
				((HttpServletResponse)res).sendRedirect("login.jsp");
			}
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}