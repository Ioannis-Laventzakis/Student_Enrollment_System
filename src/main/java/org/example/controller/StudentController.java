package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Controller for handling requests related to students.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Endpoint to get students by name and course.
     * @param name The name of the student.
     * @param course The course of the student.
     * @return A list of students that match the name and course.
     */
    @GetMapping("/nameAndCourse")
    public List<Student> getStudentsByNameAndCourse(@RequestParam String name, @RequestParam String course) {
        return studentService.getStudentsByNameAndCourse(name, course);
    }

    /**
     * Endpoint to get students by enrollment date.
     * @param start The start date.
     * @param end The end date.
     * @return A list of students that were enrolled between the start and end dates.
     */
    @GetMapping("/enrollmentDate")
    public List<Student> getStudentsByEnrollmentDateBetween(@RequestParam Date start, @RequestParam Date end) {
        return studentService.getStudentsByEnrollmentDateBetween(start, end);
    }

    /**
     * Endpoint to show the form for enrolling a new student.
     * @param model The model to which the new Student object is added.
     * @return The name of the Thymeleaf template to be displayed.
     */
    @GetMapping("/enroll")
    public String showEnrollForm(Model model) {
        model.addAttribute("student", new Student());
        return "enroll";
    }

    /**
     * Endpoint to get all students ordered by enrollment date in descending order.
     * @return A list of all students ordered by enrollment date in descending order.
     */
    @GetMapping("/orderByEnrollmentDate")
    public List<Student> getAllStudentsOrderByEnrollmentDateDesc() {
        return studentService.getAllStudentsOrderByEnrollmentDateDesc();
    }
}