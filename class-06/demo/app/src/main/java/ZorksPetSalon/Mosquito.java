package ZorksPetSalon;

import ZorksCrematorium.Morgue;

public class Mosquito extends Animal implements FlyingAnimals, MoltingAnimals{

    public Mosquito(int eyes, int legs, boolean canFly, String name, String color) {
        super(eyes, legs, canFly, name, color);
    }

    public void die(){
        System.out.println("SPLAT");
    }

    @Override
    public String fly() {
        System.out.println("BUZZ BUZZ BITE");
        return "I am death";
    }

    @Override
    public void molt() {

    }
}
