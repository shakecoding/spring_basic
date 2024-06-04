package com.example.d_mybatistask.service;

import com.example.d_mybatistask.domain.dto.ProductDTO;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PagingService {

    List<ProductDTO> selectProducts(int page, int pageSize);


    int countProducts();
}
