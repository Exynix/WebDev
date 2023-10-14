package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Student;

public interface StudentService {
    
    public Student SearchById(long id);

    public Collection<Student> SearchAll();

    public void deleteById(long id);

    public void update(Student student);

    public void add(Student student);

}
