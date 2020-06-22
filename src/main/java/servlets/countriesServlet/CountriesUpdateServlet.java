package servlets.countriesServlet;

import model.tables.Countries;
import model.tablesConnection.CountryDataBase;
import servlets.CustomServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/countriesUpdate")
public class CountriesUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

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

        HashMap<Integer, Countries> updateArgument = new HashMap<>();
        updateArgument.put(countriesObject.getCOUNTRY_ID(), countriesObject);
        CountryDataBase.updateCountries(updateArgument);

        req.getRequestDispatcher("/countries").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final String id = req.getParameter("id");

        req.getRequestDispatcher("/WEB-INF/view/countriesView/countriesUpdate.jsp")
                .forward(req, resp);
    }
}
