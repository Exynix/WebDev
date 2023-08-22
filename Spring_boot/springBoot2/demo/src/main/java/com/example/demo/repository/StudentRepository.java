package com.example.demo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;


@Repository
public class StudentRepository {
    
    private Map<Integer, Student> fakeDB = new HashMap<>();

    public void StudentRepository(){
        fakeDB.put(1 , new Student("sebastian", "systems", 12, "sebastian@no.com", 1));
        fakeDB.put(2 , new Student("sebastian2", "systems", 13, "sebastian2@no.com",2 ));
        fakeDB.put(3 , new Student("sebastian3", "systems", 14, "sebastian3@no.com", 3));
        fakeDB.put(4 , new Student("sebastian4", "systems", 15, "sebastian4@no.com", 4));
    }

    public Student findById(Integer id){
        return fakeDB.get(id);
    }

    public Collection<Student> findAll(){
        return fakeDB.values();
    }

    // New methods
    public void deleteById(int id){
        fakeDB.remove(id);
    }

    public void updateById(Student student){
        fakeDB.put(student.getId(), student);

    }

    public void addById (Student student){
        int tam = fakeDB.size();
        int lastId = fakeDB.get(tam).getId();
        student.setId(lastId+1);
        fakeDB.put(lastId, student);
    }

}
