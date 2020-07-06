package com.giangtester.api;

import com.giangtester.models.Student;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutStudent {

    public Response updateStudent(Student student, String id) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .put("/{id}", id);
    }
}
