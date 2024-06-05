package com.example.f_board_basic_login.domain.vo;

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
