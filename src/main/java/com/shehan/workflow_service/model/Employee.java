package com.shehan.workflow_service.model;


import jakarta.persistence.*;
import lombok.*;

// Generates getter methods for all fields in the class
@Getter
// Generates setter methods for all fields in the class
@Setter
// Generates a no-argument constructor
@NoArgsConstructor
// Generates a constructor with parameters for all fields
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name="email_id" ,nullable = false,unique = true)
    private String email;

}
