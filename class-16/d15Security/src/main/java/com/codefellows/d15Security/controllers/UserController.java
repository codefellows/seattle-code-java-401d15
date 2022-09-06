package com.codefellows.d15Security.controllers;

//TODO: Step 2: Make a controller
// Don't forget @Controller anno

import com.codefellows.d15Security.models.SiteUser;
import com.codefellows.d15Security.repositories.SiteUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class UserController {
    // Autowire user repo
    @Autowired
    SiteUserRepo siteUserRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    HttpServletRequest request;

    // GET ROUTES

    // Step 8: Make a home page
    @GetMapping("/")
    public String getHomePage(Principal p, Model m)
    {
        if (p != null)
        {
            String username = p.getName();
            SiteUser dinoUser = siteUserRepo.findByUsername(username);

            m.addAttribute("username", username);
            m.addAttribute("nickname", dinoUser.getNickname());
        }

        return "index.html";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/signup")
    public String getSignupPage(){
        return "signup";
    }

    @GetMapping("/sauce")
    public String getSecretSauce(){
        return "secretSauce";
    }


    @PostMapping("/test")
    public RedirectView testUser(){
        String hashedPassword = passwordEncoder.encode("password");
        SiteUser newUser = new SiteUser("lemi", hashedPassword, "Pound Cake");
        siteUserRepo.save(newUser);
        return new RedirectView("/");
    }

    //POST ROUTES
    // signup
    @PostMapping("/signup")
    public RedirectView createUser(String username, String nickname, String password){
        String hashedPassword = passwordEncoder.encode(password);
        SiteUser newUser = new SiteUser(username, hashedPassword, nickname);
        siteUserRepo.save(newUser);
        // pre auth with HttpServletReq
        authWithHttpServletRequest(username, password);
        return new RedirectView("/");
    }

    public void authWithHttpServletRequest(String username, String password){
        try {
            request.login(username, password);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
