package ZorksPetSalon;

abstract class Animal {
    // STATIC FINAL props

    // Regular properties
    private int eyes;
    private int legs;
    private boolean canFly;
    private String name;
    private String color;

    // Constructor
    public Animal(int eyes, int legs, boolean canFly, String name, String color) {
        this.eyes = eyes;
        this.legs = legs;
        this.canFly = canFly;
        this.name = name;
        this.color = color;
    }

    // Custom Methods
    public void eat(){};

    public void poop(){};

    public void rest(){};

    public void makeNoise(){};

    // GETTERS AND SETTERS
    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
