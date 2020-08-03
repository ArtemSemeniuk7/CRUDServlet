package model.tables;

import java.util.Objects;

public class Countries {
    private int COUNTRY_ID;
    private String COUNTRY_NAME;
    private int REGION_ID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Countries countries = (Countries) o;
        return COUNTRY_ID == countries.COUNTRY_ID &&
                REGION_ID == countries.REGION_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(COUNTRY_ID, REGION_ID);
    }

    public Countries(int COUNTRY_ID) {
        this.COUNTRY_ID = COUNTRY_ID;
    }

    public Countries(int COUNTRY_ID, String COUNTRY_NAME, int REGION_ID) {
        this.COUNTRY_ID = COUNTRY_ID;
        this.COUNTRY_NAME = COUNTRY_NAME;
        this.REGION_ID = REGION_ID;
    }

    public int getCOUNTRY_ID() {
        return COUNTRY_ID;
    }

    public void setCOUNTRY_ID(int COUNTRY_ID) {
        this.COUNTRY_ID = COUNTRY_ID;
    }

    public String getCOUNTRY_NAME() {
        return COUNTRY_NAME;
    }

    public void setCOUNTRY_NAME(String COUNTRY_NAME) {
        this.COUNTRY_NAME = COUNTRY_NAME;
    }

    public int getREGION_ID() {
        return REGION_ID;
    }

    public void setREGION_ID(int REGION_ID) {
        this.REGION_ID = REGION_ID;
    }
}
