package com.zork.zork_demo.models;
// TODO: Step 2-1: Make a data class
public class Pokeman {

    private String name;
    private String type;

    public Pokeman(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
