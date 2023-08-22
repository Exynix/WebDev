package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.StudentService;

@Controller 
@RequestMapping("/student")
public class StudentController {
   
    @Autowired
    StudentService studentService;

    @RequestMapping("/all")
    public String mostrarEstudiantes (Model model){

        model.addAttribute("students", studentService.SearchAll());
        return "show_all_students";
    }


}
