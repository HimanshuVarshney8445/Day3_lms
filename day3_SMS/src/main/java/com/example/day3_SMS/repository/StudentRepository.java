package com.example.day3_SMS.repository;

import com.example.day3_SMS.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<StudentModel,String> {

}
