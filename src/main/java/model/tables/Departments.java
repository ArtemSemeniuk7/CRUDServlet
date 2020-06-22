package model.tables;

import java.util.Objects;

public class Departments {
    private int DEPARTMENT_ID;
    private String DEPARTMENT_NAME;
    private int MANAGER_ID;
    private int LOCATION_ID;

    public Departments(int DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }

    public Departments(int DEPARTMENT_ID, String DEPARTMENT_NAME, int MANAGER_ID, int LOCATION_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
        this.DEPARTMENT_NAME = DEPARTMENT_NAME;
        this.MANAGER_ID = MANAGER_ID;
        this.LOCATION_ID = LOCATION_ID;

    }

    public int getDEPARTMENT_ID() {
        return DEPARTMENT_ID;
    }

    public void setDEPARTMENT_ID(int DEPARTMENT_ID) {
        this.DEPARTMENT_ID = DEPARTMENT_ID;
    }

    public String getDEPARTMENT_NAME() {
        return DEPARTMENT_NAME;
    }

    public void setDEPARTMENT_NAME(String DEPARTMENT_NAME) {
        this.DEPARTMENT_NAME = DEPARTMENT_NAME;
    }

    public int getLOCATION_ID() {
        return LOCATION_ID;
    }

    public void setLOCATION_ID(int LOCATION_ID) {
        this.LOCATION_ID = LOCATION_ID;
    }

    public int getMANAGER_ID() {
        return MANAGER_ID;
    }

    public void setMANAGER_ID(int MANAGER_ID) {
        this.MANAGER_ID = MANAGER_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return DEPARTMENT_ID == that.DEPARTMENT_ID &&
                MANAGER_ID == that.MANAGER_ID &&
                LOCATION_ID == that.LOCATION_ID &&
                DEPARTMENT_NAME.equals(that.DEPARTMENT_NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID);
    }
}
