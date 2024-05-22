package com.gps.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gps.demo.models.CarDealership;

public interface CarDealershipRepository extends JpaRepository<CarDealership, Long> {
    // Consultar si ya hay un registro
    Optional<CarDealership> findByBrandAndBranchAndApplicant(String brand, String branch, String applicant);

    void deleteByBrandAndBranchAndApplicant(String brand, String branch, String applicant);
}