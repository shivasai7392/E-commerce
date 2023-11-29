package com.ecommerce.productservice.dtos;

import com.ecommerce.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FakeStoreProductDto {
    private String title;
    private String description;
    private List<String> images;
    private double price;
    private int stock;
    private FakeStoreCategoryDto category;
}
