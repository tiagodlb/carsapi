package com.carsapi.carsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carsapi.carsapi.model.carModel;


public interface carsRepository extends JpaRepository<carModel, Long> {
    
}
