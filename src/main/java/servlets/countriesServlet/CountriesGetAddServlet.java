package servlets.countriesServlet;


import model.tables.Countries;
import model.tablesConnection.CountryDataBase;
import model.tablesConnection.JobsDataBase;
import servlets.CustomServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/countries")
public class CountriesGetAddServlet extends HttpServlet {
    HashMap<Integer, Countries> COUNTRIES;
    public final String countriesTable = "/WEB-INF/view/countriesView/countriesTable.jsp";
    @Override
    public void init() {
        try {
            COUNTRIES = (HashMap<Integer, Countries>) getServletContext().getAttribute("COUNTRIES");
            // Unsafe, I know
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on CountriesGetAdd init " + e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            COUNTRIES = (HashMap<Integer, Countries>) getServletContext().getAttribute("COUNTRIES");
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on CountriesGetAdd get " + e);
        }
        req.setAttribute("COUNTRIES", COUNTRIES.values());

        req.getRequestDispatcher(countriesTable).forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        final int ID = Integer.parseInt(req.getParameter("COUNTRY_ID"));
        final String NAME = req.getParameter("COUNTRY_NAME");
        final int REGION_ID = Integer.parseInt(req.getParameter("REGION_ID"));

        final Countries countriesObject = new Countries(ID, NAME, REGION_ID);
        HashMap<Integer, Countries> COUNTRIES = null;
        try {
            COUNTRIES =
                    (HashMap<Integer, Countries>) getServletContext().getAttribute("COUNTRIES");
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on CountriesGetAdd post " + e);
        }
        COUNTRIES.put(countriesObject.getCOUNTRY_ID(),countriesObject);
        CustomServletContext.servletContext.setAttribute("COUNTRIES", COUNTRIES);
        CountryDataBase.insertCountries(COUNTRIES);

        doGet(req, resp);
    }
}

