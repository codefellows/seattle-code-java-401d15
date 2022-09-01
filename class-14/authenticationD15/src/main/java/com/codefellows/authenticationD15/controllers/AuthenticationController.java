package com.codefellows.authenticationD15.controllers;

import org.mindrot.jbcrypt.BCrypt;
import com.codefellows.authenticationD15.models.SiteUser;
import com.codefellows.authenticationD15.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    // Get /login
    @GetMapping("/login")
    public String getLoginPage(){
        return "/login.html";
    }

    // Get signup
    @GetMapping("/signup")
    public String getSignupPage(){
        return "/signup.html";
    }

    @GetMapping("/loginWithSecret")
    public String getLoginPageWithSecret()
    {
        return "/loginWithSecret.html";
    }

    // Post login
    @PostMapping("/login")
    public RedirectView logInUser(String username, String password){
        SiteUser userFromDb = userRepository.findByUsername(username);
        if((userFromDb == null) || (!BCrypt.checkpw(password, userFromDb.getPassword()))){
            return new RedirectView("/login");
        }
        return new RedirectView("/");
  //OLD WAY - NOT SECURE!
//        if (userFromDb.getPassword().equals(password)){
//            return new RedirectView("/");
//        } else {
//            return new RedirectView("/login");
//        }

    }

    //POST loginWithSecret THIS WAS AFTER OUR IN CLASS DEMO
    @PostMapping("/loginWithSecret")
    public RedirectView logInUserWithSecret(HttpServletRequest request, String username, String password){
        SiteUser userFromDb = userRepository.findByUsername(username);
        if ((userFromDb == null)
                || (!BCrypt.checkpw(password, userFromDb.getPassword())))
        {
            return new RedirectView("/loginWithSecret");
        }

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        return new RedirectView("/withSecret");

    }
    //POST logoutWithSecret THIS WAS AFTER OUR IN CLASS DEMO
    @PostMapping("/logoutWithSecret")
    public RedirectView logOutUserWithSecret(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.invalidate();

        return new RedirectView("/loginWithSecret");
    }

    // POST signup
    @PostMapping("/signup")
    public RedirectView signUpUser(String username, String password){
        //hash given PW
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        // create new user with given credentials(hashed PW)
        SiteUser newUser = new SiteUser(username, hashedPassword);
        // save the user to the DB --> UserRepo
        userRepository.save(newUser);
        return new RedirectView("/login");
    }

}
