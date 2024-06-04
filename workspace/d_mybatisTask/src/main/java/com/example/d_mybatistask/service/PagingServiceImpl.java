package com.example.d_mybatistask.service;

import com.example.d_mybatistask.domain.dto.ProductDTO;
import com.example.d_mybatistask.mapper.PagingMapper;
import com.example.d_mybatistask.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
