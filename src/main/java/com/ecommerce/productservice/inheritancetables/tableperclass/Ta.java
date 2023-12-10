package com.ecommerce.productservice.inheritancetables.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity(name = "tpc_tas")
public class Ta extends User {
    private double salary;
    private double averageRating;
}
