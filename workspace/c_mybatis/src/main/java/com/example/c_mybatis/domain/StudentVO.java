package com.example.c_mybatis.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentVO {

    private long studentId;
    private String studentName;
    private int studentAge;
    private String studentGender;
    private String studentAddress;

}
