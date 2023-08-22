package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Student;

import com.example.demo.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repo;

    @Override
    public Student SearchById(int id){
        return repo.findById(id);
    }

    @Override
    public Collection<Student> SearchAll(){
        return repo.findAll();
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public void updateById(Student student) {
        repo.updateById(student);
    }

    @Override
    public void addById(Student student) {
        repo.addById(student);
    }


}
