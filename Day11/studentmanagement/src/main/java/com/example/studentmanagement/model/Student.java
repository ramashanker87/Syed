package com.example.studentmanagement.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String schoolName;
    private int age;
    private String gender;
}
