package com.example.d_mybatistask.mapper;

import com.example.d_mybatistask.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductVO> findByConditions(String name, String category, Double price);


}
