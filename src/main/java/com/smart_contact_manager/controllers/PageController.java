package com.smart_contact_manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart_contact_manager.entities.User;
import com.smart_contact_manager.forms.UserForm;
import com.smart_contact_manager.services.UserService;

@Controller
public class PageController {

    @Autowired
    private UserService userService;
    
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
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
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

    //registering a user
    @PostMapping("/do-register")
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("Registering the user");
        //fetch the form data 
        //UserForm
        System.out.println(userForm.getName());
        // validate 
        
        // save the user
        // convert data from userForm to User
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png");

        User saveUser = userService.saveUser(user);
        System.out.println("User Saved");
        return "redirect:/register";
    }

    
    
}
