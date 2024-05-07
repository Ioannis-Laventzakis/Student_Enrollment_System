package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Represents a student within the system.
 * This class is mapped to a database table 'students' through JPA annotations.
 */
@Entity // Indicates that this class is an entity to be managed by JPA.
@Table(name = "students")  // Specifies the table name where the entity data will be stored.
public class Student {

    @Id  // Marks this field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Configures the way ID values are generated: using the database identity column.
    @Column(name = "id")  // Maps this field to the 'id' column in the 'students' table.
    private Long id;  // Unique identifier for the student.

    @Column(name = "name", nullable = false)  // Maps this field to the 'name' column in the 'students' table. The 'nullable = false' option indicates that this field cannot be null.
    private String name;  // Name of the student.

    @Column(name = "course", nullable = false)  // Maps this field to the 'course' column in the 'students' table. The 'nullable = false' option indicates that this field cannot be null.
    private String course;  // Course that the student is enrolled in.

    @Column(name = "enrollment_date", nullable = false)  // Maps this field to the 'enrollment_date' column in the 'students' table. The 'nullable = false' option indicates that this field cannot be null.
    private LocalDate enrollmentDate;  // Date when the student enrolled.

    /**
     * Constructor for creating a new Student instance.
     * This is used specifically when creating a new student entry where the ID is not yet known and will be generated by JPA.
     *
     * @param name Name of the student.
     * @param course Course the student is enrolled in.
     * @param enrollmentDate The date the student enrolled.
     */
    public Student(String name, String course, LocalDate enrollmentDate) {
        this.name = name;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    // Getters and setters provide access to the fields of the class.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;  // Sets the ID of the student. Typically not used but can be useful for database operations or testing.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;  // Sets the name of the student.
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;  // Sets the course the student is enrolled in.
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;  // Sets the enrollment date of the student.
    }

    /**
     * Default constructor for JPA.
     * JPA requires a no-argument constructor to function correctly.
     */
    public Student() {
        // Intentionally left blank
    }

    // Additional methods and business logic can be added below.
}