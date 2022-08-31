package com.codefellows.salmonCookiesd15.models;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String name;
    private Float payPerHour;

    // Annotation for one to many
    @ManyToOne
    SalmonCookieStore myStore;

    protected Employee() {
    }

    public Employee(String name, Float payPerHour, SalmonCookieStore myStore) {
        this.name = name;
        this.payPerHour = payPerHour;
        this.myStore = myStore;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(Float payPerHour) {
        this.payPerHour = payPerHour;
    }

    public SalmonCookieStore getMyStore() {
        return myStore;
    }

    public void setMyStore(SalmonCookieStore myStore) {
        this.myStore = myStore;
    }
}
