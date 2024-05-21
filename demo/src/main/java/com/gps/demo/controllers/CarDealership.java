package com.gps.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gps.demo.dtos.RequestCarDealership;
import com.gps.demo.dtos.StandardResponseDTO;
import com.gps.demo.services.CarDealershipService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@RestController
@AllArgsConstructor
@RequestMapping("api/")
@Tag(name = "CRUD Backend")
public class CarDealership {
    private final CarDealershipService carDealershipService;

    // Consultar todos los carros
    @GetMapping("all")
    @Operation(summary = "Consultar todos los carros")
    public ResponseEntity<StandardResponseDTO> getAllPerson() {
        StandardResponseDTO successResponse = new StandardResponseDTO()
                .fullSuccess(carDealershipService.getAllCarDealerships());
        return ResponseEntity.ok(successResponse);
    }

    // Crear un nuevo registro de carro
    @PostMapping("create")
    @Operation(summary = "Crear un nuevo registro de carro")
    public ResponseEntity<StandardResponseDTO> createPerson(@Validated @RequestBody RequestCarDealership request) {
        StandardResponseDTO successResponse = new StandardResponseDTO()
                .fullSuccess(carDealershipService.getAllCarDealerships());
        return ResponseEntity.ok(successResponse);
    }
}
