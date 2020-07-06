package com.giangtester.features;

import com.giangtester.models.Student;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostNewStudentTest {
    @BeforeAll
    static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/student";
        RestAssured.port = 8080;
    }

    @Test
    void postNewStudent() {
        List<String> courses = new ArrayList<>();
        courses.add("Math");
        courses.add("Economics");

        Student student = Student.getInstance();
        student.setId(101);
        student.setFirstName("Giang");
        student.setLastName("Nguyen");
        student.setEmail("giang.nguyen@gc.com");
        student.setProgramme("Computer Science");
        student.setCourses(courses);

        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post();
        //res.prettyPrint();
        res.then().statusCode(201).body("msg", equalTo("Student added"));
    }
}
