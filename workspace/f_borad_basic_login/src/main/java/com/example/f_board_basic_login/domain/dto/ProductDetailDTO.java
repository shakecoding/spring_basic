package com.example.f_board_basic_login.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductDetailDTO {

    private Long id;
    private String name;
    private Double price;
    private String category;
    private String description;

}
