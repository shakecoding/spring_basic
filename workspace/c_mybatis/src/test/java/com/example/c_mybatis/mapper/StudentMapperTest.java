package com.example.c_mybatis.mapper;

import com.example.c_mybatis.domain.StudentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void selectAllTest (){
        List<StudentVO> studentVOList = studentMapper.selectAll();
        studentVOList.forEach(System.out::println);
        studentVOList.stream().map(StudentVO::toString).forEach(log::info);
    }

    @Test
    public void insertTest (){
        StudentVO studentVO = new StudentVO();
        studentVO.setStudentName("홍길동");
        studentVO.setStudentAge(30);
        studentVO.setStudentGender("남자");
        studentVO.setStudentAddress("창원시");

        studentMapper.insert(studentVO);
    }

    @Test
    public void selectByIdTest (){
        StudentVO studentVO = studentMapper.selectById(1);
        log.info(studentVO.toString());
    }

    @Test
    public void deleteByIdTest (){
        studentMapper.deleteById(1);
    }

    @Test
    public void updateTest (){
        StudentVO studentVO = studentMapper.selectById(2);

        log.info(studentMapper.selectById(2).toString());

        studentVO.setStudentName("강감찬");
        studentMapper.update(studentVO);

        log.info(studentMapper.selectById(2).toString());

    }

}