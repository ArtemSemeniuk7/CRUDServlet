package servlets;

import model.tablesConnection.*;
import model.DataBaseConnector;
import servlets.auth.filters.LoginServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class CustomServletContext implements ServletContextListener {

    public static ServletContext servletContext = null;
    static final DataBaseConnector DATA_BASE_CONNECTOR = new DataBaseConnector();

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        LoginServlet.log = false;
        servletContext = sce.getServletContext();
        DATA_BASE_CONNECTOR.createConnection();

        servletContext.setAttribute("JOBS", new JobsDataBase().createJobs());
        servletContext.setAttribute("COUNTRIES", new CountryDataBase().createCountry());
        servletContext.setAttribute("DEPARTMENTS", new DepartmentsDataBase().createDepartments());
        servletContext.setAttribute("REGION", new RegionDataBase().createRegion());
        servletContext.setAttribute("EMPLOYEES", new EmployeeDataBase().createEmployees());

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            DataBaseConnector.getConnection().close();
        } catch (SQLException e) {
            System.out.println("Problems with closing on destroying " + e);
        }
    }
}
