package org.example.service;


import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student StudentService(String name, String course, LocalDate enrollmentDate) throws IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("Student name cannot be blank.");
        if (course.isBlank()) throw new IllegalArgumentException("Student course cannot be blank.");
        if (enrollmentDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Enrollment date cannot be in the future.");
        return studentRepository.save(new Student(name, course, enrollmentDate));
    }
    // This method returns all students.
    public List<Student>gettopStudents(){
        List<Student> allStudents = studentRepository.findAll();
        Stream<Student> stream = allStudents.stream();
        List<Student> topStudents = stream
                .sorted((student1, student2) -> StudentService(student2.getCourse()) - StudentService(student1.getCourse()))
                .collect(Collectors.toList());
        return topStudents;
    }
    //// This method returns the top students.
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    //Helper: count number of references in content
    private int StudentService(String course) {
        if (course.contains("ref:")) return course.split("ref:").length - 1;
        else return 0;
    }
}
