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

@WebServlet("/employeesUpdate")
public class EmployeesUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int ID = Integer.parseInt(req.getParameter("EMPLOYEE_ID"));
        String FIRST_NAME = req.getParameter("FIRST_NAME");
        String LAST_NAME = req.getParameter("LAST_NAME");
        String EMAIL = req.getParameter("EMAIL");
        String HIRE_DATE = req.getParameter("HIRE_DATE");
        int PHONE = Integer.parseInt(req.getParameter("PHONE"));
        int SALARY = Integer.parseInt(req.getParameter("SALARY"));
        int DEPARTMENT_ID = Integer.parseInt(req.getParameter("DEPARTMENT_ID"));

        final Employees employeesObject = new Employees(ID, FIRST_NAME, LAST_NAME, EMAIL,
                HIRE_DATE, PHONE, SALARY, DEPARTMENT_ID);

        HashMap<Integer, Employees> EMPLOYEES = null;
        try {
            EMPLOYEES =
                    (HashMap<Integer, Employees>) getServletContext().getAttribute("EMPLOYEES");
        } catch (ClassCastException e) {
            System.out.println("Problem with classcast on EmployeesUpdate post " + e);
        }
        EMPLOYEES.put(employeesObject.getEMPLOYEE_ID(), employeesObject);
        CustomServletContext.servletContext.setAttribute("EMPLOYEES", EMPLOYEES);

        EmployeeDataBase.updateEmployees(employeesObject);

        req.getRequestDispatcher("/employees").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/employeesView/employeesUpdate.jsp")
                .forward(req, resp);
    }
}
