package com.example.b_dependencytest.lombok;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class MemberTest {

    @Test
    void test (){
        Member member = new Member();
        Member member1 = new Member("류호근");

        log.info(member.toString());
        log.info(member1.toString());

    }

}