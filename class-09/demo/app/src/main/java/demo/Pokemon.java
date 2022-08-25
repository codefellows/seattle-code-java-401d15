package demo;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int id;
    private ArrayList<TypeWrapper> types;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<TypeWrapper> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<TypeWrapper> types) {
        this.types = types;
    }
}
