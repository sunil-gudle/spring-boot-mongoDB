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
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudents(Student student){
        if (studentRepository.existsById(student.getId())){
            throw new IdAlreadyExistsException("Student with id " + student.getId() + " already exists!");
        }else {
            try {
                return studentRepository.save(student);
            } catch (DuplicateKeyException e) {
                throw new EmailAlreadyExistsException("Email '" + student.getEmail() + "' already exist!");
            }
        }
    }

    @Override
    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> fetchStudentById(Integer id) {
        try {
            return studentRepository.findById(id);
        }catch (RuntimeException e){
            throw new ResourceNotFoundException("No Data found");
        }
    }


}
