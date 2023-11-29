package com.ecommerce.productservice.services;

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
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public void updateProduct() {

    }

    @Override
    public boolean deleteProductById(Long id) {
        return false;
    }

    @Override
    public void getAllCategories() {

    }

    @Override
    public void getProductByCategory() {

    }
}
