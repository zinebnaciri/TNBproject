package com.example.demo.entities;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    // Add other profile-related fields and annotations as needed

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}