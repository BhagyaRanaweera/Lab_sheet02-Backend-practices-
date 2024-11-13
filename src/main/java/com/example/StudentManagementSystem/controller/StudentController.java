package com.example.StudentManagementSystem.controller;
import com.example.StudentManagementSystem.model.Student;

import com.example.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")

public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> saveEmployee(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    //GetAll Rest Api
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/employees/1
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentID){
        return new ResponseEntity<Student>(studentService.getStudentById(studentID),HttpStatus.OK);
    }

    //Update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);
    }

    //Delete Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        //delete employee from db
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);
    }
    
    @GetMapping("/yearOfEnrollment/{yearOfEnrollment}")
public ResponseEntity<List<Student>>
getEmployeeByFirstName(@PathVariable("yearOfEnrollment") Integer yearOfEnrollment) {
 List<Student> student = studentService.getStudentByyearOfEnrollment(yearOfEnrollment);
 return new ResponseEntity<>(student, HttpStatus.OK);
}
}
