package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/world")
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello_world";


    }

    @GetMapping("/bye")
    public String byeWorld(){
        return "bye_world";
    }
    


}
