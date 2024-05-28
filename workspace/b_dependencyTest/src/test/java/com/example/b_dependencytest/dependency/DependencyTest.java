package com.example.b_dependencytest.dependency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DependencyTest {

//    필드 주입
//    @Autowired
//    private DTest dTest;

//    setter 주입
//    private DTest dTest;
//
//    @Autowired
//    public void setDTest(DTest dTest) {
//        this.dTest = dTest;
//    }

//    생성자 주입
//    private final DTest dTest;
//
//    @Autowired
//    public DependencyTest(DTest dTest) {
//        this.dTest = dTest;
//    }
//
//    @Test
//    void test (){
//        dTest.print();
//    }


    // 나중에 하기
    private final DTest2 dTest2;

    @Autowired
    public DependencyTest(DTest2 dTest2) {
        this.dTest2 = dTest2;
    }

    @Test
    void test(){
        dTest2.print2();
    }

}
