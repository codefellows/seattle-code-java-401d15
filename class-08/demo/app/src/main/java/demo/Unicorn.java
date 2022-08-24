package demo;

import java.util.ArrayList;

public class Unicorn {
    private int hornLength;
    private boolean doesSparkle;
    private boolean canFly;
    private ArrayList<String> colors;

    public Unicorn(int hornLength, boolean doesSparkle, boolean canFly, ArrayList<String> colors) {
        this.hornLength = hornLength;
        this.doesSparkle = doesSparkle;
        this.canFly = canFly;
        this.colors = colors;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getHornLength() {
        return hornLength;
    }

    public void setHornLength(int hornLength) {
        this.hornLength = hornLength;
    }

    public boolean isDoesSparkle() {
        return doesSparkle;
    }

    public void setDoesSparkle(boolean doesSparkle) {
        this.doesSparkle = doesSparkle;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }
}
