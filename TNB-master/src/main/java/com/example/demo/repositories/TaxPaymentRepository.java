package com.example.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.*;


public interface TaxPaymentRepository extends JpaRepository<TaxPayment, Long> {
   
}

	 
