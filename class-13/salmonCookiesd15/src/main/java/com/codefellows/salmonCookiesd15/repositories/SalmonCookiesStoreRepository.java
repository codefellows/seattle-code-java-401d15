package com.codefellows.salmonCookiesd15.repositories;

import com.codefellows.salmonCookiesd15.models.SalmonCookieStore;
import org.springframework.data.jpa.repository.JpaRepository;

// make a repo for the data value. THIS IS A SERVICE - Singelton design principle == SPRING BEAN!!
//TODO: extend our JpaRepo and give it types. Model and a Long(id)
public interface SalmonCookiesStoreRepository extends JpaRepository<SalmonCookieStore, Long> {
    // The reason we are using an interface, is so we can create CUSTOM CRUD queries

    // DARK MAGIC that we made happen with a specific function name
    public SalmonCookieStore findByName(String name);
    public SalmonCookieStore findByAverageCookiesPerDay(int averageCookiesPerDay);
}
