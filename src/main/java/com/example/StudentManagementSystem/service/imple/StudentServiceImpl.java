package com.example.StudentManagementSystem.service.imple;
import com.example.StudentManagementSystem.model.Student;
import com.example.StudentManagementSystem.repository.StudentRepository;
import com.example.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepsitory;

    //save employee in database
    @Override
    public Student saveStudent(Student student){
        return studentRepsitory.save(student);
    }

    //get all employee form database
    @Override
    public List<Student> getAllStudent() {
        return studentRepsitory.findAll();
    }

    //get employee using id
    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepsitory.findById(id);
        if(student.isPresent()){
            return student.get();
        }else {
            throw new RuntimeException();
        }
    }
    //update employee
    @Override
    public Student updateStudent(Student student, long id) {
        Student existingStudent = studentRepsitory.findById(id).orElseThrow(()-> new RuntimeException());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
            // save
        studentRepsitory.save(existingStudent);
        return existingStudent;
    }

    //delete employee
    @Override
    public void deleteStudent(long id) {
        //check
        studentRepsitory.findById(id).orElseThrow(()-> new RuntimeException());
        //delete
        studentRepsitory.deleteById(id);
    }
    
 // other methods
 @Override
 public List<Student> getStudentByyearOfEnrollment(Integer yearOfEnrollment) {
 return studentRepsitory.findByYearOfEnrollment(yearOfEnrollment);
 }
 // Get department name by student ID
 @Override
 public String getDepartmentByStudentId(Long studentId) {
     return studentRepsitory.findDepartmentNameByStudentId(studentId);
 }
 @Override
 public void deleteStudentsByYearOfEnrollment(Integer yearOfEnrollment) {
     studentRepsitory.deleteByYearOfEnrollment(yearOfEnrollment);
 }
}
