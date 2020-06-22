package servlets.auth.filters;

import servlets.auth.UserDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = { "/jobs","/jobsUpdate", "/jobsDelete",
                           "/countries", "/countriesUpdate", "/countriesDelete",
                           "/departments", "/departmentsUpdate", "/departmentsDelete",
                           "/region", "/regionUpdate", "/regionDelete"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
         if (LoginServlet.log){
             filterChain.doFilter(servletRequest, servletResponse);
             return;
         }
         servletRequest.getRequestDispatcher(LoginServlet.loginTable)
                 .forward(servletRequest, servletResponse);
         //   httpServletResponse.sendRedirect("/");
    }
}
