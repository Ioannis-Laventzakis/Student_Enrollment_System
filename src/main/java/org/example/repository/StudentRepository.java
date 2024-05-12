package org.example.student_enrollment_system.repository;

import java.util.Date;
import java.util.List;

import org.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Standard CRUD methods are automatically provided

    // Custom Operations can be added
    // find the student by name

    //1. Spring Data JPA will automatically generate the SELECT query for this method.
    // List<Student> findByAttributeName(String name);


//2. Using JPQL (Java Persistence Query Language)
    //  @Query("SELECT st FROM Student st WHERE st.name = :name") // JPQL
    //  List<Student> findByAttributeName(@Param("name") String name);

//3. Native SQL
    //  @Query(value = "SELECT * FROM students WHERE name = :name", nativeQuery = true)
    //  List<Student> findByAttributeName(@Param("name") String name);
// 4. Using Named Query
// List<Student> findByAttributeName(@Param("name") String name);

    // Find Students by Course
    List<Student> findByCourses(String course);


    // Find Students enrolled after a certain date : using JPQL
    @Query("SELECT s FROM Student s WHERE s.enrollmentDate > :certainDate ")
    List<Student> findStudentsEnrolledAfter(@Param("certainDate") Date date);

    // Find students by name containing a string
    List<Student> findByNameContaining( String name);

}
