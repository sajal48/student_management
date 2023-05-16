package com.sajal.student_management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    private String courseId;
    private String courseName;
    @Column(length = 1000)
    private String courseDescription;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "courses")
    @JsonIgnore
    private Set<Student> enrolledStudents = new HashSet<>();

}
