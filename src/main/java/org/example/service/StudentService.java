package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createAndSaveStudent(String name, String course, LocalDate enrollmentDate) throws IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("Student name cannot be blank.");
        if (course.isBlank()) throw new IllegalArgumentException("Student course cannot be blank.");
        if (enrollmentDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Enrollment date cannot be in the future.");
        return studentRepository.save(new Student(name, course, enrollmentDate));
    }

    public List<Student> gettopStudents(){
        List<Student> allStudents = studentRepository.findAll();
        return allStudents.stream()
                .sorted(Comparator.comparing(Student::getCourse))
                .collect(Collectors.toList());
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    private int countReferencesInCourse(String course) {
        if (course.contains("ref:")) return course.split("ref:").length - 1;
        else return 0;
    }
}