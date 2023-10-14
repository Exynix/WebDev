package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ErrorHandling.NotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;


@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    //http://localhost:8090/student/all
    @GetMapping("/all")
    public String mostrarEstudiantes(Model model) {

        model.addAttribute("estudiantes", studentService.SearchAll());

        return "mostrar_todos_estudiantes";
    }

    // http://localhost:8080/student/find?id=1
    @GetMapping("/find")
    public String mostrarInfoEstudiante(Model model, @RequestParam("id") Long id) {

        Student student = studentService.SearchById(id);
        if (student != null) {
            model.addAttribute("persona", student);
        }

        return "mostrar_estudiante";
    }

    // http://localhost:8080/student/find/1
    @GetMapping("/find/{id}")
    public String mostrarInfoEstudiante2(Model model, @PathVariable("id") Long id) {

        Student student = studentService.SearchById(id);
        if (student != null) {
            model.addAttribute("persona", student);
        }else{
            //throw new NotFoundException(id);
        }

        return "mostrar_estudiante";
    }

    //http://localhost:8090/student/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model){
        Student student = new Student("","",0,"");
        model.addAttribute("estudiante", student);
        return "crear_estudiante";
    }

    @PostMapping("/agregar")
    public String agregarEstudiante(@ModelAttribute("estudiante") Student student){
        studentService.add(student);
        return "redirect:/student/all";
    }

    //delete
    //http://localhost:8090/delete/1
    @GetMapping("/delete/{id}")
    public String eliminarEstudiante(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return "redirect:/student/all";
    }

    //update
    //http://localhost:8090/student/ipdate/1
    @GetMapping("/update/{id}")
    public String mostrarFormEditar(@PathVariable("id") Long id, Model model){
        model.addAttribute("estudiante", studentService.SearchById(id));
        return "modificar_estudiante";
    }

    @PostMapping("/update/{id}")
    public String actualizarEstudiante(@ModelAttribute("estudiante") Student student, @PathVariable("id") int id){
        studentService.update(student);
        return "redirect:/student/all";
        
    }
}
