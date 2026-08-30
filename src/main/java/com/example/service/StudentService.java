package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository= studentRepository;
    }
    public Student createStudent(Student studentReq) {
        //Bussiness logic
        //store to db
        System.out.println("Inside student service");
        Student studentResp= studentRepository.save(studentReq);
        return studentResp;
    }
    public Student getStudent(Long id){
        Optional<Student> studentResp= studentRepository.findById(id);
        return studentResp.orElse(null);
    }
    public List<Student> getAllStudent(){
        List<Student> studentResp= studentRepository.findAll();
        return studentResp;
    }
}
