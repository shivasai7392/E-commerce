package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    List<GenericProductDto> getAllProducts();
    GenericProductDto getProductById(Long id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    void updateProduct();
    boolean deleteProductById(Long id);
    void getAllCategories();
    void getProductByCategory();
}
