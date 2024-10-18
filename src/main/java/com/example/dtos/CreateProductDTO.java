package com.example.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateProductDTO {

    @NotBlank(message = "The name of the product cannot be empty")
    private String name;
    @NotBlank(message = "The description of the product cannot be empty")
    private String description;
    @NotNull(message = "The price of the product cannot be null")
    private Double price;
    @NotNull(message = "The Stock of the product cannot be null")
    private int stock;
}
