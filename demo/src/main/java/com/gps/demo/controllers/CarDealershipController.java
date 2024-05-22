package com.gps.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gps.demo.dtos.RequestCarDealership;
import com.gps.demo.dtos.StandardResponseDTO;
import com.gps.demo.models.CarDealership;
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
public class CarDealershipController {
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
        public ResponseEntity<StandardResponseDTO> createCarDealerships(
                        @Validated @RequestBody RequestCarDealership request) {
                StandardResponseDTO successResponse = new StandardResponseDTO()
                                .fullSuccess(carDealershipService.createCarDealership(request));
                return ResponseEntity.ok(successResponse);
        }

        // Eliminar un carro por
        @DeleteMapping("delete")
        @Operation(summary = "Eliminar un carro por marca, sucursal y solicitante")
        public ResponseEntity<StandardResponseDTO> deleteCarDealership(
                        @Validated @RequestBody RequestCarDealership request) {
                carDealershipService.deleteCarDealership(request);
                StandardResponseDTO response = new StandardResponseDTO()
                                .fullSuccess("Registro de " + request.getBrand() + " eliminado correctamente");
                return new ResponseEntity<>(response, HttpStatus.OK);
        }

        // Actualizar un registro de carro
        @PutMapping("update")
        @Operation(summary = "Eliminar un carro por marca, sucursal y solicitante")
        public ResponseEntity<StandardResponseDTO> updateCarDealershipById(
                        @Validated @RequestBody CarDealership request) {
                carDealershipService.updateCarDealership(request);
                StandardResponseDTO response = new StandardResponseDTO()
                                .fullSuccess("Registro de " + request.getApplicant() + " actualizado correctamente");
                return new ResponseEntity<>(response, HttpStatus.OK);
        }
}
