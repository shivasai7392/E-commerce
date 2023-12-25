package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.GenericCategoryDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    SelfProductServiceImpl(ProductRepository productRepository){

        this.productRepository = productRepository;
    }
    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id){
        GenericProductDto genericProductDto = new GenericProductDto();
        this.productRepository.findById(UUID.fromString("89729269-8554-4e4e-a76c-78627dfbc549")).ifPresent(product -> {
            genericProductDto.setId(1L);
            genericProductDto.setTitle(product.getTitle());
            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setImage(product.getImage());
            genericProductDto.setPrice(product.getPrice().getValue());
            genericProductDto.setStock(product.getStock());
            genericProductDto.setCategory(product.getCategory().getName());
        });
        return genericProductDto;
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
