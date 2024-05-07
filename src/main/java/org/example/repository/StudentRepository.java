package org.example.repository;

import org.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // This interface extends the JpaRepository interface.
    // custom operation


}