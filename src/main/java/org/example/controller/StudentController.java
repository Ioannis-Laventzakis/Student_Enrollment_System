package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("students", service.getAllStudents());
        return "home";
    }

    @GetMapping("/enroll")
    public String showEnrollmentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "enroll";
    }

    @PostMapping("/enroll")
    public String submitStudentForm(@ModelAttribute("student") Student student, BindingResult result){
        if(result.hasErrors()){
            return "enroll";
        }

        service.saveStudent(student);
        return "redirect:/";
    }

    public List<Student> getStudentsByNameAndCourse(String name, String course){
        return service.getStudentsByNameAndCourse(name, course);
    }

    public List<Student> getStudentsByEnrollmentDateBetween(Date start, Date end){
        return service.getStudentsByEnrollmentDateBetween(start, end);
    }

    public List<Student> getAllStudentsOrderByEnrollmentDateDesc(){
        return service.getAllStudentsOrderByEnrollmentDateDesc();
    }
}