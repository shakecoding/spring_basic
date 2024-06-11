package com.example.f_board_basic_login.service;

import com.example.f_board_basic_login.domain.dto.UserDTO;
import com.example.f_board_basic_login.domain.vo.UserVO;
import com.example.f_board_basic_login.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void saveUser(UserDTO dto) {
        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        UserVO vo = UserVO.toEntity(dto);

        userMapper.insert(vo);
    }
}
