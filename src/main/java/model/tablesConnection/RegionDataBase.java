package model.tablesConnection;

import model.DataBaseConnector;
import model.tables.Region;
import servlets.CustomServletContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class RegionDataBase {
    static Statement statement = DataBaseConnector.getStatement();
    public HashMap<Integer, Region> createRegion(){
        return selectRegion();
    }

    public static HashMap<Integer, Region> selectRegion() {
        ResultSet resultSet = null;
        HashMap<Integer, Region> map = null;
      
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + "REGION;");
            map = new HashMap<>();
            while (resultSet.next()) {
                map.put(resultSet.getInt("REGION_ID"),
                        new Region(resultSet.getInt("REGION_ID"),
                        resultSet.getString("REGION_NAME")));
            }
        } catch (SQLException e) {
            System.out.println("Problems with selectRegion " + e);
        }
        return map;
    }

    public static void insertRegion(HashMap<Integer, Region> table){
        try {
            HashSet<Region> regionValue = new HashSet<>(table.values());
            HashMap<Integer, Region> insertmap = selectRegion();
<<<<<<< HEAD

            HashSet<Region> insertjobs = new HashSet<>(insertmap.values());
            regionValue.removeAll(insertjobs);

=======
            
            HashSet<Region> insertjobs = new HashSet<>(insertmap.values());
            regionValue.removeAll(insertjobs);
            
>>>>>>> 443d47e2f85f90740b29483639f3dd81c1de79e3
            Iterator<Region> itr = regionValue.iterator();
            
            while (itr.hasNext()) {
                Region REGION = itr.next();
                System.out.println(REGION.getRegionId());
                
                String sql = "SET FOREIGN_KEY_CHECKS=0;";
                statement.execute(sql);
<<<<<<< HEAD

=======
                
>>>>>>> 443d47e2f85f90740b29483639f3dd81c1de79e3
                String insertsql = "INSERT INTO " + "REGION" +
                        " (REGION_ID, REGION_NAME) " +
                        " VALUES" + " ( " + REGION.getRegionId() + ", " + "'" +
                        REGION.getRegionName() + "'" + ");";
                
                statement.executeUpdate(insertsql);
            }
        } catch (SQLException e) {
            System.out.println("Problems with insertRegion " + e);
        }
    }

    public static void updateRegion(Region REGION){
        try {
<<<<<<< HEAD
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(sql);

=======
            ArrayList<Region> list = new ArrayList<>(table.values());
            Region REGION = list.get(0);
            
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(sql);
            
>>>>>>> 443d47e2f85f90740b29483639f3dd81c1de79e3
            String updatesql = "UPDATE REGION SET" +
                    " REGION_ID = " + REGION.getRegionId() +
                    ", REGION_NAME = '"  + REGION.getRegionName() +
                    "' WHERE REGION_ID = " + REGION.getRegionId() + "; ";
            System.out.println(updatesql);
            
            statement.executeUpdate(updatesql);

        } catch (SQLException e) {
            System.out.println("Problems with updateRegio " + e);
        }
    }

    public static void deleteRegion(Region REGION){
        try {
<<<<<<< HEAD
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(sql);

=======
            ArrayList<Region> list = new ArrayList<>(table.values());
            Region REGION = list.get(0);
            
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(sql);
            
>>>>>>> 443d47e2f85f90740b29483639f3dd81c1de79e3
            String deletesql = "DELETE FROM REGION WHERE REGION_ID = "
                    +  REGION.getRegionId() + " ;";
            System.out.println(deletesql);
            
            statement.executeUpdate(deletesql);
<<<<<<< HEAD

            CustomServletContext.servletContext.setAttribute("REGION", selectRegion());

=======
            
            CustomServletContext.servletContext.setAttribute("REGION", selectRegion());
            
>>>>>>> 443d47e2f85f90740b29483639f3dd81c1de79e3
        } catch (SQLException e) {
            System.out.println("Problems with deleteRegion " + e);
        }
    }
}
