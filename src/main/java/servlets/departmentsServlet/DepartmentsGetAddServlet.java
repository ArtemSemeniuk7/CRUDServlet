package servlets.departmentsServlet;

import model.tables.Countries;
import model.tables.Departments;
import model.tablesConnection.CountryDataBase;
import model.tablesConnection.DepartmentsDataBase;
import model.tablesConnection.JobsDataBase;
import servlets.CustomServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/departments")
public class DepartmentsGetAddServlet extends HttpServlet {
    HashMap<Integer, Departments> DEPARTMENTS;
    public final String departmentsTable = "/WEB-INF/view/departmentsView/departmentsTable.jsp";
    @Override
    public void init() {
        try {
            DEPARTMENTS = (HashMap<Integer, Departments>) getServletContext().getAttribute("DEPARTMENTS");
            // Unsafe, I know
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on DepartmentsGetAdd init " + e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            DEPARTMENTS = (HashMap<Integer, Departments>) getServletContext().getAttribute("DEPARTMENTS");
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on DepartmentsGetAdd get " + e);
        }
        req.setAttribute("DEPARTMENTS", DEPARTMENTS.values());

        req.getRequestDispatcher(departmentsTable).forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

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
            DEPARTMENTS =
                    (HashMap<Integer, Departments>) getServletContext().getAttribute("DEPARTMENTS");
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on DepartmentsGetAdd post " + e);
        }
        DEPARTMENTS.put(departmentsObject.getDEPARTMENT_ID(),departmentsObject);
        CustomServletContext.servletContext.setAttribute("DEPARTMENTS", DEPARTMENTS);
        DepartmentsDataBase.insertDepartments(DEPARTMENTS);

        doGet(req, resp);
    }
}
