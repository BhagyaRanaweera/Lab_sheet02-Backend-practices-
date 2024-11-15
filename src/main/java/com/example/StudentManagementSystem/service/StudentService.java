package com.example.StudentManagementSystem.service;
import com.example.StudentManagementSystem.model.Student;
import java.util.List;
public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(long id);
    Student updateStudent(Student student,long id);
    void deleteStudent(long id);
    
 List<Student> getStudentByyearOfEnrollment(Integer yearOfEnrollment);

String getDepartmentByStudentId(Long studentId); 
void deleteStudentsByYearOfEnrollment(Integer yearOfEnrollment);
}
