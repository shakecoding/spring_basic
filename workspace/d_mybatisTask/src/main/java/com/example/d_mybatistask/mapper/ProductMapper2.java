package com.example.d_mybatistask.mapper;

import com.example.d_mybatistask.domain.dto.ProductDTO;
import com.example.d_mybatistask.domain.dto.ProductDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper2 {

    List<ProductDTO> selectList();

    ProductDetailDTO findById(long id);

}
