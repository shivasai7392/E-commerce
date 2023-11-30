package com.ecommerce.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private double price;
    private int stock;
    private String category;
}
