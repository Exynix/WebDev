package com.example.demo.model;

import java.util.concurrent.ThreadLocalRandom;

import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.HomeWorkRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    HomeWorkRepository homeWorkRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Generacion de estudiantes
        studentRepository.save(new Student("Sebastian Angarita","Sistemas",3,"juseanto@javeriana.edu.co"));
        studentRepository.save(new Student("Margarita Mendoza","Filosofia",2,"margarita@javeriana.edu.co"));
        studentRepository.save(new Student("Pedro Claver","Matematicas",3,"pedro@javeriana.edu.co"));
        studentRepository.save(new Student("Camilo Cabra","Sistemas",8,"Camilo@javeriana.edu.co"));
        studentRepository.save(new Student("Alejandro Herrera","Sociologia",8,"Alejandro@javeriana.edu.co"));
    
        homeWorkRepository.save(new HomeWork("Ejericios ecuaciones", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios mate", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios sociales", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios filosofia", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Proyecto final", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios ecuaciones 2", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios mate 2", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios sociales 2", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Ejericios filosofia 2", "Terminar taller"));
        homeWorkRepository.save(new HomeWork("Proyecto final 2", "Terminar taller"));


        //crear profesores
        teacherRepository.save(new Teacher("Anabel"));
        teacherRepository.save(new Teacher("Pavlich"));
        teacherRepository.save(new Teacher("Bustacara"));

        //asociar varias tareas al estudiante con ID1
        Student asociar = studentRepository.findById(1L).get();
        for(HomeWork homeWork: homeWorkRepository.findAll()){
            //asociar.getTareas().add(homeWork);//esto no funciona
            homeWork.setEstudiante(asociar);
            homeWorkRepository.save(homeWork);
        }

        //asociar todas las tareas al estudiante "Pedro Claver"
        asociar = studentRepository.findByNombre("Pedro Claver");
        for(HomeWork homeWork: homeWorkRepository.findAll()){
            //asociar.getTareas().add(homeWork);
            homeWork.setEstudiante(asociar);
            homeWorkRepository.save(homeWork);
        }

        //nuevo asosiación aleatoria
        int CANTIDAD_ESTUDIANTES = 5;
        for(HomeWork homeWork: homeWorkRepository.findAll()){
                int randomNum = ThreadLocalRandom.current().nextInt(1, CANTIDAD_ESTUDIANTES + 1);
                Long search = Long.valueOf(randomNum);
                Student student = studentRepository.findById(search).get();
                homeWork.setEstudiante(student);
        }

        /*
        //muchos a muchos
        Teacher profe = teacherRepository.findById(1L).get();
        for(Student student: studentRepository.findAll()){
            student.getProfesores().add(profe);
        }
        */
        courseRepository.save(new Course("Matematicas"));
        courseRepository.save(new Course("Base de datos"));
        courseRepository.save(new Course("Programacion"));
        courseRepository.save(new Course("Filosofia"));
        courseRepository.save(new Course("Sociologia"));


    }

}
