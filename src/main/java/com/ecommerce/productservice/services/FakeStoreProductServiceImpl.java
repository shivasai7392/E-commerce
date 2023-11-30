package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericCategoryDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import com.ecommerce.productservice.thrirdpartyclients.FakeStoreApiAdapter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class FakeStoreProductServiceImpl implements ProductService{

    private final FakeStoreApiAdapter fakeStoreApiAdapter;

    public FakeStoreProductServiceImpl(FakeStoreApiAdapter fakeStoreApiAdapter) {
        this.fakeStoreApiAdapter = fakeStoreApiAdapter;
    }


    private GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setStock(fakeStoreProductDto.getStock());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());

        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreApiAdapter.getAllProducts()) {
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        return convertToGenericProductDto(this.fakeStoreApiAdapter.getProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertToGenericProductDto(this.fakeStoreApiAdapter.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto genericProductDto) {
        return convertToGenericProductDto(this.fakeStoreApiAdapter.updateProduct(id, genericProductDto));
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return convertToGenericProductDto(this.fakeStoreApiAdapter.deleteProductById(id));
    }

    @Override
    public List<GenericCategoryDto> getAllCategories() {
        List<String> categories = this.fakeStoreApiAdapter.getAllCategories();
        List<GenericCategoryDto> genericCategoryDtos = new ArrayList<>();
        for (String category : categories) {
            GenericCategoryDto genericCategoryDto = new GenericCategoryDto();
            genericCategoryDto.setName(category);
            genericCategoryDtos.add(genericCategoryDto);
        }
        return genericCategoryDtos;
    }

    @Override
    public List<GenericProductDto> getProductByCategory(String category) {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : this.fakeStoreApiAdapter.getProductByCategory(category)) {
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;
    }
}
