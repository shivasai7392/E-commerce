package com.ecommerce.productservice.inheritancetables.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_students")
public class Student extends User{
    private String collegeName;
    private double psp;
}
