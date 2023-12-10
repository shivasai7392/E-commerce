package com.ecommerce.productservice.inheritancetables.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "tpc_students")
public class Student extends User {
    private String collegeName;
    private double psp;
}
