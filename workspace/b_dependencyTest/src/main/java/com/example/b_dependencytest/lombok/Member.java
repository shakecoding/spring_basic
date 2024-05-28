package com.example.b_dependencytest.lombok;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Member {

    @NonNull
    private String name;

    private int age;

    private String address;

    private String phone;



}
