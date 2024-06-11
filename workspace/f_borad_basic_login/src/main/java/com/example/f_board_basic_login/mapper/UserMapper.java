package com.example.f_board_basic_login.mapper;

import com.example.f_board_basic_login.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insert(UserVO vo);

    UserVO selectOne(String userId);

}
