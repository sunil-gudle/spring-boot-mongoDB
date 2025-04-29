package com.dailycoding.spring.boot.mongoDb.service;

import com.dailycoding.spring.boot.mongoDb.exception.EmailAlreadyExistsException;
import com.dailycoding.spring.boot.mongoDb.exception.IdAlreadyExistsException;
import com.dailycoding.spring.boot.mongoDb.exception.ResourceNotFoundException;
import com.dailycoding.spring.boot.mongoDb.models.Student;
import com.dailycoding.spring.boot.mongoDb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudents(Student student){
        if (studentRepository.existsById(student.getId())){
            throw new IdAlreadyExistsException("Student with id " + student.getId() + " already exists!");
        }
        try {
                return studentRepository.save(student);
            } catch (DuplicateKeyException e) {
                throw new EmailAlreadyExistsException("Email '" + student.getEmail() + "' already exist!");
            }
    }

    @Override
    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudentById(Integer id) {
            return studentRepository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Student with id " + id + " not found"));

    }


}
