package model.tablesConnection;

import model.DataBaseConnector;
import model.tables.Jobs;
import servlets.CustomServletContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class JobsDataBase {
    static Statement statement = DataBaseConnector.getStatement();
    public HashMap<Integer, Jobs> createJobs(){
        return selectJobs();
    }

    public static HashMap<Integer, Jobs> selectJobs() {
        ResultSet resultSet = null;
        HashMap<Integer, Jobs> map = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + "JOBS");
            map = new HashMap<>();
            while (resultSet.next()) {
                map.put(resultSet.getInt("JOBS_ID"), new Jobs(resultSet.getInt("JOBS_ID"),
                        resultSet.getString("JOBS_TITLE"),
                        resultSet.getInt("MIN_SALARY"),
                        resultSet.getInt("MAX_SALARY")));
            }
        } catch (SQLException e) {
            System.out.println("Problems with selectJobs " + e);
        }
        return map;
    }

    public static void insertJobs(HashMap<Integer, Jobs> table){
        try {
            HashSet<Jobs> jobsValue = new HashSet<>(table.values());
            HashMap<Integer, Jobs> insertmap = selectJobs();

            HashSet<Jobs> insertjobs = new HashSet<>(insertmap.values());
            jobsValue.removeAll(insertjobs);

            Iterator<Jobs> itr = jobsValue.iterator();
            while (itr.hasNext()) {
                Jobs JOBS = itr.next();
                System.out.println(JOBS.getJOBS_ID());
                String insertsql = "INSERT INTO " + "JOBS" +
                        " (JOBS_ID, JOBS_TITLE, MIN_SALARY, MAX_SALARY) " +
                        " VALUES" + " ( " + JOBS.getJOBS_ID() + ", " + "'" + JOBS.getJOBS_TITLE() + "'" +
                        ", " + JOBS.getMIN_SALARY() + ", " + JOBS.getMAX_SALARY() + ");";
                statement.executeUpdate(insertsql);
            }
        } catch (SQLException e) {
            System.out.println("Problems with insertJobs " + e);
        }
    }

    public static void updateJobs(Jobs JOBS){
        try {
            String updatesql = "UPDATE JOBS SET" +
                    " JOBS_ID = " + JOBS.getJOBS_ID() + ", JOBS_TITLE = '" + JOBS.getJOBS_TITLE() +
                    "', MIN_SALARY = " + JOBS.getMIN_SALARY() + ", MAX_SALARY = " +  JOBS.getMAX_SALARY() +
                    " WHERE JOBS_ID = " + JOBS.getJOBS_ID() + "; ";
            System.out.println(updatesql);
            statement.executeUpdate(updatesql);

        } catch (SQLException e) {
            System.out.println("Problems with updateJobs " + e);
        }
    }

    public static void deleteJobs(Jobs JOBS){
        try {
            String deletesql = "DELETE FROM JOBS WHERE JOBS_ID = "
                    +  JOBS.getJOBS_ID() + " ;";
            System.out.println(deletesql);
            statement.executeUpdate(deletesql);
            CustomServletContext.servletContext.setAttribute("JOBS", selectJobs());
        } catch (SQLException e) {
            System.out.println("Problems with deleteJobs " + e);
        }
    }
}
