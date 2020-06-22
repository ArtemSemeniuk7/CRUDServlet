package model.tables;

import java.util.Objects;

public class Region {
    private int regionId;
    private String regionName;

    public Region(int regionId) {
        this.regionId = regionId;
    }

    public Region(int regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return regionId == region.regionId &&
                Objects.equals(regionName, region.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionId, regionName);
    }
}
