package com.giangtester.features;

import com.giangtester.api.GetStudent;
import com.giangtester.base.BaseClass;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

class GETListStudentTest extends BaseClass {

    GetStudent getStudent = new GetStudent();

    @Test
    public void getListStudent() {
        Response res = getStudent.getListStudent();
        res.prettyPrint();
        res.then().statusCode(200);
    }

    @Test
    public void getSecondStudent() {
        Response res = getStudent.getListStudentById("2");
        res.then().statusCode(200).body("email", equalTo("faucibus.orci.luctus@Duisac.net"));
    }
}
