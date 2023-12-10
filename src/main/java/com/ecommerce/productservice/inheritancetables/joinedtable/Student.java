package com.ecommerce.productservice.inheritancetables.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "j_students")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {
    private String collegeName;
    private double psp;
}
