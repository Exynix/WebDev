package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Student;

public interface StudentService {
    
    public Student SearchById(Long id);

    public Collection<Student> SearchAll();

    public void deleteById(Long id);

    public void update(Student student);

    public void add(Student student);

}
