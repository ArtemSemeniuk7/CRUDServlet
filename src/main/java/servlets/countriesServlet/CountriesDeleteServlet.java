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

@WebServlet("/countriesDelete")
public class CountriesDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final int ID = Integer.parseInt(req.getParameter("COUNTRY_ID"));
        final Countries countriesObject = new Countries(ID);

        HashMap<Integer, Countries> COUNTRIES = null;
        try {
            COUNTRIES = (HashMap<Integer, Countries>) getServletContext().getAttribute("COUNTRIES");
        } catch (ClassCastException e){
            System.out.println("Problems with classcast on CountriesDelete post " + e);
        }
        COUNTRIES.put(countriesObject.getCOUNTRY_ID(),countriesObject);
        CustomServletContext.servletContext.setAttribute("COUNTRIES", COUNTRIES);

        HashMap<Integer, Countries>  deleteCountries = new HashMap<>();
        deleteCountries.put(countriesObject.getCOUNTRY_ID(), countriesObject);
        CountryDataBase.deleteCountries(deleteCountries);

        resp.sendRedirect("/countries");
    }
}