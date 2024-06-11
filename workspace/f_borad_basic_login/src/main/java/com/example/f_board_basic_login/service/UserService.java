package com.example.f_board_basic_login.service;

import com.example.f_board_basic_login.domain.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void saveUser(UserDTO dto);

}
