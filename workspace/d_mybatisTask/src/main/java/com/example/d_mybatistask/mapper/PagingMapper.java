package com.example.d_mybatistask.mapper;

import com.example.d_mybatistask.domain.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PagingMapper {

    List<ProductDTO> selectPagingProducts(@Param("startRow") int startRow, @Param("endRow") int endRow);


    int countProducts();

}
