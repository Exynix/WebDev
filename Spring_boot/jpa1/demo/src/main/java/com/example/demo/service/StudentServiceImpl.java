package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repo;

    @Override
    public Student SearchById(long id) {

        return repo.findById(id).get();
    }

    @Override
    public Collection<Student> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Student student) {

        repo.save(student);
    }

    @Override
    public void add(Student student) {
        repo.save(student);
    }
}
