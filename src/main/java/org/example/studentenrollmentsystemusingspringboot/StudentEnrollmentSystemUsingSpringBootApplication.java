package org.example.studentenrollmentsystemusingspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Student Enrollment System Spring Boot application.
 * This class serves to launch the application using Spring Boot's built-in configuration.
 */
@SpringBootApplication  // This annotation denotes this class as a Spring Boot application.
public class StudentEnrollmentSystemUsingSpringBootApplication {

    /**
     * Main method which starts the entire Spring Boot application.
     * @param args Command line arguments passed during the start of the application.
     */
    public static void main(String[] args) {
        // Launches the Spring Boot application by passing the current application class and command line arguments.
        SpringApplication.run(StudentEnrollmentSystemUsingSpringBootApplication.class, args);
    }
}
