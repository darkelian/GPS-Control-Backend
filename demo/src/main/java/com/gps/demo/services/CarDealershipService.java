package com.gps.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gps.demo.dtos.RequestCarDealership;
import com.gps.demo.models.CarDealership;
import com.gps.demo.repositories.CarDealershipRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Service
@AllArgsConstructor
public class CarDealershipService {
    private final CarDealershipRepository carDealershipRepository;

    // Eliminar un carro por id
    @Transactional
    public void deleteCarDealership(Long id) {
        carDealershipRepository.deleteById(id);
    }

    // Consultar todos los carros
    @Transactional
    public List<CarDealership> getAllCarDealerships() {
        return carDealershipRepository.findAll();
    }

    // Consultar un carro por id
    @Transactional
    public CarDealership getCarDealershipById(Long id) {
        return carDealershipRepository.findById(id).orElse(null);
    }

    // Actualizar un carro
    @Transactional
    public CarDealership updateCarDealership(CarDealership carDealership) {
        return carDealershipRepository.save(carDealership);
    }

    // Crear un carro
    @Transactional
    public CarDealership createCarDealership(RequestCarDealership request) {
        Optional<CarDealership> existingCarDealership = carDealershipRepository.findByBrandAndBranchAndApplicant(
                request.getBrand(), request.getBranch(), request.getApplicant());

        if (existingCarDealership.isPresent()) {
            throw new DataIntegrityViolationException(
                    "Ya hay un registro con la marca, sucursal y solicitante proporcionados.");
        }
        CarDealership carDealership = new CarDealership();
        carDealership.setBrand(request.getBrand());
        carDealership.setBranch(request.getBranch());
        carDealership.setApplicant(request.getApplicant());
        return carDealershipRepository.save(carDealership);
    }
}
