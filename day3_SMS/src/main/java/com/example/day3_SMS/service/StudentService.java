package com.example.day3_SMS.service;

import com.example.day3_SMS.controller.StudentController;
import com.example.day3_SMS.dto.StudentRequestDto;
import com.example.day3_SMS.dto.StudentResponseDto;
import com.example.day3_SMS.model.StudentModel;
import com.example.day3_SMS.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService (StudentRepository repository){
        this.repository=repository;
    }
    // create


    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        )
    }


//    public StudentModel addStudent(StudentModel student){
//        return repository.save(student);
//    }

    // display
    public List<StudentModel> getStudents(){
        return repository.findAll();
    }

    // update
    public StudentModel updateStudent(String id,StudentModel student){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Student found"));

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());

        return repository.save(existingStudent);
    }

    public void deleteStudent(String id){
        repository.deleteById(id);
    }
}
