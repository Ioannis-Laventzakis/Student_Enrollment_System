package org.example.controller;

import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "home";
    }

    @PostMapping("/submit")
    public String submitStudent(
            @RequestParam("name") String name,
            @RequestParam("course") String course,
            @RequestParam("enrollmentDate") String enrollmentDate,
            Model model
    ) {
        try {
            studentService.saveStudent(name, course, LocalDate.parse(enrollmentDate));
            model.addAttribute("message", "Student successfully submitted!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            e.printStackTrace();
        }
    }
}