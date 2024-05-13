package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;



/**
 * explain the class
 * */
@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    /**
     * Saves a {@link  Student} entity to the repository. If the student already exists
     * (determined by uniques identifier, typically ID), this method will update
     * the existing student. If the student does not exist, a new entry will be created
     * in the repository.
     *
     * @param student the {@link  Student} object to be saved; must not be null.
     * @return the saved {@link  Student} object
     *
     * */
    public Student saveStudent(Student student) {
        return repository.save(student); // saving student object
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }


    // New service methods
    // this method will return the list of students enrolled in a particular course
    public List<Student> getStudentsByNameAndCourse(String name, String course){
        return repository.findByNameAndCourse(name, course);
    }

    public List<Student> getStudentsByEnrollmentDateBetween(Date start, Date end){
        return repository.findByEnrollmentDateBetween(start, end);
    }

    public List<Student> getAllStudentsOrderByEnrollmentDateDesc(){
        return repository.findAllOrderByEnrollmentDateDesc();
    }
}
