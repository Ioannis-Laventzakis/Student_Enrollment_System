package org.example.controller;


import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller // this class is a controller //why is this class a controller? // this class is a controller because it is annotated with the @Controller annotation
public class StudentController {

    @Autowired // inject the StudentService class into the controller class //why is the StudentService class injected into the controller class? // The StudentService class is injected
    private StudentService service;
 // this method will be called when the user navigates to the home page
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("students", service.getAllStudents());
        return "home";
    }

    // this method will be called when the user navigates to the enroll page //why is this method called when the user navigates to the enroll page? // This method is called when the user navigates to the enroll page because it is annotated with the @GetMapping("/enroll") annotation
    @GetMapping("/enroll")
    public String showEnrollmentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "enroll";
    }

    // this method will be called when the user submits the form
    @PostMapping("/enroll")
    public String submitStudentForm(@ModelAttribute("student") Student student, BindingResult result){
        if(result.hasErrors()){
            return "enroll"; // return to the form page if there is any error
        }

        // save the student object
        service.saveStudent(student);
        return "redirect:/";
    }


    // New controller methods
    // this method will be called when the user navigates to the students/course page
    @GetMapping("/students/course")
    public String getStudentsByCourse(@RequestParam("course") String course, Model model){
        List<Student> students = service.getStudentsByCourse(course);
        model.addAttribute("students", students);
        return "home";
    }

    // this method will be called when the user navigates to the students/enrolledAfter page
    @GetMapping("/students/enrolledAfter")
    public String getStudentsEnrolledAfter(
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            Model model
    ){

        // get students enrolled after the given date
        List<Student> students = service.getStudentsEnrolledAfter(date);
        model.addAttribute("students", students);
        return "home";
    }

    // this method will be called when the user navigates to the students/name page
    @GetMapping("/students/name")
    public String getStudentsByNameContaining(
            @RequestParam("name" ) String name,
            Model model
    ){
        List<Student> students = service.getStudentsByNameContaining(name);
        model.addAttribute("students", students);
        return "home";
    }
}
