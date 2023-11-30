package com.ecommerce.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private double price;
    private int stock;
    private String category;
    private Long categoryId;
}
