package servlets.departmentsServlet;

import model.tables.Departments;
import model.tablesConnection.DepartmentsDataBase;
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

@WebServlet("/departmentsUpdate")
public class DepartmentUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final int DEPARTMENT_ID = Integer.parseInt(req.getParameter("DEPARTMENT_ID"));
        final String DEPARTMENT_NAME = req.getParameter("DEPARTMENT_NAME");
        final int MANAGER_ID = Integer.parseInt(req.getParameter("MANAGER_ID"));
        final int LOCATION_ID = Integer.parseInt(req.getParameter("LOCATION_ID"));

        final Departments departmentsObject = new Departments(DEPARTMENT_ID,
                DEPARTMENT_NAME,
                MANAGER_ID,
                LOCATION_ID);

        HashMap<Integer, Departments> DEPARTMENTS = null;
        try {
            DEPARTMENTS = (HashMap<Integer, Departments>) getServletContext().getAttribute("DEPARTMENTS");
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on DepartmentUpdate pist " + e);
        }
        DEPARTMENTS.put(departmentsObject.getDEPARTMENT_ID(),departmentsObject);
        CustomServletContext.servletContext.setAttribute("DEPARTMENTS", DEPARTMENTS);

        HashMap<Integer, Departments> updateArgument = new HashMap<>();
        updateArgument.put(departmentsObject.getDEPARTMENT_ID(), departmentsObject);
        DepartmentsDataBase.updateDepartments(updateArgument);

        req.getRequestDispatcher("/departments").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final String id = req.getParameter("id");

        req.getRequestDispatcher("/WEB-INF/view/departmentsView/departmentsUpdate.jsp")
                .forward(req, resp);
    }
}
