package com.example.StudentManagementSystem.repository;
import com.example.StudentManagementSystem.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByYearOfEnrollment(int yearOfEnrollment);
}
