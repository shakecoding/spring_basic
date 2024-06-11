package com.example.f_board_basic_login.controller;

import com.example.f_board_basic_login.domain.dto.UserDTO;
import com.example.f_board_basic_login.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/login/login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "/login/signup";
    }

    @PostMapping("/signup")
    public String signUp(UserDTO dto) {

        log.info(dto.toString());

      userService.saveUser(dto);
      return "/login/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/product/list";
    }

}
