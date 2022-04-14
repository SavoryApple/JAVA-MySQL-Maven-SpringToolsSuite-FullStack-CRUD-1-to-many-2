package com.seannavery.studentroster.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.seannavery.studentroster.models.Student;
import com.seannavery.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
    // adding the book repository as a dependency
    private final StudentRepository studentRepository;
    
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    // returns all the books
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }
    // creates a book
    public Student createStudent(Student s) {
        return studentRepository.save(s);
    }
    
    //deletes a book
    public void deleteStudent(Long id) {
    	studentRepository.deleteById(id);
    }
    
    // updates a book
     public Student updateStudent(Student student) {
    	Long studentId = student.getId();
    	String studentName = student.getName();
    	Student studentToUpdate = this.findStudent(studentId);   //set method below for this to work	
    	studentToUpdate.setName(studentName);
    	studentRepository.save(studentToUpdate);
        return studentToUpdate;
    }
    // retrieves a book
    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }
}
