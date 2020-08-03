package model.tablesConnection;

import model.DataBaseConnector;
import model.tables.Employees;
import servlets.CustomServletContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class EmployeeDataBase {
    static Statement statement = DataBaseConnector.getStatement();
    public HashMap<Integer, Employees> createEmployees(){
        return selectEmployees();
    }

    public static HashMap<Integer, Employees> selectEmployees() {
        ResultSet resultSet = null;
        HashMap<Integer, Employees> map = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + "EMPLOYEES");
            map = new HashMap<>();
            while (resultSet.next()) {
                map.put(resultSet.getInt("EMPLOYEE_ID"),
                        new Employees(resultSet.getInt("EMPLOYEE_ID"),
                                resultSet.getString("FIRST_NAME"),
                                resultSet.getString("LAST_NAME"),
                                resultSet.getString("EMAIL"),
                                resultSet.getString("HIRE_DATE"),
                                resultSet.getInt("PHONE"),
                                resultSet.getInt("SALARY"),
                                resultSet.getInt("DEPARTMENT_ID")));
            }
        } catch (SQLException e) {
            System.out.println("Problems with selectEmployees " + e);
        }
        return map;
    }

    public static void insertEmployees(HashMap<Integer, Employees> table){
        try {
            HashSet<Employees> employeesValue = new HashSet<>(table.values());
            HashMap<Integer, Employees> insertmap = selectEmployees();

            HashSet<Employees> insertEmployees = new HashSet<>(insertmap.values());
            employeesValue.removeAll(insertEmployees);

            Iterator<Employees> itr = employeesValue.iterator();

            while (itr.hasNext()) {
                Employees EMPLOYEES = itr.next();
                String sql = "SET FOREIGN_KEY_CHECKS=0;";
                statement.execute(sql);

                String insertsql = "INSERT INTO " + "EMPLOYEES" +
                        " (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, " +
                        "HIRE_DATE, PHONE, SALARY, DEPARTMENT_ID) " +
                        " VALUES" + " ( " + EMPLOYEES.getEMPLOYEE_ID() + ", " +
                        "'" + EMPLOYEES.getFIRST_NAME() + "'" +
                        ", " + EMPLOYEES.getLAST_NAME() +
                        ", " + EMPLOYEES.getEMAIL() +
                        ", " + EMPLOYEES.getHIRE_DATE() +
                        ", " + EMPLOYEES.getPHONE() +
                        ", " + EMPLOYEES.getSALARY() +
                        ", " + EMPLOYEES.getDEPARTMENT_ID() + ");";
                System.out.println(insertsql);
                statement.executeUpdate(insertsql);
            }
        } catch (Exception e) {
            System.out.println("Problems with insertEmployees " + e);
        }
    }

    public static void updateEmployees(Employees EMPLOYEES){
        try {
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(sql);

            String updatesql = "UPDATE EMPLOYEES SET" +
                    " EMPLOYEE_ID = " + EMPLOYEES.getEMPLOYEE_ID() +
                    ", FIRST_NAME = '" + EMPLOYEES.getFIRST_NAME() +
                    "', LAST_NAME = " + EMPLOYEES.getLAST_NAME() +
                    ", EMAIL = " +  EMPLOYEES.getEMAIL() +
                    " HIRE_DATE = " + EMPLOYEES.getHIRE_DATE() +
                    ", PHONE = '" + EMPLOYEES.getPHONE() +
                    "', SALARY = " + EMPLOYEES.getSALARY() +
                    ", DEPARTMENT_ID = " +  EMPLOYEES.getDEPARTMENT_ID() +
                    " WHERE EMPLOYEE_ID = " + EMPLOYEES.getEMPLOYEE_ID() + "; ";
            System.out.println(updatesql);
            statement.executeUpdate(updatesql);

        } catch (SQLException e) {
            System.out.println("Problems with updateEmployee " + e);
        }
    }

    public static void deleteEmployees(Employees EMPLOYEES){
        try {
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(sql);

            String deletesql = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = "
                    +  EMPLOYEES.getEMPLOYEE_ID() + " ;";
            System.out.println(deletesql);
            statement.executeUpdate(deletesql);

            CustomServletContext.servletContext.setAttribute("EMPLOYEES", selectEmployees());

        } catch (SQLException e) {
            System.out.println("Problems with deleteEmployees " + e);
        }
    }
}