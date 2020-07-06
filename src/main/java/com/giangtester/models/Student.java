package com.giangtester.models;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> courses;

    private Student() {
        Faker faker = new Faker();
        this.id = 101;
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.programme = "Test";
        this.courses = new ArrayList<>();
        courses.add(faker.educator().course());
        courses.add(faker.educator().course());
    }

    public static Student getInstance() {
        return new Student();
    }
}
