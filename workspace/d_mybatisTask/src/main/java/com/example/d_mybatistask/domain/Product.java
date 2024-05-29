package com.example.d_mybatistask.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Product {

    private Long id;
    private String name;
    private Double price;
    private String category;
    private String description;

}
