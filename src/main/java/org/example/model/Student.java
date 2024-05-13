package org.example.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Student entity class.
 * This class is annotated with @Entity, indicating that it is a JPA entity.
 * The @Table annotation specifies the details of the table that will be used to create the table in the database.
 */
@Entity
@Table(name = "students")
public class Student {

    /**
     * ID of the student.
     * This field is annotated with @Id, indicating it's the primary key of the entity.
     * The @GeneratedValue annotation is used to specify how the primary key should be generated.
     * The @Column annotation is used to specify the details of the column for this field in the database table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Name of the student.
     * The @Column annotation is used to specify the details of the column for this field in the database table.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Enrollment date of the student.
     * The @DateTimeFormat annotation is used to format the date value.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enrollmentDate;

    /**
     * Courses of the student.
     */
    private String courses;

    /**
     * Default constructor.
     */
    public Student() {
    }

    /**
     * Parameterized constructor.
     * @param name Name of the student.
     * @param enrollmentDate Enrollment date of the student.
     * @param courses Courses of the student.
     */
    public Student(String name, Date enrollmentDate, String courses) {
        this.name = name;
        this.enrollmentDate = enrollmentDate;
        this.courses = courses;
    }

    /**
     * Getter for id.
     * @return id of the student.
     */
    public Long getId() {
        return id;
    }

    /**
     * Getter for name.
     * @return name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     * @param name Name of the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for enrollmentDate.
     * @return enrollmentDate of the student.
     */
    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    /**
     * Setter for enrollmentDate.
     * @param enrollmentDate Enrollment date of the student.
     */
    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    /**
     * Getter for courses.
     * @return courses of the student.
     */
    public String getCourses() {
        return courses;
    }

    /**
     * Setter for courses.
     * @param courses Courses of the student.
     */
    public void setCourses(String courses) {
        this.courses = courses;
    }
}