package com.zainjafri.codechallenge.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping
public class StudentController {

    private final StudentService studentService;

//    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping
    public List<Student> helloWorld(){
        return studentService.helloWorld();
    }
}
