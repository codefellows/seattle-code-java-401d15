package com.zork.zork_demo.models;
// TODO: Step 2-1: Make a data class

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Pokeman {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    private String name;
    // change to enum of types
    private PokemanTypeEnum type;
    private Integer height;
    private java.util.Date dateCreated;

    public Pokeman(String name, PokemanTypeEnum type, Integer height, Date dateCreated) {
        this.name = name;
        this.type = type;
        this.height = height;
        this.dateCreated = dateCreated;
    }

    public Pokeman() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemanTypeEnum getType() {
        return type;
    }

    public void setType(PokemanTypeEnum type) {
        this.type = type;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public enum PokemanTypeEnum {
        WATER("Water"),
        ELECTRIC("Electric"),
        ROCK("Rock"),
        PSYCHIC("Psychic"),
        FIRE("Fire"),
        GRASS("Grass");

    private final String pokemanType;

    PokemanTypeEnum(String _pokemanType){
        this.pokemanType = _pokemanType;
    }

        public String getPokemanType() {
            return pokemanType;
        }

        public static PokemanTypeEnum fromString(String possiblePokemanType){
        for (PokemanTypeEnum type : PokemanTypeEnum.values()){
            if (type.pokemanType.equals(possiblePokemanType)){
                return type;
            }
        }
        return null;
        }

        @NonNull
        @Override
        public String toString() {
            if(pokemanType == null){
                return "";
            }
            return pokemanType;
        }

    }


}
