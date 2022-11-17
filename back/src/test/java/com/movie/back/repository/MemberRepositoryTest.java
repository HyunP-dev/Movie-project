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
    void t1est(){
        memberRepository.save(Member.builder()
                .email("user")
                .password(passwordEncoder.encode("1111"))
                .build());
    }
}