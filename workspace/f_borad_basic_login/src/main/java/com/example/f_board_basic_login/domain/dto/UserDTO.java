package com.example.f_board_basic_login.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDTO {

    private String userId;
    private String email;
    private String password;
}
