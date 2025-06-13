package com.simul_tech.netgenius.models;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StudentRequest {
    private String fullName;
    private String groupName;
    private LocalDateTime enrollmentDate;
}