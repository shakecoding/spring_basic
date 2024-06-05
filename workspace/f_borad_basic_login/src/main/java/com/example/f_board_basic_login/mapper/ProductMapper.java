package com.example.f_board_basic_login.mapper;

import com.example.f_board_basic_login.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductVO> findByConditions(String name, String category, Double price);


}
