package com.example.demo.repository;

import com.example.demo.model.Homework;

import org.springframework.data.jpa.repository.JpaRepository;
public interface HomeworkRepository extends JpaRepository<Homework, Long> {


}
