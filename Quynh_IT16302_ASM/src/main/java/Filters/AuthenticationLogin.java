package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.User;

/**
 * Servlet Filter implementation class AuthenticationLogin
 */
@WebFilter(
		urlPatterns = {
				"/QLUser/*",
				"/QLProduct/*",
				"/QLCategory/*",
				"/CartController/*",
				"/HomeStaff"
		}
)
public class AuthenticationLogin implements Filter {

    public AuthenticationLogin() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		HttpSession session = httpRq.getSession();
		User u = (User) session.getAttribute("user");
		User staff = (User) session.getAttribute("staff");
		
		if(u == null && staff == null) {
			httpRes.sendRedirect(httpRq.getContextPath() + "/HomeUser" +"?login_when_addtocart=1");
		
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
