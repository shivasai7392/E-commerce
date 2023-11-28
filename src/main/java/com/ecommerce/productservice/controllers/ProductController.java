package com.ecommerce.productservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public void getAllProducts(){

    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id){
        return "Product @@@@ with id " + id;
    }

    public void createProduct(){

    }

    public void updateProduct(){

    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id){

    }

    public void getAllCategories(){

    }

    public void getProductByCategory(){

    }
}
