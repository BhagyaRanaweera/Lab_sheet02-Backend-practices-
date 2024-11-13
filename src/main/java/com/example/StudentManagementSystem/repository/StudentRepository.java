package com.example.StudentManagementSystem.repository;
import com.example.StudentManagementSystem.model.Student;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByYearOfEnrollment(int yearOfEnrollment);
    @Query("SELECT s.department FROM Student s WHERE s.id = :studentId")
    String findDepartmentNameByStudentId(@Param("studentId") Long studentId);
    @Transactional
    void deleteByYearOfEnrollment(Integer yearOfEnrollment);
}
