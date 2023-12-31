package com.example.intellifishbackend.controllers.dtos.requests;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
public class CreatePlantRequest {
    @NotBlank
    @NotNull
    private String species;

    @NotBlank
    @NotNull
    private String imageUrl ;
}
