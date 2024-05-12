package org.example.student_enrollment_system.controller;

import java.util.Date;
import java.util.List;
import org.example.student_enrollment_system.model.Student;
import org.example.student_enrollment_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // this class is a controller
public class StudentController {

    @Autowired // inject the StudentService class
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
            return "enroll"; // return to the form page if there is any error
        }

        // save the student object
        service.saveStudent(student);
        return "redirect:/";
    }


    // New controller methods
    @GetMapping("/students/course")
    public String getStudentsByCourse(@RequestParam("course") String course, Model model){
        List<Student> students = service.getStudentsByCourse(course);
        model.addAttribute("students", students);
        return "home";
    }

    @GetMapping("/students/enrolledAfter")
    public String getStudentsEnrolledAfter(
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            Model model
    ){

        List<Student> students = service.getStudentsEnrolledAfter(date);
        model.addAttribute("students", students);
        return "home";
    }

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
