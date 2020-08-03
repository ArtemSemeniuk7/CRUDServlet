package servlets.regionServlet;

import model.tables.Region;
import model.tablesConnection.RegionDataBase;
import servlets.CustomServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/regionDelete")
public class RegionDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doPost(req, resp);
    }
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp)
             throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        final int ID = Integer.parseInt(req.getParameter("regionId"));
        final Region regionObject = new Region(ID);

        HashMap<Integer, Region> REGION = null;
        try {
            REGION = (HashMap<Integer, Region>) getServletContext().getAttribute("REGION");
        } catch (ClassCastException e){
            System.out.println("Problems with classcast on RegionDelete post " + e);
        }
        REGION.put(regionObject.getRegionId(),regionObject);
        CustomServletContext.servletContext.setAttribute("REGION", REGION);

        RegionDataBase.deleteRegion(regionObject);

        resp.sendRedirect("/region");
    }
}
