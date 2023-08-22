package com.example.demo.entity;

public class Student {
    private String name;
    private String degree;
    private int semester;
    private String email;
    private Integer id;


    


    public Student(String name, String degree, int semester, String email, Integer id) {
        this.id = id;
        this.name = name;
        this.degree = degree;
        this.semester = semester;
        this.email = email;
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
