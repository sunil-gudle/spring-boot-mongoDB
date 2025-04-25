package com.dailycoding.spring.boot.mongoDb.controller;

import com.dailycoding.spring.boot.mongoDb.models.Student;
import com.dailycoding.spring.boot.mongoDb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/student/new")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        Student save = this.studentRepository.save(student);
        return  ResponseEntity.ok(save);
    }

    @GetMapping("/students")
    public ResponseEntity<?> fetchAllStudents(){
        return ResponseEntity.ok(this.studentRepository.findAll());
    }
}
