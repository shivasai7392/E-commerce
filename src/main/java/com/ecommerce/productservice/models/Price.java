package com.ecommerce.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "prices")
public class Price extends BaseModel{
    private double value;
    private String currency;
}
