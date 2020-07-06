package com.giangtester.api;

import com.giangtester.models.Student;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteStudent {

    public Response deleteStudent(Student student) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .delete("/{id}", student.getId());
    }
}
