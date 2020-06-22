package servlets.RegionServlet;

import model.tables.Jobs;
import model.tables.Region;
import model.tablesConnection.JobsDataBase;
import model.tablesConnection.RegionDataBase;
import servlets.CustomServletContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/regionUpdate")
public class RegionUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        final int ID = Integer.parseInt(req.getParameter("regionId"));
        final String TITLE = req.getParameter("regionName");

        final Region regionObject = new Region(ID, TITLE);

        HashMap<Integer, Region> REGION = null;
        try {
            REGION = (HashMap<Integer, Region>) getServletContext().getAttribute("REGION");
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on RegionUpdate pist " + e);
        }
        REGION.put(regionObject.getRegionId(),regionObject);
        CustomServletContext.servletContext.setAttribute("REGION", REGION);

        HashMap<Integer, Region> updateArgument = new HashMap<>();
        updateArgument.put(regionObject.getRegionId(), regionObject);
        RegionDataBase.updateRegion(updateArgument);

        req.getRequestDispatcher("/region").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/regionView/regionUpdate.jsp")
                .forward(req, resp);
    }
}
