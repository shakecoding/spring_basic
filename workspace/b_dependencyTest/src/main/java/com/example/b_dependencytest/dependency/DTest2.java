package com.example.b_dependencytest.dependency;

import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class DTest2 {

    private final DTest dTest;

//    @Autowired
//    어노테이션은 있어도 되고 없어도 된다.
    public DTest2(DTest dTest, AopAutoConfiguration aopAutoConfiguration) {
        this.dTest = dTest;
    }

    public void print2(){
        dTest.print();
    }

}
