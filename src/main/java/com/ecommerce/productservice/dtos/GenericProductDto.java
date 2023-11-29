package com.ecommerce.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenericProductDto {
    private String title;
    private String description;
    private List<String> images;
    private double price;
    private int stock;
    private String category;
    private Long categoryId;
}
