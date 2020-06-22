package servlets.auth.filters;

import servlets.auth.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class LoginServlet extends HttpServlet {

    public static final String loginTable = "/WEB-INF/view/auth/login.jsp";

    public static boolean log;
    static HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher(loginTable).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        log = UserDAO.selectUser(login, password);
        if(log) {
            session = req.getSession();
            session.setAttribute(login, password);
            resp.sendRedirect("/jobs");
        }
        else {
            doGet(req, resp);
        }
    }
}
