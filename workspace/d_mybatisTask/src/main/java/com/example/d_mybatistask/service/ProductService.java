package com.example.d_mybatistask.service;

import com.example.d_mybatistask.domain.dto.ProductDTO;
import com.example.d_mybatistask.domain.dto.ProductDetailDTO;
import com.example.d_mybatistask.domain.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductDTO> selectList();

    ProductDetailDTO findById(long id);

    void insert(ProductVO vo);

    void updateProductD(ProductVO vo);

    void updateProduct(ProductVO vo);

    int deleteById(long id);

}
