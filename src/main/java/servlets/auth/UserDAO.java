package servlets.auth;

import model.DataBaseConnector;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
     static Statement statement = DataBaseConnector.getStatement();
     public static boolean selectUser(String user, String password){
          if (user.equals("") && password.equals(""))
               return false;
          String selectUser = "SELECT * FROM users WHERE user = " + "'" + user + "';";
          try {
               ResultSet resultSet = statement.executeQuery(selectUser);
               while (resultSet.next()) {
                    if (password.equals(resultSet.
                            getString("password"))){
                         return true;
                    }
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
          return false;
     }

     public static boolean signIn(String user, String password){
          if (user.equals("") && password.equals(""))
               return false;
          try {
               String insert = "INSERT INTO users (user, password) VALUES ('" +
                       user + "', '" + password + "');";
               statement.executeUpdate(insert);
               return true;
          } catch (Exception e){
               System.out.println("Problem with sign in " + e);
               return false;
          }
     }
}
