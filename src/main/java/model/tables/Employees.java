package model.tables;

import model.DataBaseConnector;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employees {

    static Statement statement = DataBaseConnector.getStatement();

    private int EMPLOYEE_ID;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String EMAIL;
    private String HIRE_DATE;
    private int PHONE;
    private int SALARY;
    private int DEPARTMENT_ID;

    public Employees(int EMPLOYEE_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
    }

    public Employees(int EMPLOYEE_ID, String FIRST_NAME, String LAST_NAME, String EMAIL, String HIRE_DATE,
                     int PHONE, int SALARY, int DEPARTMENT_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.EMAIL = EMAIL;
        this.HIRE_DATE = HIRE_DATE;
        this.PHONE = PHONE;
        this.SALARY = SALARY;
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }
    public int getEMPLOYEE_ID() { return EMPLOYEE_ID; }

    public void setEMPLOYEE_ID(int EMPLOYEE_ID) { this.EMPLOYEE_ID = EMPLOYEE_ID; }

    public String getFIRST_NAME() { return FIRST_NAME; }

    public void setFIRST_NAME(String FIRST_NAME) { this.FIRST_NAME = FIRST_NAME; }

    public String getLAST_NAME() { return LAST_NAME; }

    public void setLAST_NAME(String LAST_NAME) { this.LAST_NAME = LAST_NAME; }

    public String getEMAIL() { return EMAIL; }

    public void setEMAIL(String EMAIL) { this.EMAIL = EMAIL; }

    public String getHIRE_DATE() { return HIRE_DATE; }

    public void setHIRE_DATE(String HIRE_DATE) { this.HIRE_DATE = HIRE_DATE; }

    public int getPHONE() { return PHONE; }

    public void setPHONE(int PHONE) { this.PHONE = PHONE; }

    public int getSALARY() { return SALARY; }

    public void setSALARY(int SALARY) { this.SALARY = SALARY; }

    public int getDEPARTMENT_ID() { return DEPARTMENT_ID; }

    public void setDEPARTMENT_ID(int DEPARTMENT_ID) { this.DEPARTMENT_ID = DEPARTMENT_ID; }
}
