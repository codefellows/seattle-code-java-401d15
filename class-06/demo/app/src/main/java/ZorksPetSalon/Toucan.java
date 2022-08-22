package ZorksPetSalon;

public class Toucan extends Animal implements FlyingAnimals{

    public Toucan(int eyes, int legs, boolean canFly, String name, String color) {
        super(eyes, legs, canFly, name, color);
    }

    @Override
    public String fly() {
        System.out.println("TUCI TUCI, FLAP FLAP");
        return "Tuci Tuci";
    }
}
