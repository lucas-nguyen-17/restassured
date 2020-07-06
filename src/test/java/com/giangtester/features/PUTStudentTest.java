package com.giangtester.features;

import com.giangtester.models.Student;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PUTStudentTest {

    @BeforeAll
    static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/student";
        RestAssured.port = 8080;
    }

    @Test
    void changeInformationOfAnExistingStudent() {
        Student student = Student.getInstance();
        student.setFirstName("Giang");

        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .put("/1");

        res.prettyPrint();
        res.then().statusCode(200).body("msg", equalTo("Student Updated"));

        JsonPath jsonPath = given().when().get("/list").then().extract().body().jsonPath();
        List<Student> students = jsonPath.getList("", Student.class);
        assertThat(students.get(0).getFirstName(), equalTo("Giang"));
    }
}
