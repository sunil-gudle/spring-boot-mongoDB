package com.dailycoding.spring.boot.mongoDb.service;

import com.dailycoding.spring.boot.mongoDb.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {



    Student saveStudents(Student student);

    List<Student> fetchStudents();

    Optional<Student> fetchStudentById(Integer id);
}
