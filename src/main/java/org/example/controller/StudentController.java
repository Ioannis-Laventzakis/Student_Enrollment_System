package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.time.LocalDate;

/**
 * Controller for handling student-related web requests.
 * Manages interactions between the user interface and the application data related to students.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService service;  // Injects the StudentService to handle business logic.

    /**
     * Handles the default route and displays the home page with a list of all students.
     * @param model A Model object to pass data to the view.
     * @return The name of the Thymeleaf template to render the home page.
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", service.getAllStudents());  // Adds the list of all students to the model.
        model.addAttribute("student", new Student());  // Adds an empty student object to the model for the form.
        return "home";  // Returns the home view template.
    }

    /**
     * Handles the submission of a new student form.
     * @param name The student's name received from the form.
     * @param course The course the student is enrolled in, received from the form.
     * @param enrollmentDate The date the student enrolled, received from the form as a string.
     * @param model A Model object to pass data or messages back to the view.
     * @return Redirects to the home page after successful submission or returns the form with errors.
     */
    @PostMapping("/enroll")
    public String submitStudent(
            @RequestParam("name") String name,
            @RequestParam("course") String course,
            @RequestParam("enrollmentDate") String enrollmentDate,
            Model model
    ) {
        try {
            // Attempts to create and save the new student using the service layer.
            service.createAndSaveStudent(name, course, LocalDate.parse(enrollmentDate));
            model.addAttribute("message", "Student successfully submitted!");  // Adds a success message to the model.
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());  // Adds an error message to the model if there's an issue.
            e.printStackTrace();
        }
        return "redirect:/";  // Redirects to the home page to display all students and the success or error message.
    }
}
