package com.ecommerce.productservice.inheritancetables.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_tas")
@DiscriminatorValue(value = "1")
public class Ta extends User {
    private double salary;
    private double averageRating;
}
