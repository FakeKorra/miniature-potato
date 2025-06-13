package com.simul_tech.netgenius.repositories;

import com.simul_tech.netgenius.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFullNameContainingIgnoreCase(String fullName);
    List<Student> findByGroupName(String groupName);
    List<Student> findByEnrollmentDateBetween(LocalDateTime start, LocalDateTime end);
    
    @Query("SELECT s FROM Student s WHERE " +
           "(:id IS NULL OR s.id = :id) AND " +
           "(:fullName IS NULL OR s.fullName LIKE %:fullName%) AND " +
           "(:groupName IS NULL OR s.groupName = :groupName) AND " +
           "(:enrollmentDate IS NULL OR s.enrollmentDate >= :enrollmentDate)")
    List<Student> findWithFilters(
            @Param("id") Long id,
            @Param("fullName") String fullName,
            @Param("groupName") String groupName,
            @Param("enrollmentDate") LocalDateTime enrollmentDate);
}