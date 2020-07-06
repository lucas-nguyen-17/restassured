package com.giangtester.features;

import com.giangtester.api.DeleteStudent;
import com.giangtester.api.PostStudent;
import com.giangtester.base.BaseClass;
import com.giangtester.models.Student;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DELETEStudentTest extends BaseClass {

    private Student student;
    private final PostStudent postStudent = new PostStudent();
    private final DeleteStudent deleteStudent = new DeleteStudent();

    @BeforeEach
    void createStudent() {
        student = Student.getInstance();
        postStudent.createAStudent(student);
    }

    @Test
    void deleteAnExistingStudent() {
        Response res = deleteStudent.deleteStudent(student);
        res.then().statusCode(204);
    }
}
