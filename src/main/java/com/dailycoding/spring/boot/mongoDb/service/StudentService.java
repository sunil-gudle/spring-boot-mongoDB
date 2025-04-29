package com.dailycoding.spring.boot.mongoDb.service;

import com.dailycoding.spring.boot.mongoDb.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {



    Student saveStudents(Student student);

    List<Student> fetchStudents();

    Student fetchStudentById(Integer id);
}
