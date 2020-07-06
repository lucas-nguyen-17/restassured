package com.giangtester.api;

import com.giangtester.models.Student;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostStudent {

    public Response createAStudent(Student student) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post();
    }

}
