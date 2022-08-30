package com.codefellows.salmonCookiesd15.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//TODO: Step 1: ADD Entity anontation to the class! This will turn it into a DB model!
@Entity
public class SalmonCookieStore {
    //TODO: Step 2: Add Id and GeneratedValue annotations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    //IF you need longer than 255 characters, use these 2 annotations
    // @Lob
    // @Type(type = "org.hibernate.type.TextType")

     private String name;
     private Integer averageCookiesPerDay;

    protected SalmonCookieStore() {
    }

    public SalmonCookieStore(String name, Integer averageCookiesPerDay) {
        this.name = name;
        this.averageCookiesPerDay = averageCookiesPerDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverageCookiesPerDay() {
        return averageCookiesPerDay;
    }

    public void setAverageCookiesPerDay(Integer averageCookiesPerDay) {
        this.averageCookiesPerDay = averageCookiesPerDay;
    }
}
