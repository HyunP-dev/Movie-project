package com.movie.back.repository;

import com.movie.back.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    void test(){
        memberRepository.save(Member.builder()
                .email("user")
                .password(passwordEncoder.encode("1111"))
                        .birth("2020")
                        .gender("남")
                        .nickName("닉네읨")
                .build());
    }

    @Test
    void test2(){
        String str = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2Njg2ODcwNTgsImlhdCI6MTY2ODY4Njk5OCwiZW1haWwiOiJ1c2VyIn0.-KyGdJXOt2jhBW5oOx0JzNauzSSr7jQBKLx1Ag19QI8";
        String str2 ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2Njg2ODcxNTYsImlhdCI6MTY2ODY4NzA5NiwiZW1haWwiOiJ1c2VyIn0.tF0w5WKjukjnk3lujfeov2jjXB-KhsA-Ip8yOdO03q0"

    }
}