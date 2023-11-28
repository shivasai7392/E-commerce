package com.ecommerce.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {
    private String id;
    private Date createdAt;
    private Date updatedAt;
}
