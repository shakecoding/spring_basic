package com.example.springtest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 자바의 메인 메소드와 같은 역할, 스프링 부트 프로젝트의 시작 지점!
// 이 어노테이션은 스프링 부트 사용에 필요한 기본 설정을 해준다.
@SpringBootApplication
public class SpringTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringTest1Application.class, args);
	}

}
