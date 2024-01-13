package com.example.demo.controllers;

//TaxPaymentController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.TaxPayment;
import com.example.demo.repositories.TaxPaymentRepository;
import com.example.demo.repositories.UserRepository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/tax-payments")
public class TaxPaymentController {

 private final TaxPaymentRepository taxPaymentRepository;
 private final UserRepository userRepository;

 @Autowired
 public TaxPaymentController(TaxPaymentRepository taxPaymentRepository, UserRepository userRepository) {
     this.taxPaymentRepository = taxPaymentRepository;
     this.userRepository = userRepository;
 }

 @GetMapping
 public List<TaxPayment> getAllTaxPayments() {
     return taxPaymentRepository.findAll();
 }

 @PostMapping("/create")
 public TaxPayment createTaxPayment(@RequestBody TaxPayment taxPayment) {
     // You might want to perform additional validation or business logic here
     return taxPaymentRepository.save(taxPayment);
 }

 @GetMapping("/{id}")
 public TaxPayment getTaxPaymentById(@PathVariable Long id) {
     return taxPaymentRepository.findById(id).orElse(null);
 }

 @PutMapping("/{id}/mark-as-paid")
 public TaxPayment markTaxPaymentAsPaid(@PathVariable Long id) {
     return taxPaymentRepository.findById(id)
             .map(taxPayment -> {
                 LocalDateTime currentDateTime = LocalDateTime.now();
                 taxPayment.setPaymentDate(Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant()));
                 // You might want to perform additional logic here, e.g., update tax payment status
                 return taxPaymentRepository.save(taxPayment);
             })
             .orElse(null);
 }

 // Other methods for updating, deleting, etc.
}
