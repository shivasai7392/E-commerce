package com.ecommerce.productservice.inheritancetables.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "st_students")
@DiscriminatorValue(value = "2")
public class Student extends User {
    private String collegeName;
    private double psp;
}
