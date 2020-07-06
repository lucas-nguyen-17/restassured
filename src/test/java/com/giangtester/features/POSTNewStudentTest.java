package com.giangtester.features;

import com.giangtester.api.PostStudent;
import com.giangtester.base.BaseClass;
import com.giangtester.models.Student;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class POSTNewStudentTest extends BaseClass {

    private Student student;
    private final PostStudent postStudent = new PostStudent();

    @BeforeEach
    void createStudent() {
        student = Student.getInstance();
    }

    @Test
    void postNewStudent() {
        Response res = postStudent.createAStudent(student);
        res.then().statusCode(201).body("msg", equalTo("Student added"));
    }
}
