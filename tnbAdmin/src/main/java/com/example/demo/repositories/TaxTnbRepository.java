package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.TaxTnb;

@Repository
public interface TaxTnbRepository extends JpaRepository<TaxTnb, Long> {
   
}

