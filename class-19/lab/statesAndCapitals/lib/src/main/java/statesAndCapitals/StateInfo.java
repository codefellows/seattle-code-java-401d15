package statesAndCapitals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class StateInfo
{
    private String stateName;
    private ArrayList<String> denonyms;
    private LocalDate dateAdmittedToUnion;
    private ArrayList<String> timeZones;
    private int highestElevationInFeet;
    private int lowestElevationInFeet;
    private int areaInSquareMiles;
    private String stateBird;
    private String stateFlower;
    private String stateMotto;
    private ArrayList<String> stateNicknames;
    private String stateAnthem;
    private String stateTree;
    private ArrayList<String> neighboringStates;
    private CapitalInfo capital;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateInfo stateInfo = (StateInfo) o;
        return highestElevationInFeet == stateInfo.highestElevationInFeet && lowestElevationInFeet == stateInfo.lowestElevationInFeet && areaInSquareMiles == stateInfo.areaInSquareMiles && Objects.equals(stateName, stateInfo.stateName) && Objects.equals(denonyms, stateInfo.denonyms) && Objects.equals(dateAdmittedToUnion, stateInfo.dateAdmittedToUnion) && Objects.equals(timeZones, stateInfo.timeZones) && Objects.equals(stateBird, stateInfo.stateBird) && Objects.equals(stateFlower, stateInfo.stateFlower) && Objects.equals(stateMotto, stateInfo.stateMotto) && Objects.equals(stateNicknames, stateInfo.stateNicknames) && Objects.equals(stateAnthem, stateInfo.stateAnthem) && Objects.equals(stateTree, stateInfo.stateTree) && Objects.equals(neighboringStates, stateInfo.neighboringStates) && Objects.equals(capital, stateInfo.capital);
    }

    @Override
    public String toString()
    {
        return "StateInfo{" +
                "stateName='" + stateName + '\'' +
                ", denonyms=" + denonyms +
                ", dateAdmittedToUnion=" + dateAdmittedToUnion +
                ", timeZones=" + timeZones +
                ", highestElevationInFeet=" + highestElevationInFeet +
                ", lowestElevationInFeet=" + lowestElevationInFeet +
                ", areaInSquareMiles=" + areaInSquareMiles +
                ", stateBird='" + stateBird + '\'' +
                ", stateFlower='" + stateFlower + '\'' +
                ", stateMotto='" + stateMotto + '\'' +
                ", stateNicknames=" + stateNicknames +
                ", stateAnthem='" + stateAnthem + '\'' +
                ", stateTree='" + stateTree + '\'' +
                ", neighboringStates=" + neighboringStates +
                ", capital=" + capital +
                '}';
    }

    public String getStateName()
    {
        return stateName;
    }

    public ArrayList<String> getDenonyms()
    {
        return denonyms;
    }

    public LocalDate getDateAdmittedToUnion()
    {
        return dateAdmittedToUnion;
    }

    public ArrayList<String> getTimeZones()
    {
        return timeZones;
    }

    public int getHighestElevationInFeet()
    {
        return highestElevationInFeet;
    }

    public int getLowestElevationInFeet()
    {
        return lowestElevationInFeet;
    }

    public int getAreaInSquareMiles()
    {
        return areaInSquareMiles;
    }

    public String getStateBird()
    {
        return stateBird;
    }

    public String getStateFlower()
    {
        return stateFlower;
    }

    public String getStateMotto()
    {
        return stateMotto;
    }

    public ArrayList<String> getStateNicknames()
    {
        return stateNicknames;
    }

    public String getStateAnthem()
    {
        return stateAnthem;
    }

    public String getStateTree()
    {
        return stateTree;
    }

    public ArrayList<String> getNeighboringStates()
    {
        return neighboringStates;
    }

    public CapitalInfo getCapital()
    {
        return capital;
    }
}
