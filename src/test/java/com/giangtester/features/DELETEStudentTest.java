package com.giangtester.features;

import com.giangtester.base.BaseClass;
import com.giangtester.models.Student;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DELETEStudentTest extends BaseClass {

    @Test
    void deleteAnExistingStudent() {
        // Arrange: Setup data
        Student student = Student.getInstance();
        given().log().all().contentType(ContentType.JSON)
                .when().body(student).post();

        // Act: Call API delete student
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/{id}", student.getId());

        // Assert
        res.then().statusCode(204);
    }
}
