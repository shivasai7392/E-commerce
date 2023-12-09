package com.ecommerce.productservice.inheritancetables.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_tas")
@PrimaryKeyJoinColumn(name = "user_id")
public class Ta extends User {
    private double salary;
    private double averageRating;
}
