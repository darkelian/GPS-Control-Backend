package com.gps.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCarDealership {
    @NotBlank(message = "La marca es requerida")
    private String brand;
    @NotBlank(message = "La sucursal es requerida")
    private String branch;
    @NotBlank(message = "El solicitante es requerido")
    private String applicant;
}
