package com.example.f_board_basic_login.mapper;


import com.example.f_board_basic_login.domain.dto.ProductDTO;
import com.example.f_board_basic_login.domain.dto.ProductDetailDTO;
import com.example.f_board_basic_login.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper2 {

    List<ProductDTO> selectList();

    ProductDetailDTO findById(long id);

    int insertProduct(ProductVO vo);

    void updateProductD(ProductVO vo);

    void updateProduct(ProductVO vo);

    int deleteById(long id);

}
