package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.GenericCategoryDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.ProductNotFoundException;
import com.ecommerce.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    //Constructor Injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return this.productService.getProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return this.productService.createProduct(genericProductDto);
    }

    @PutMapping("/{id}")
    public GenericProductDto updateProduct(@PathVariable("id") Long id,@RequestBody GenericProductDto genericProductDto){
        return this.productService.updateProduct(id, genericProductDto);
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
        return this.productService.deleteProductById(id);
    }

    @GetMapping("/categories")
    public List<GenericCategoryDto> getAllCategories(){
        return this.productService.getAllCategories();
    }

    @GetMapping("/category/{category}")
    public List<GenericProductDto> getProductByCategory(@PathVariable("category") String category){
        return this.productService.getProductByCategory(category);
    }
}
