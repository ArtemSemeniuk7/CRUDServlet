package servlets.jobsServlet;

import model.tablesConnection.JobsDataBase;
import model.tables.Jobs;
import servlets.CustomServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/jobs")
public class JobsGetAddServlet extends HttpServlet {
    HashMap<Integer, Jobs> JOBS;
    public final String jobsTable = "/WEB-INF/view/jobsView/jobsTable.jsp";
    String user;
    @Override
    public void init() {
        try {
            JOBS = (HashMap<Integer, Jobs>) getServletContext().getAttribute("JOBS");
            // Unsafe, I know
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on JobsGetAdd init " + e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        try {
            user = httpSession.getId();
            JOBS = (HashMap<Integer, Jobs>) getServletContext().getAttribute("JOBS");
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on JobsGetAdd get " + e);
        }

        req.setAttribute("user", user);
        req.setAttribute("JOBS", JOBS.values());

        req.getRequestDispatcher(jobsTable).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        try {
            int ID = Integer.parseInt(req.getParameter("JOBS_ID"));
            String TITLE = req.getParameter("JOBS_TITLE");
            int MIN = Integer.parseInt(req.getParameter("MIN_SALARY"));
            int MAX = Integer.parseInt(req.getParameter("MAX_SALARY"));

            final Jobs jobObject = new Jobs(ID, TITLE, MIN, MAX);
            HashMap<Integer, Jobs> JOBS = null;
            try {
                JOBS =
                        (HashMap<Integer, Jobs>) getServletContext().getAttribute("JOBS");
            } catch (ClassCastException e) {
                System.out.println("Problem with classcast on JobsGetAdd post " + e);
            }
            JOBS.put(jobObject.getJOBS_ID(), jobObject);
            CustomServletContext.servletContext.setAttribute("JOBS", JOBS);
            JobsDataBase.insertJobs(JOBS);
        } catch (Exception e){
            System.out.println(e);
        }
        doGet(req, resp);
    }
}
