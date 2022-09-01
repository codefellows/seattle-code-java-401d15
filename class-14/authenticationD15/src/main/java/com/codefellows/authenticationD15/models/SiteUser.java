package com.codefellows.authenticationD15.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String username;
    private String password;

    public SiteUser() {
    }

    public SiteUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
