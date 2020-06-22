package model.tables;

import java.util.Objects;

public class Jobs implements Table {
    private int JOBS_ID;
    private String JOBS_TITLE;
    private int MIN_SALARY;
    private int MAX_SALARY;

    public Jobs(int JOBS_ID) {
        this.JOBS_ID = JOBS_ID;
    }
    public Jobs(int JOBS_ID, String JOBS_TITLE, int MIN_SALARY, int MAX_SALARY) {
        this.JOBS_ID = JOBS_ID;
        this.JOBS_TITLE = JOBS_TITLE;
        this.MIN_SALARY = MIN_SALARY;
        this.MAX_SALARY = MAX_SALARY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jobs jobs = (Jobs) o;
        return JOBS_ID == jobs.JOBS_ID &&
                Objects.equals(JOBS_TITLE, jobs.JOBS_TITLE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(JOBS_ID, JOBS_TITLE);
    }

    public int getJOBS_ID() {
        return JOBS_ID;
    }

    public void setJOBS_ID(int JOBS_ID) {
        this.JOBS_ID = JOBS_ID;
    }

    public String getJOBS_TITLE() {
        return JOBS_TITLE;
    }

    public void setJOBS_TITLE(String JOBS_TITLE) {
        this.JOBS_TITLE = JOBS_TITLE;
    }

    public int getMIN_SALARY() {
        return MIN_SALARY;
    }

    public void setMIN_SALARY(int MIN_SALARY) {
        this.MIN_SALARY = MIN_SALARY;
    }

    public int getMAX_SALARY() {
        return MAX_SALARY;
    }

    public void setMAX_SALARY(int MAX_SALARY) {
        this.MAX_SALARY = MAX_SALARY;
    }
}
