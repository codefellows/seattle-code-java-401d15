package com.codefellows.salmonCookiesd15.controllers;

import com.codefellows.salmonCookiesd15.models.SalmonCookieStore;
import com.codefellows.salmonCookiesd15.repositories.SalmonCookiesStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

//TODO: Add Controller annotation
@Controller
public class SalmonCookieStoreController {
    //TODO: WIRE up the repo with @Autowired
    @Autowired
    SalmonCookiesStoreRepository salmonCookiesStoreRepository;

    // GET method to "/"
        // return stores to the thymeleaf template
    @GetMapping("/")
    public String getSalmonCookieStores(Model m){
//        SalmonCookieStore bestStore = new SalmonCookieStore("Zorks", 200);
//        SalmonCookieStore worstStore = new SalmonCookieStore("PArdus", 10);
//
//        ArrayList<SalmonCookieStore> stores = new ArrayList<>();
//        stores.add(bestStore);
//        stores.add(worstStore);
        List<SalmonCookieStore> stores = salmonCookiesStoreRepository.findAll();
        m.addAttribute("stores", stores);

        return "salmon-cookies/salmon-cookie-stores";
    }

    // POST method to "/"
        // create an item in the DB
    @PostMapping("/")
    public RedirectView createSalmonCookieStore(String name, Integer averageCookiesPerDay){
        SalmonCookieStore newStore = new SalmonCookieStore(name, averageCookiesPerDay);
        salmonCookiesStoreRepository.save(newStore);
        return new RedirectView("/");
    }
}
