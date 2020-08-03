package servlets.departmentsServlet;

import model.tables.Departments;
import model.tablesConnection.DepartmentsDataBase;
import servlets.CustomServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/departmentsDelete")
public class DepartmentsDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doDelete(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final int DEPARTMENT_ID = Integer.parseInt(req.getParameter("DEPARTMENT_ID"));
        final Departments departmentsObject = new Departments(DEPARTMENT_ID);

             HashMap<Integer, Departments> DEPARTMENTS = null;
        try {
            DEPARTMENTS = (HashMap<Integer, Departments>) getServletContext().getAttribute("DEPARTMENTS");
        } catch (ClassCastException e){
            System.out.println("Problems with classcast on DepartmentsDelete post " + e);
        }
        DEPARTMENTS.put(departmentsObject.getDEPARTMENT_ID(),departmentsObject);
        CustomServletContext.servletContext.setAttribute("DEPARTMENTS", DEPARTMENTS);

        DepartmentsDataBase.deleteDepartments(departmentsObject);

        resp.sendRedirect("/departments");
    }
}

