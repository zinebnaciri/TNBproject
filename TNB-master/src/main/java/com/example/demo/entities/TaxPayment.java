package com.example.demo.entities;

import lombok.*;


import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "tax_payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private Date paymentDate;
    // Add other tax payment-related fields and annotations as needed

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}