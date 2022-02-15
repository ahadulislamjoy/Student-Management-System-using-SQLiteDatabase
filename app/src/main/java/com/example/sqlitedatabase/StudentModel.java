package com.example.sqlitedatabase;

import java.io.Serializable;

public class StudentModel implements Serializable {
    int id;
    String name;
    int age;
    String address;

    public StudentModel(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public StudentModel(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

}
