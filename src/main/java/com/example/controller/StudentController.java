package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    //create student
    private StudentService studentService;
    private StudentController(StudentService studentService){
        this.studentService= studentService;
    }
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(201).body(createdStudent);
    }
    //read one dstudent
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp= studentService.getStudent(id);
        if(studentResp==null){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(studentResp);
    }
    //update student

    @GetMapping("/get/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentResp= studentService.getAllStudent();
        if(studentResp.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(studentResp);
    }
    //delete student
}
