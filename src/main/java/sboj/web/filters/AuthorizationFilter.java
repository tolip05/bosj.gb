package sboj.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/jsf/home.jsf", "/jsf/add-job.jsf", "/jsf/delete-job.jsf", "/jsf/details-job.jsf"})
public class AuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userId = (String) ((HttpServletRequest) servletRequest).getSession()
                .getAttribute("user-id");

        if (userId == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/jsp/login.jsp");
          return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
