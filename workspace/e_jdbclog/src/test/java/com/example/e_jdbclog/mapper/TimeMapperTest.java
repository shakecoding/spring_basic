package com.example.e_jdbclog.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class TimeMapperTest {

    @Autowired
    private TimeMapper timeMapper;

    @Test
    public void test (){
        log.info("timeMapper : " + timeMapper);
        log.info(timeMapper.getTimeQuick());
    }
}