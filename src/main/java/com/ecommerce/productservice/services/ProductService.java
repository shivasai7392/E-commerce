package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.GenericCategoryDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<GenericProductDto> getAllProducts();
    GenericProductDto getProductById(Long id) throws ProductNotFoundException;
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    GenericProductDto updateProduct(Long id, GenericProductDto genericProductDto);
    GenericProductDto deleteProductById(Long id);
    List<GenericCategoryDto> getAllCategories();
    List<GenericProductDto> getProductByCategory(String category);
}
