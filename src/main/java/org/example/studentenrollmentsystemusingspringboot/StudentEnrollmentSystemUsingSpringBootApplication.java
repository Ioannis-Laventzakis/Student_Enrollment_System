package org.example.studentenrollmentsystemusingspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Student Enrollment System Spring Boot application.
 * This class serves to bootstrap the application using Spring Boot's built-in configuration.
 *
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 * - @Configuration: Tags the class as a source of bean definitions for the application context.
 * - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings,
 *   other beans, and various property settings.
 * - @ComponentScan: Tells Spring to look for other components, configurations, and services in
 *   the 'org.example.studentenrollmentsystemusingspringboot' package, allowing it to find the controllers.
 */
@SpringBootApplication
public class StudentEnrollmentSystemUsingSpringBootApplication {

    /**
     * The main method which serves as the entry point for the JVM. This method delegates to
     * Spring Boot's SpringApplication class by calling run. SpringApplication bootstraps our
     * application, starting Spring which will in turn start the auto-configured Tomcat web server.
     *
     * @param args Command line arguments passed during the start of the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(StudentEnrollmentSystemUsingSpringBootApplication.class, args);
    }
}