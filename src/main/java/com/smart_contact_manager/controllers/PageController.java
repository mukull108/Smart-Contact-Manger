package com.smart_contact_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class PageController {
    
    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("home page handler");
        model.addAttribute("name", "Mukul Savita ");
        model.addAttribute("add", "Water works bhind");
        return "home";
    }

    //about
    @RequestMapping("/about")
    public String about(){
        System.out.println("about page is loading");
        return "about";
    }

    //services
    @RequestMapping("/services")
    public String services() {
        System.out.println("services page loading");
        return "services";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/login")
    public String login() {
        return "Login";
    }
    

    @RequestMapping("/contact")
    public String contact() {
        System.out.println("Contact page loading");
        return "contact";
    }
    
    
}
