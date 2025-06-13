package com.simul_tech.netgenius.services;

import com.simul_tech.netgenius.models.Student;
import com.simul_tech.netgenius.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setFullName(studentDetails.getFullName());
            student.setGroupName(studentDetails.getGroupName());
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> filterStudents(Long id, String fullName, String groupName, LocalDateTime enrollmentDate) {
        return studentRepository.findWithFilters(id, fullName, groupName, enrollmentDate);
    }
}