package com.ecommerce.productservice.inheritancetables.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "ms_tas")
public class Ta extends User{
    private double salary;
    private double averageRating;
}
