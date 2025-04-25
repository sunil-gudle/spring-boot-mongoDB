package com.dailycoding.spring.boot.mongoDb.repository;

import com.dailycoding.spring.boot.mongoDb.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Integer> {
}
