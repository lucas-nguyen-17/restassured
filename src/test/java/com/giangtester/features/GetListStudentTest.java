package com.giangtester.features;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class GetListStudentTest {

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/student";
        RestAssured.port = 8080;
    }

    @Test
    public void getListStudent() {
        Response res = given()
                .when()
                .get("/list");

        res.prettyPrint();
        res.then().statusCode(200);
    }
}
