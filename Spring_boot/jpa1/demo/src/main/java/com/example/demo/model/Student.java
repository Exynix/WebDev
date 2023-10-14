package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    
    private String nombre;
    private String carrera;
    private int semestre;
    private String correo;
    //nuevo
    @Id
    @GeneratedValue
    private long id;

    @OneToMany (mappedBy = "estudiante")
    private List<Homework> homeworks = new ArrayList<>();

    @ManyToMany (mappedBy = "students")
    private List<Teacher> teachers = new ArrayList<>();


    public Student(String nombre, String carrera, int semestre, String correo) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.correo = correo;
    }


    public Student() {
    }


    public long getId() {
        return this.id;
    }

    public void setId(long  id) {
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

    public List<Homework> getHomeworks() {
        return this.homeworks;
    }


}
