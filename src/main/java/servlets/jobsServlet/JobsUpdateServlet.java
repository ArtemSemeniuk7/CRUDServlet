package servlets.jobsServlet;

import model.tablesConnection.JobsDataBase;
import model.tables.Jobs;
import servlets.CustomServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/jobsUpdate")
public class JobsUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final int ID = Integer.parseInt(req.getParameter("JOBS_ID"));
        final String TITLE = req.getParameter("JOBS_TITLE");
        final int MIN = Integer.parseInt(req.getParameter("MIN_SALARY"));
        final int MAX = Integer.parseInt(req.getParameter("MAX_SALARY"));

        final Jobs jobObject = new Jobs(ID, TITLE, MIN, MAX);

        HashMap<Integer, Jobs> JOBS = null;
        try {
                JOBS = (HashMap<Integer, Jobs>) getServletContext().getAttribute("JOBS");
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on JobsUpdate pist " + e);
        }
        JOBS.put(jobObject.getJOBS_ID(),jobObject);
        CustomServletContext.servletContext.setAttribute("JOBS", JOBS);

        HashMap<Integer, Jobs> updateArgument = new HashMap<>();
        updateArgument.put(jobObject.getJOBS_ID(), jobObject);
        JobsDataBase.updateJobs(updateArgument);

        req.getRequestDispatcher("/jobs").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final String id = req.getParameter("id");

        req.getRequestDispatcher("/WEB-INF/view/jobsView/jobsUpdate.jsp")
                .forward(req, resp);
    }
}
