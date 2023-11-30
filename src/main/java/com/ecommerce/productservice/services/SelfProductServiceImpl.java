package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.GenericCategoryDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id){
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public List<GenericCategoryDto> getAllCategories() {
        return null;
    }

    @Override
    public List<GenericProductDto> getProductByCategory(String category) {
        return null;
    }
}
