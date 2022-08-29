package com.zorkmaster.demo11.controllers;

//USE ANNOTATIONS!!!

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class HelloController {

    // a home route
    // ye old route creation way
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String getTest(){
        return "I am the Zork";
    }

    @GetMapping("/hi")
    public String getHi(){
        // IF NO REsponseBody, will render the template matching the returned string
        return "hello";
    }

    @PostMapping("/hi")

    // route with URL params
    @GetMapping("/sayhello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello " + name;
    }

    // route with URL params using a Spring model(not Model from MVC)
    @GetMapping("/model/{name}")
    public String modelMe(@PathVariable String name, Model m){


        m.addAttribute("name", name);
        m.addAttribute("Age", 70);
        return "friends/newFriend";
    }

}
