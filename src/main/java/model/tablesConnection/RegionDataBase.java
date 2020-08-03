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

            HashSet<Region> insertjobs = new HashSet<>(insertmap.values());
            regionValue.removeAll(insertjobs);

            Iterator<Region> itr = regionValue.iterator();
            while (itr.hasNext()) {
                Region REGION = itr.next();
                System.out.println(REGION.getRegionId());
                String sql = "SET FOREIGN_KEY_CHECKS=0;";
                statement.execute(sql);

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
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(sql);

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
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(sql);

            String deletesql = "DELETE FROM REGION WHERE REGION_ID = "
                    +  REGION.getRegionId() + " ;";
            System.out.println(deletesql);
            statement.executeUpdate(deletesql);

            CustomServletContext.servletContext.setAttribute("REGION", selectRegion());

        } catch (SQLException e) {
            System.out.println("Problems with deleteRegion " + e);
        }
    }
}
