package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

// The @Service annotation is used to indicate that it's holding the business logic for the Student entity
@Service
public class StudentService {

    // The @Autowired annotation is used to auto-wire the StudentRepository in the StudentService. This means it is creating an object of StudentRepository automatically
    @Autowired
    private StudentRepository repository;

    // This method is used to save a Student object in the database
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    // This method is used to fetch all Student objects from the database
    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    // This method is used to fetch all Student objects by name and course from the database
    public List<Student> getStudentsByNameAndCourse(String name, String course){
        return repository.findByNameAndCourse(name, course);
    }

    // This method is used to fetch all Student objects between start and end enrollment dates from the database
    public List<Student> getStudentsByEnrollmentDateBetween(Date start, Date end){
        return repository.findByEnrollmentDateBetween(start, end);
    }

    // This method is used to fetch all Student objects and order them by enrollment date in descending order from the database
    public List<Student> getAllStudentsOrderByEnrollmentDateDesc(){
        return repository.findAllOrderByEnrollmentDateDesc();
    }
}