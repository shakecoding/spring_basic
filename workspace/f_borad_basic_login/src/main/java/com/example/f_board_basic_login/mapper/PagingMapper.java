package com.example.f_board_basic_login.mapper;

import com.example.f_board_basic_login.domain.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PagingMapper {

    List<ProductDTO> selectPagingProducts(@Param("startRow") int startRow, @Param("endRow") int endRow);


    int countProducts();

}
