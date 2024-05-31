package com.example.d_mybatistask.service;

import com.example.d_mybatistask.domain.dto.ProductDTO;
import com.example.d_mybatistask.domain.dto.ProductDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductDTO> selectList();

    ProductDetailDTO findById(long id);

}
