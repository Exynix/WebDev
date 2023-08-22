package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.Student;

public interface StudentService {
    
    public Student SearchById (int id);

    public Collection<Student> SearchAll();

    public void deleteById(int id);

    public void updateById(Student student);

    public void addById(Student student);

    
    
}
