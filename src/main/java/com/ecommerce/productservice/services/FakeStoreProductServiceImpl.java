package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{
    private final RestTemplateBuilder restTemplateBuilder;
    private String productsUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImages());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setStock(fakeStoreProductDto.getStock());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
//        genericProductDto.setCategoryId(fakeStoreProductDto.getCategory().getId());

        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(productsUrl, FakeStoreProductDto[].class);
        List<GenericProductDto> genericProductDtoList = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : responseEntity.getBody()) {
            genericProductDtoList.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtoList;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(productsUrl+"/"+id, FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product with id: "+id+" not found");
        }

        return convertToGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(productsUrl, genericProductDto, FakeStoreProductDto.class);
        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public void updateProduct() {

    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(productsUrl+"/"+id, HttpMethod.DELETE,
                requestCallback, responseExtractor);
        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public void getAllCategories() {

    }

    @Override
    public void getProductByCategory() {

    }
}
