package com.example.demo.controller;

import com.example.demo.model.Homework;
import com.example.demo.model.Student;

import com.example.demo.repository.HomeworkRepository;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    HomeworkRepository homeworkRepository;

    @Override
    public void run (ApplicationArguments args) throws Exception{
        studentRepository.save(new Student("Juan", "Informatica", 5, "a@gmail.com"));
        studentRepository.save(new Student("Pedro", "Informatica", 5, "b@gmail.com"));

        homeworkRepository.save(new Homework("Tarea 1", "Hacer un programa"));
        homeworkRepository.save(new Homework("Tarea 2", "Hacer un programa"));

        Student asociar = studentRepository.findById(1L).get();

        for(Homework homework : homeworkRepository.findAll()){
            homework.setEstudiante(asociar);
            homeworkRepository.save(homework);
        }

        asociar = studentRepository.findByNombre("Pedro");

    }


    
}
