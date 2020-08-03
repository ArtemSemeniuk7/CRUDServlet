package servlets.employeesServlet;

import model.tables.Employees;
import model.tablesConnection.EmployeeDataBase;
import servlets.CustomServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/employeesDelete")
public class EmployeesDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final int ID = Integer.parseInt(req.getParameter("EMPLOYEES_ID"));
        final Employees employeesObject = new Employees(ID);

        HashMap<Integer, Employees> EMPLOYEES = null;
        try {
            EMPLOYEES =
                    (HashMap<Integer, Employees>) getServletContext().getAttribute("EMPLOYEES");
        } catch (ClassCastException e){
            System.out.println("Problems with classcast on JobsDelete post " + e);
        }
        EMPLOYEES.put(employeesObject.getEMPLOYEE_ID(), employeesObject);
        CustomServletContext.servletContext.setAttribute("EMPLOYEES", EMPLOYEES);

        EmployeeDataBase.deleteEmployees(employeesObject);

        resp.sendRedirect("/employees");
    }
}