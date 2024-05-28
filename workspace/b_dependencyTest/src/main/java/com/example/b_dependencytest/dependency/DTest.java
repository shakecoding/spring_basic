package com.example.b_dependencytest.dependency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

// 스프링 컨테이너에 등록하는 어노테이션
@Component
@Slf4j
public class DTest {

    public void print (){
        System.out.println("테스트 중");
        log.info("테스트 중");
    }

}
