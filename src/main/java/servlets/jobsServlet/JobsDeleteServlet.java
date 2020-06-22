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

@WebServlet("/jobsDelete")
public class JobsDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final int ID = Integer.parseInt(req.getParameter("JOBS_ID"));
        final Jobs jobObject = new Jobs(ID);

        HashMap<Integer, Jobs> JOBS = null;
        try {
            JOBS = (HashMap<Integer, Jobs>) getServletContext().getAttribute("JOBS");
        } catch (ClassCastException e){
            System.out.println("Problems with classcast on JobsDelete post " + e);
        }
        JOBS.put(jobObject.getJOBS_ID(),jobObject);
        CustomServletContext.servletContext.setAttribute("JOBS", JOBS);

        HashMap<Integer, Jobs>  deleteJobs = new HashMap<>();
        deleteJobs.put(jobObject.getJOBS_ID(), jobObject);
        JobsDataBase.deleteJobs(deleteJobs);

        resp.sendRedirect("/jobs");
    }
}
