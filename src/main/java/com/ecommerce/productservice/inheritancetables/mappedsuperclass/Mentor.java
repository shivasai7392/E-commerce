package com.ecommerce.productservice.inheritancetables.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "ms_mentors")
public class Mentor extends User{
    private double salary;
    private double averageRating;
}
