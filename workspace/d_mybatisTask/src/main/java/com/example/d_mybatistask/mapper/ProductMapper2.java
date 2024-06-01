package com.example.d_mybatistask.mapper;

import com.example.d_mybatistask.domain.dto.ProductDTO;
import com.example.d_mybatistask.domain.dto.ProductDetailDTO;
import com.example.d_mybatistask.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper2 {

    List<ProductDTO> selectList();

    ProductDetailDTO findById(long id);

    void insertProduct(ProductVO vo);

    void updateProductD(ProductVO vo);

    void updateProduct(ProductVO vo);

    int deleteById(long id);

}
