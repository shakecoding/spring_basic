package com.example.d_mybatistask.mapper;

import com.example.d_mybatistask.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class ProductVOMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void findByConditionsTest(){
        List<ProductVO> productVOS = productMapper.findByConditions("Yoga", null, null);
        productVOS.stream().map(ProductVO::toString).forEach(log::info);
        assertThat(productVOS).isNotEmpty();

    }

}