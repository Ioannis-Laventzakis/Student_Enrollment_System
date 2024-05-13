package org.example.repository;

import org.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Other existing methods...??


    // New query methods for the repository interface to query the database
    @Query("SELECT s FROM Student s WHERE s.name = :name AND s.course = :course")
    List<Student> findByNameAndCourse(@Param("name") String name, @Param("course") String course);

    // Query method to find students by enrollment date between two dates
    @Query("SELECT s FROM Student s WHERE s.enrollmentDate BETWEEN :start AND :end")
    List<Student> findByEnrollmentDateBetween(@Param("start") Date start, @Param("end") Date end);

    // Query method to find all students and order them by enrollment date in descending order
    @Query("SELECT s FROM Student s ORDER BY s.enrollmentDate DESC")
    List<Student> findAllOrderByEnrollmentDateDesc();
}