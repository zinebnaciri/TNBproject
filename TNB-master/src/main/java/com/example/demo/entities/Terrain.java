package com.example.demo.entities;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "terrains")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String terrainName;
    // Add other terrain-related fields and annotations as needed

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}