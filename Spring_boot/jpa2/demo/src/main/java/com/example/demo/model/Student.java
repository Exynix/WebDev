package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

@Entity
//@Table(name = "STUDENT")
public class Student {
    
    @Column(name = "NAME")
    private String nombre;
    private String carrera;
    private int semestre;
    private String correo;
    //nuevo
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HomeWork> tareas = new ArrayList<>();

    @JoinTable(name="course", joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name="teacher_id")
    private List<Teacher> profesores = new ArrayList<>();
    

    
    public List<HomeWork> getTareas() {
        return tareas;
    }

    public void setTareas(List<HomeWork> tareas) {
        this.tareas = tareas;
    }

    public Student(String nombre, String carrera, int semestre, String correo) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.correo = correo;
    }

    public Student () {
        
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return this.semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Teacher> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Teacher> profesores) {
        this.profesores = profesores;
    }


}
