package com.dailycoding.spring.boot.mongoDb.controller;

import com.dailycoding.spring.boot.mongoDb.models.Student;
import com.dailycoding.spring.boot.mongoDb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student/new")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudents(student);
        return  new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> fetchAllStudents(){
        List<Student> students = studentService.fetchStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> fetchStudentById(@PathVariable Integer id){
        Student student = studentService.fetchStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
