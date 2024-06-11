package com.example.f_board_basic_login.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // Spring Security 의 웹 보안을 활성화 하겠다.
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

//    @Bean
//    public WebSecurityCustomizer configure() {
//        return (web) -> web.ignoring()
//                .requestMatchers(new AntPathRequestMatcher("/static/**"));
//    }

    // 필터 체인을 구성한다.
    // http 요청에 대한 보안을 구성한다.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        전체에 접근 할 수 있게끔 부여!
//        return http.authorizeHttpRequests((authorize) ->
//                authorize.anyRequest().permitAll()).build();

        return http
                // 요청에 대한 인가를 설정한다.
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                new AntPathRequestMatcher("/user/login"),
                                new AntPathRequestMatcher("/user/signup"),
                                new AntPathRequestMatcher("/product/list"),
                                new AntPathRequestMatcher("/product")
                        ).permitAll() // 특정 요청에 대한 접근을 허용한다.
                        .anyRequest().authenticated() // 나머지 요청들은 인가를 요구할 것이다.
                )
                // 로그인을 폼 기반으로 구성할 것이다.
                .formLogin(formLogin -> formLogin
                        .loginPage("/user/login") // 내가 사용할 로그인 페이지를 설정.
                        .usernameParameter("userId") // 사용자 ID 필드의 이름을 설정.
                        .passwordParameter("password") // 비밀번호 필드의 이름 설정, 같으면 생략도 가능
                        .successHandler(loginSuccessHandler()) // 로그인 성공 시 호출되는 핸들러를 설정!
                        .failureUrl("/user/login?error=true") // 로그인 실패 시 리다이렉트될 URL 설정
                )
                // 로그아웃을 구성
                .logout(logout -> logout
                        .logoutUrl("/user/logout") // 로그아웃 URI 설정
//                        .logoutSuccessHandler(logoutSuccessHandler())
                        .invalidateHttpSession(true) // 현재 세션을 전부 무효화 한다.
                )
                // 세션 관리 설정 추가
                // application.properties 에 추가!
                .sessionManagement(sessionManagement -> sessionManagement
//                        .invalidSessionUrl("/user/login?invalidSession=true") // 세션이 유효하지 않을 때 이동할 URL 설정
                        .maximumSessions(1) // 동시 세션 허용 개수 설정
                        .expiredUrl("/user/login?expired=true") // 세션 만료 시 이동할 URL 설정
//                        .maxSessionsPreventsLogin(true) // true 설정 시, 새로운 로그인 시도가 이전 세션을 만료시키지 않음
                )
                .build();
    }

    // 사용자가 로그인 할 때, 이 친구가 인증 요청을 처리한다.
    @Bean
    public AuthenticationManager authenticationManager(BCryptPasswordEncoder bCryptPasswordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService); // 사용자 정보를 로드 할 때 사용할 서비스
        authProvider.setPasswordEncoder(bCryptPasswordEncoder); // 암호화 기법 설정.
        return new ProviderManager(authProvider);
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return (request, response, authentication) -> {
            response.sendRedirect("/product/list");
        };
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            response.sendRedirect("/product/list");
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
