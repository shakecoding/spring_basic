package com.example.d_mybatistask.mapper;

import com.example.d_mybatistask.domain.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ProductMapper2Test {

    @Autowired
    private ProductMapper2 productMapper2;

    @Test
    void selectListTest(){

        productMapper2.selectList().stream().map(ProductDTO::toString).forEach(log::info);

    }

}