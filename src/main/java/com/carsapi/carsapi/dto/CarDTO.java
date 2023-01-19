package com.carsapi.carsapi.dto;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

public record CarDTO(

@NotBlank
String modelo, 

@NotBlank
String fabricante, 

@Past
Date dataFabricacao, 

@NotNull
@Positive
@Min(1000)
double valor, 

@NotNull
int anoModelo
) {    
}
