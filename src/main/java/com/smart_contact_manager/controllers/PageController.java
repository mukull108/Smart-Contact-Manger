package com.smart_contact_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    
    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("home page handler");
        model.addAttribute("name", "Mukul Savita ");
        model.addAttribute("add", "Water works bhind");
        return "home";
    }
}
