package Filter;

import java.io.IOException;
import java.util.List;

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


@WebFilter(urlPatterns = {"/index.jsp"})
public class CheckIndex implements Filter {

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;
		HttpSession session = req.getSession();
		List<Model.Product> products = (List<Model.Product>) session.getAttribute("product");
		if(products != null) {
			arg2.doFilter(arg0, arg1);
		}else {
			res.sendRedirect("/PRJASM3/check");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
