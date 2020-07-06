package com.giangtester.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseClass {

    @BeforeAll
    static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/student";
        RestAssured.port = 8080;
    }
}
