package com.example.demo.entity;

public class User {
    private String name;
    private String username;
    private String email;
    private int age;


    


    public User(String name, String username, String email, int age) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    

}
