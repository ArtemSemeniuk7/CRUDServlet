package servlets.regionServlet;

import model.tables.Region;
import model.tablesConnection.RegionDataBase;
import servlets.CustomServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/region")
public class RegionGetAddServlet extends HttpServlet {

    HashMap<Integer, Region> REGION;
    public final String regionTable = "/WEB-INF/view/regionView/regionTable.jsp";
    String user;

    @Override
    public void init() {
        try {
            REGION = (HashMap<Integer, Region>) getServletContext().getAttribute("REGION");
            // Unsafe, I know
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on RegionGetAdd init " + e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        try {
            user = httpSession.getId();
            REGION = (HashMap<Integer, Region>) getServletContext().getAttribute("REGION");
        } catch (ClassCastException e){
            System.out.println("Problem with classcast on RegionGetAdd get " + e);
        }

        req.setAttribute("user", user);
        req.setAttribute("REGION", REGION.values());

        req.getRequestDispatcher(regionTable).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        try {
            int ID = Integer.parseInt(req.getParameter("regionId"));
            String TITLE = req.getParameter("regionName");

            final Region regionObject = new Region(ID, TITLE);
            HashMap<Integer, Region> REGION = null;
            try {
                REGION =
                        (HashMap<Integer, Region>) getServletContext().getAttribute("REGION");
            } catch (ClassCastException e) {
                System.out.println("Problem with classcast on RegionGetAdd post " + e);
            }
            REGION.put(regionObject.getRegionId(), regionObject);
            CustomServletContext.servletContext.setAttribute("REGION", REGION);

            RegionDataBase.insertRegion(REGION);

        } catch (Exception e){
            System.out.println(e);
        }
        doGet(req, resp);
    }
}
