package servlets.auth.filters.signIn;

import servlets.auth.UserDAO;
import servlets.auth.filters.LoginServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/createAccount")
public class CreateAccountServlet extends HttpServlet {
    public static final String createAccountTable =
            "/WEB-INF/view/auth/createAccount.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("che za nah");
        req.getRequestDispatcher(createAccountTable).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (UserDAO.signIn(login, password)) {
            httpSession.setAttribute(login, password);
            LoginServlet.log = true;
            req.getRequestDispatcher("/jobs").forward(req, resp);
        } else
            doGet(req, resp);
    }
}
