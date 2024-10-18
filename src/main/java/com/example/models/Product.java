package com.example.models;

import com.example.models.enums.ProductState;
import jakarta.persistence.*;
import lombok.*;

@Entity//se usa para indicar que esta clase va a ser una tabla en la base de datos
@NoArgsConstructor//crea un constructor vacio
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    @Enumerated(EnumType.STRING)
    private ProductState productState = ProductState.AVAILABLE;


    public Product(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
}
