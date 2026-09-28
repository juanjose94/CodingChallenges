package org.example.technical_tests.meli.sample_crud_controller;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private Double price;
    private String category;
}
