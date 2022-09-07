package statesAndCapitals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class CapitalInfo
{
    private String capitalName;
    private String timeZone;
    private int elevationInFeet;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private int averageYearlyPrecipitationInInches;
    private ArrayList<String> sisterCities;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CapitalInfo that = (CapitalInfo) o;
        return elevationInFeet == that.elevationInFeet && averageYearlyPrecipitationInInches == that.averageYearlyPrecipitationInInches && Objects.equals(capitalName, that.capitalName) && Objects.equals(timeZone, that.timeZone) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude) && Objects.equals(sisterCities, that.sisterCities);
    }

    @Override
    public String toString()
    {
        return "CapitalInfo{" +
                "capitalName='" + capitalName + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", elevationInFeet=" + elevationInFeet +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", averageYearlyPrecipitationInInches=" + averageYearlyPrecipitationInInches +
                ", sisterCities=" + sisterCities +
                '}';
    }

    public String getCapitalName()
    {
        return capitalName;
    }

    public String getTimeZone()
    {
        return timeZone;
    }

    public int getElevationInFeet()
    {
        return elevationInFeet;
    }

    public BigDecimal getLatitude()
    {
        return latitude;
    }

    public BigDecimal getLongitude()
    {
        return longitude;
    }

    public int getAverageYearlyPrecipitationInInches()
    {
        return averageYearlyPrecipitationInInches;
    }

    public ArrayList<String> getSisterCities()
    {
        return sisterCities;
    }
}
