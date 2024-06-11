package com.example.f_board_basic_login.domain.vo;

import com.example.f_board_basic_login.domain.dto.UserDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@Getter
@NoArgsConstructor
@ToString
// Spring security 의 UserDetails 를 지정 받아
// 해당 객체를 이용하여 사용자의 인증 및 권한을 처리할 수 있도록 한다.
public class UserVO implements UserDetails {

    private Long id;
    private String userId;
    private String email;
    private String password;

    @Builder
    public UserVO(Long id, String userId, String email, String password) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public static UserVO toEntity(UserDTO userDTO){
        return UserVO.builder().email(userDTO.getEmail())
                .userId(userDTO.getUserId())
                .password(userDTO.getPassword())
                .build();
    }



    // 사용자에게 부여된 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("basic"));
    }

    // 로그인 ID 
    @Override
    public String getUsername() {
        return userId;
    }

    // 패스워드
    @Override
    public String getPassword() {
        return password;
    }
    
    // 계정의 만료 여부
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정의 잠김 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 자격 증명 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정의 활성화 여부
    @Override
    public boolean isEnabled() {
        return true;
    }
}
