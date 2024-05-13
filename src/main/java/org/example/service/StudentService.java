package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Service class for handling business logic related to Student entity.
 * It uses Spring's @Service annotation to indicate that it's a service bean.
 */
@Service
public class StudentService {

    /**
     * The StudentRepository instance is auto-wired by Spring.
     * This means Spring automatically manages this object, including its lifecycle and dependencies.
     */
    @Autowired
    private StudentRepository repository;

    /**
     * Saves a Student object in the database.
     * @param student the Student object to be saved
     * @return the saved Student object
     */
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    /**
     * Fetches all Student objects from the database.
     * @return a list of all Student objects
     */
    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    /**
     * Fetches all Student objects by name and course from the database.
     * @param name the name of the student
     * @param course the course of the student
     * @return a list of Student objects that match the name and course
     */
    public List<Student> getStudentsByNameAndCourse(String name, String course){
        return repository.findByNameAndCourse(name, course);
    }

    /**
     * Fetches all Student objects between start and end enrollment dates from the database.
     * @param start the start date of the enrollment period
     * @param end the end date of the enrollment period
     * @return a list of Student objects that were enrolled between the start and end dates
     */
    public List<Student> getStudentsByEnrollmentDateBetween(Date start, Date end){
        return repository.findByEnrollmentDateBetween(start, end);
    }

    /**
     * Fetches all Student objects and orders them by enrollment date in descending order from the database.
     * @return a list of all Student objects ordered by enrollment date in descending order
     */
    public List<Student> getAllStudentsOrderByEnrollmentDateDesc(){
        return repository.findAllOrderByEnrollmentDateDesc();
    }
}