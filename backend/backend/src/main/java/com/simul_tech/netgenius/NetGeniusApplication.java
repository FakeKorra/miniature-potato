package com.simul_tech.netgenius;

import com.simul_tech.netgenius.models.Student;
import com.simul_tech.netgenius.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NetGeniusApplicationTests {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testCreateAndFindStudent() {
        Student student = new Student();
        student.setFullName("Иван Иванов");
        student.setGroupName("Группа 101");
        studentRepository.save(student);

        Student found = studentRepository.findById(student.getId()).orElse(null);
        assertNotNull(found);
        assertEquals("Иван Иванов", found.getFullName());
    }
}