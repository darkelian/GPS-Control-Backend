package com.gps.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gps.demo.services.CarDealershipService;

import io.swagger.v3.oas.annotations.Operation;
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
    @PostMapping("all")
    @Operation(summary = "Consultar todos los carros")
    public Object getAllCarDealerships() {
        return carDealershipService.getAllCarDealerships();
    }
}
