package org.example.repository;

import org.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Repository interface for Student entity.
 * This interface extends JpaRepository which provides JPA related methods
 * such as save(), findOne(), findAll(), count(), delete() etc.
 * We can also define our custom finder methods in it.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Method to find students by name.
     * @param name The name of the student.
     * @return A list of students that match the name.
     */
    List<Student> findByName(String name);

    /**
     * Method to find students by name and course.
     * @param name The name of the student.
     * @param course The course of the student.
     * @return A list of students that match the name and course.
     */
    List<Student> findByNameAndCourses(String name, String course);

    /**
     * Method to find students by name and course using @Query annotation.
     * The JPQL query will return students with the specified name and course.
     * The 'name' field is assumed to exist in the 'Student' class and 'Student' has a 'courses' field.
     * @param name The name of the student.
     * @param course The course of the student.
     * @return A list of students that match the name and course.
     */
    @Query("SELECT s FROM Student s WHERE s.name = :name AND s.courses = :course")
    List<Student> findByNameAndCourse(@Param("name") String name, @Param("course") String course);

    /**
     * Method to find students by enrollment date between two dates.
     * @param start The start date.
     * @param end The end date.
     * @return A list of students that were enrolled between the start and end dates.
     */
    @Query("SELECT s FROM Student s WHERE s.enrollmentDate BETWEEN :start AND :end")
    List<Student> findByEnrollmentDateBetween(@Param("start") Date start, @Param("end") Date end);

    /**
     * Method to find all students and order them by enrollment date in descending order.
     * @return A list of all students ordered by enrollment date in descending order.
     */
    @Query("SELECT s FROM Student s ORDER BY s.enrollmentDate DESC")
    List<Student> findAllOrderByEnrollmentDateDesc();
}