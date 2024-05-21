package com.gps.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gps.demo.models.CarDealership;

public interface CarDealershipRepository extends JpaRepository<CarDealership, Long> {
    
}