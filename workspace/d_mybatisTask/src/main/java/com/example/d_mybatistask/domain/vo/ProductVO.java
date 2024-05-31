package com.example.d_mybatistask.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {

    private Long id;
    private String name;
    private Double price;
    private String category;
    private String description;

}
