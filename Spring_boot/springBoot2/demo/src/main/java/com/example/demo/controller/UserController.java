package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import com.example.demo.entity.User;



@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private User user;
    
    @RequestMapping("/info")
    @ResponseBody
    public String showUserInfo(){
        String html = "";
        html += "<h1> Nombre: " + user.getName() + "</h1>";
        html += "<h1> Email: " + user.getEmail() + "</h1>";
        html += "<h1> Age: " + user.getAge() + "</h1>";
        
        return html;
    }

    @RequestMapping("/info2")
    public String showUserInfo(Model model){
        model.addAttribute("user", user);
        return "user_data";
        }
    

    
}
