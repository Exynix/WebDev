package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class HomeWork {
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String detail;

    @ManyToOne
    private Student estudiante;



    public HomeWork() {
    }

    public HomeWork( String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Student getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Student estudiante) {
        this.estudiante = estudiante;
    }


}
