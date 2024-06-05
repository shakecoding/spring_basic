package com.example.f_board_basic_login.service;

import com.example.f_board_basic_login.domain.dto.ProductDTO;
import com.example.f_board_basic_login.domain.dto.ProductDetailDTO;
import com.example.f_board_basic_login.domain.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductDTO> selectList();

    ProductDetailDTO findById(long id);

    int insert(ProductVO vo);

    void updateProductD(ProductVO vo);

    void updateProduct(ProductVO vo);

    int deleteById(long id);

}
