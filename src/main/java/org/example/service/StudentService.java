package org.example.service;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer class that handles business logic for student operations.
 * This class interacts with the StudentRepository to perform CRUD operations and other business functionalities.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;  // Injecting the student repository to interact with the database.

    /**
     * Creates and saves a new student to the database.
     * Validates input data before saving to ensure data integrity.
     *
     * @param name The name of the student.
     * @param course The course the student is enrolled in.
     * @param enrollmentDate The date the student enrolled.
     * @return The saved Student object.
     * @throws IllegalArgumentException if any input validation fails.
     */
    public Student createAndSaveStudent(String name, String course, LocalDate enrollmentDate) throws IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("Student name cannot be blank.");
        if (course.isBlank()) throw new IllegalArgumentException("Student course cannot be blank.");
        if (enrollmentDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Enrollment date cannot be in the future.");

        // Saving the new student to the database after passing validation checks
        return studentRepository.save(new Student(name, course, enrollmentDate));
    }

    /**
     * Retrieves all students from the database and sorts them by the course name.
     *
     * @return A list of students sorted by their course names.
     */
    public List<Student> gettopStudents(){
        List<Student> allStudents = studentRepository.findAll();
        // Using Java Streams to sort the students by course name.
        return allStudents.stream()
                .sorted(Comparator.comparing(Student::getCourse))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all students from the database.
     *
     * @return A list of all registered students.
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Counts the number of references in the course description.
     *
     * @param course The course description text that may contain references.
     * @return The number of times 'ref:' appears in the course text.
     */
    private int countReferencesInCourse(String course) {
        if (course.contains("ref:")) return course.split("ref:").length - 1;
        else return 0;
    }
}
