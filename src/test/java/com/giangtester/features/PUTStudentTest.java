package com.giangtester.features;

import com.giangtester.api.GetStudent;
import com.giangtester.api.PutStudent;
import com.giangtester.base.BaseClass;
import com.giangtester.models.Student;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PUTStudentTest extends BaseClass {

    private Student student;
    private final PutStudent putStudent = new PutStudent();
    private final GetStudent getStudent = new GetStudent();

    @BeforeEach
    void createStudent() {
        student = Student.getInstance();
    }

    @Test
    void changeInformationOfAnExistingStudent() {
        student.setFirstName("Giang");

        Response res = putStudent.updateStudent(student, "1");
        res.then().statusCode(200).body("msg", equalTo("Student Updated"));

        JsonPath jsonPath = getStudent.getListStudent().then().extract().body().jsonPath();
        List<Student> students = jsonPath.getList("", Student.class);
        assertThat(students.get(0).getFirstName(), equalTo("Giang"));
    }
}
