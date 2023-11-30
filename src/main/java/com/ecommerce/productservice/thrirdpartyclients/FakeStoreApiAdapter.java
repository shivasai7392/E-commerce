package com.ecommerce.productservice.thrirdpartyclients;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
public class FakeStoreApiAdapter{
    private final RestTemplateBuilder restTemplateBuilder;
    private final String productsUrl;
    private final String categoriesUrl;
    private final String categoryUrl;

    public FakeStoreApiAdapter(RestTemplateBuilder restTemplateBuilder,
                               @Value("${fakestore.api.url}") String fakeStoreApiUrl,
                               @Value("${fakestore.api.path.products}") String pathForProducts,
                               @Value("${fakestore.api.path.categories}") String pathForCategories,
                               @Value("${fakestore.api.path.category}") String pathForCategory) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productsUrl = fakeStoreApiUrl+pathForProducts;
        this.categoriesUrl = fakeStoreApiUrl+pathForCategories;
        this.categoryUrl = fakeStoreApiUrl+pathForCategory;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(productsUrl, FakeStoreProductDto[].class);
        return List.of(Objects.requireNonNull(responseEntity.getBody()));
    }

    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(productsUrl+"/"+id, FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product with id: "+id+" not found");
        }

        return fakeStoreProductDto;
    }

    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(productsUrl, genericProductDto, FakeStoreProductDto.class);
        return responseEntity.getBody();
    }

    public FakeStoreProductDto updateProduct(Long id, GenericProductDto genericProductDto) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        HttpEntity<GenericProductDto> genericProductDtoHttpEntity = new HttpEntity<>(genericProductDto);
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.exchange(productsUrl+"/"+id, HttpMethod.PUT, genericProductDtoHttpEntity, FakeStoreProductDto.class);
        return responseEntity.getBody();
    }

    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(productsUrl+"/"+id, HttpMethod.DELETE,
                requestCallback, responseExtractor);
        return Objects.requireNonNull(responseEntity).getBody();
    }

    public List<String> getAllCategories() {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<String[]> responseEntity =
                restTemplate.getForEntity(categoriesUrl, String[].class);
        return List.of(Objects.requireNonNull(responseEntity.getBody()));
    }

    public List<FakeStoreProductDto> getProductByCategory(String category) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(categoryUrl+"/"+category, FakeStoreProductDto[].class);
        return List.of(Objects.requireNonNull(responseEntity.getBody()));
    }
}
