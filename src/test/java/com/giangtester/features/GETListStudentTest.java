package com.giangtester.features;

import com.giangtester.base.BaseClass;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class GETListStudentTest extends BaseClass {

    @Test
    public void getListStudent() {
        Response res = given()
                .when()
                .get("/list");

        res.prettyPrint();
        res.then().statusCode(200);
    }
}
