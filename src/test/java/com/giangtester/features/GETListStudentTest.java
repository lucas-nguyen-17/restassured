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
        res.then().statusCode(200);
    }

    @Test
    public void getFirstStudent() {
        Response res = getStudent.getListStudentById("1");
        res.then().statusCode(200).body("email", equalTo("adalberto.glover@yahoo.com"));
    }
}
