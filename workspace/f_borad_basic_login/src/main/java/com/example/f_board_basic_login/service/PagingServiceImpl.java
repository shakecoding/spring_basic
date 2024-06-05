package com.example.f_board_basic_login.service;

import com.example.f_board_basic_login.domain.dto.ProductDTO;
import com.example.f_board_basic_login.mapper.PagingMapper;
import com.example.f_board_basic_login.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagingServiceImpl implements PagingService {

    private final PagingMapper pagingMapper;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> selectProducts(int page, int pageSize) {
        int startRow = (page - 1) * pageSize;
        int endRow = startRow + pageSize;
        return pagingMapper.selectPagingProducts(startRow, endRow);
    }


    @Override
    public int countProducts() {
        return pagingMapper.countProducts();
    }
}
