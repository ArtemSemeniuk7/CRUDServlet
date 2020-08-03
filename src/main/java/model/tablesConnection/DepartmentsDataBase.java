package model.tablesConnection;

import model.DataBaseConnector;
import model.tables.Departments;
import servlets.CustomServletContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class DepartmentsDataBase {
    static Statement statement = DataBaseConnector.getStatement();
    public HashMap<Integer, Departments> createDepartments(){
        return selectDepartments();
    }

    public static HashMap<Integer, Departments> selectDepartments() {
        ResultSet resultSet = null;
        HashMap<Integer, Departments> map = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + "DEPARTMENTS");
            map = new HashMap<>();
            while (resultSet.next()) {
                map.put(resultSet.getInt("DEPARTMENT_ID"),
                        new Departments(resultSet.getInt("DEPARTMENT_ID"),
                        resultSet.getString("DEPARTMENT_NAME"),
                        resultSet.getInt("MANAGER_ID"),
                        resultSet.getInt("LOCATION_ID")));
            }
        } catch (SQLException e) {
            System.out.println("Problems with selectDepartments " + e);
        }
        return map;
    }

    public static void insertDepartments(HashMap<Integer, Departments> table){
        try {
            HashSet<Departments> departmentsValue = new HashSet<>(table.values());
            HashMap<Integer, Departments> insertmap = selectDepartments();

            HashSet<Departments> insertjobs = new HashSet<>(insertmap.values());
            departmentsValue.removeAll(insertjobs);

            Iterator<Departments> itr = departmentsValue.iterator();
            while (itr.hasNext()) {
                Departments DEPARTMENTS = itr.next();

                String sql = "SET FOREIGN_KEY_CHECKS=0;";
                statement.execute(sql);

                String insertsql = "INSERT INTO " + "DEPARTMENTS" +
                        " (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) " +
                        " VALUES" + " ( " + DEPARTMENTS.getDEPARTMENT_ID() + ", " +
                        "'" + DEPARTMENTS.getDEPARTMENT_NAME() + "'" +
                        ", " + DEPARTMENTS.getMANAGER_ID() + ", " + DEPARTMENTS.getLOCATION_ID() + ");";
                System.out.println(insertsql);
                statement.executeUpdate(insertsql);
            }
        } catch (SQLException e) {
            System.out.println("Problems with insertDepartments " + e);
        }
    }

    public static void updateDepartments(Departments DEPARTMENTS){
        try {
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(sql);

            String updatesql = "UPDATE DEPARTMENTS SET" +
                    " DEPARTMENT_ID = " + DEPARTMENTS.getDEPARTMENT_ID() +
                    ", DEPARTMENT_NAME = '" + DEPARTMENTS.getDEPARTMENT_NAME() +
                    "', MANAGER_ID = " + DEPARTMENTS.getMANAGER_ID() +
                    ", LOCATION_ID = " +  DEPARTMENTS.getLOCATION_ID() +
                    " WHERE DEPARTMENT_ID = " + DEPARTMENTS.getDEPARTMENT_ID() + "; ";
            System.out.println(updatesql);
            statement.executeUpdate(updatesql);

        } catch (SQLException e) {
            System.out.println("Problems with updateDepartments " + e);
        }
    }

    public static void deleteDepartments(Departments DEPARTMENTS){
        try {
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(sql);

            String deletesql = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = "
                    +  DEPARTMENTS.getDEPARTMENT_ID() + " ;";
            System.out.println(deletesql);
            statement.executeUpdate(deletesql);

            CustomServletContext.servletContext.setAttribute("DEPARTMENTS", selectDepartments());

        } catch (SQLException e) {
            System.out.println("Problems with deleteDepartments " + e);
        }
    }
}
