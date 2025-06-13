package com.simul_tech.netgenius.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String groupName;

    @Column(nullable = false)
    private LocalDateTime enrollmentDate = LocalDateTime.now();
}