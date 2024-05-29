package com.example.c_mybatis.mapper;

import com.example.c_mybatis.domain.StudentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<StudentVO> selectAll();

    void insert(StudentVO studentVO);

    StudentVO selectById(long id);

    void deleteById(long id);

    void update(StudentVO studentVO);
}
