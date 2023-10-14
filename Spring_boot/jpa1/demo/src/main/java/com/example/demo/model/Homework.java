package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Homework {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String detaill;

    @ManyToOne
    private Student estudiante;

    public Homework() {
    }

    public Homework(String name, String detaill) {
        this.name = name;
        this.detaill = detaill;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetaill() {
        return detaill;
    }

    public void setDetaill(String detaill) {
        this.detaill = detaill;
    }

    public Student getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Student estudiante) {
        this.estudiante = estudiante;
    }
}
