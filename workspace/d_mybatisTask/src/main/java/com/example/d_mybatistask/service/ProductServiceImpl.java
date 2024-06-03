package com.example.d_mybatistask.service;

import com.example.d_mybatistask.domain.dto.ProductDTO;
import com.example.d_mybatistask.domain.dto.ProductDetailDTO;
import com.example.d_mybatistask.domain.vo.ProductVO;
import com.example.d_mybatistask.mapper.ProductMapper;
import com.example.d_mybatistask.mapper.ProductMapper2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper2 productMapper2;


    @Override
    public List<ProductDTO> selectList() {

        return productMapper2.selectList();
    }

    @Override
    public ProductDetailDTO findById(long id) {

        return productMapper2.findById(id);
    }

    @Override
    public int insert(ProductVO vo) {
        return productMapper2.insertProduct(vo);
    }

    @Override
    public void updateProductD(ProductVO vo) {
        productMapper2.updateProductD(vo);
    }

    @Override
    public void updateProduct(ProductVO vo) {
        productMapper2.updateProduct(vo);
    }

    @Override
    public int deleteById(long id) {
        return productMapper2.deleteById(id);
    }
}
