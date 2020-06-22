package model.tablesConnection;

import model.DataBaseConnector;
import model.tables.Countries;
import servlets.CustomServletContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CountryDataBase {
    static Statement statement = DataBaseConnector.getStatement();

    public HashMap<Integer, Countries> createCountry(){
        return selectCountries();
    }

    public static HashMap<Integer, Countries> selectCountries() {
        ResultSet resultSet = null;
        HashMap<Integer, Countries> map = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + "COUNTRIES");
            map = new HashMap<>();
            while (resultSet.next()) {
                map.put(resultSet.getInt("COUNTRY_ID"), new Countries(resultSet.getInt("COUNTRY_ID"),
                        resultSet.getString("COUNTRY_NAME"),
                        resultSet.getInt("REGION_ID")));
            }
        } catch (SQLException e) {
            System.out.println("Problems with select selectCountry " + e);
        }
        return map;
    }

    public static void insertCountries(HashMap<Integer, Countries> table){
        try {
            HashSet<Countries> countriesValue = new HashSet<>(table.values());
            HashMap<Integer, Countries> insertCountriesMap = selectCountries();
            HashSet<Countries> insertCountriesSet = new HashSet<>(insertCountriesMap.values());
            countriesValue.removeAll(insertCountriesSet);
            Iterator<Countries> itr = countriesValue.iterator();
            while (itr.hasNext()) {
                Countries COUNTRIES = itr.next();
                System.out.println(COUNTRIES.getCOUNTRY_ID());
                String insertsql = "INSERT INTO " + "COUNTRIES" +
                        " (COUNTRY_ID, COUNTRY_NAME, REGION_ID) " +
                        " VALUES" + " ( " + COUNTRIES.getCOUNTRY_ID() + ", " + "'"
                        + COUNTRIES.getCOUNTRY_NAME() + "'" +
                        ", " + COUNTRIES.getREGION_ID() + ");";
                String sql = "SET FOREIGN_KEY_CHECKS=0;";
                statement.execute(sql);
                statement.executeUpdate(insertsql);
            }
        } catch (SQLException e) {
            System.out.println("Problems with insertCountries " + e);
        }
    }

    public static void updateCountries(HashMap<Integer, Countries> table){
        try {
            ArrayList<Countries> list = new ArrayList<>(table.values());
            Countries COUNTRIES = list.get(0);
            String updatesql = "UPDATE COUNTRIES SET" +
                    " COUNTRY_ID = " + COUNTRIES.getCOUNTRY_ID() +
                    ", COUNTRY_NAME = '" + COUNTRIES.getCOUNTRY_NAME() +
                    "', REGION_ID = " + COUNTRIES.getREGION_ID() +
                    " WHERE COUNTRY_ID = " + COUNTRIES.getCOUNTRY_ID() + "; ";
            System.out.println(updatesql);
            statement.executeUpdate(updatesql);

        } catch (SQLException e) {
            System.out.println("Problems with updateCountries " + e);
        }
    }

    public static void deleteCountries(HashMap<Integer, Countries> table){
        try {
            ArrayList<Countries> list = new ArrayList<>(table.values());
            Countries COUNTRIES = list.get(0);
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(sql);
            String deletesql = "DELETE FROM COUNTRIES WHERE COUNTRY_ID = "
                    +  COUNTRIES.getCOUNTRY_ID() + " ;";
            System.out.println(deletesql);
            statement.executeUpdate(deletesql);
            CustomServletContext.servletContext.setAttribute("COUNTRIES", selectCountries());
        } catch (SQLException e) {
            System.out.println("Problems with deleteCountries " + e);
        }
    }
}
