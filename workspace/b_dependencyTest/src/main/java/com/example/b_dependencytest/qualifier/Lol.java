package com.example.b_dependencytest.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Lol implements Game {

    @Override
    public void play() {
        log.info("Game : " + "리그오브레전드");
    }
}
