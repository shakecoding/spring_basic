package com.example.f_board_basic_login.service;

import com.example.f_board_basic_login.domain.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PagingService {

    List<ProductDTO> selectProducts(int page, int pageSize);


    int countProducts();
}
