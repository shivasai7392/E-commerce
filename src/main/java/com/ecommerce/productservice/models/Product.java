package com.ecommerce.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;
    private int stock;
    @ManyToOne(optional = false)
    private Category category;
    @OneToOne(optional = false, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(nullable = false)
    private Price price;
}
