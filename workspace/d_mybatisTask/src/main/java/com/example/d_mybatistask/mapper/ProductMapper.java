package com.example.d_mybatistask.mapper;

import com.example.d_mybatistask.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> findByConditions(String name, String category, Double price);


}
