package com.simul_tech.netgenius.controllers;

import com.simul_tech.netgenius.models.Student;
import com.simul_tech.netgenius.models.StudentRequest;
import com.simul_tech.netgenius.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student Management")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @Operation(summary = "Add a new student")
    public ResponseEntity<Student> addStudent(@RequestBody StudentRequest request) {
        Student student = new Student();
        student.setFullName(request.getFullName());
        student.setGroupName(request.getGroupName());
        if (request.getEnrollmentDate() != null) {
            student.setEnrollmentDate(request.getEnrollmentDate());
        }
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping
    @Operation(summary = "Get all students with optional filtering")
    public ResponseEntity<List<Student>> getStudents(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String groupName,
            @RequestParam(required = false) LocalDateTime enrollmentDate) {
        return ResponseEntity.ok(studentService.filterStudents(id, fullName, groupName, enrollmentDate));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get student by ID")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update student information")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentRequest request) {
        Student student = new Student();
        student.setFullName(request.getFullName());
        student.setGroupName(request.getGroupName());
        Student updatedStudent = studentService.updateStudent(id, student);
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a student")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}