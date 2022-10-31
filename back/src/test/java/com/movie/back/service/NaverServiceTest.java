package com.movie.back.service;

import com.movie.back.data.NaverRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class NaverServiceTest {


    @Autowired
    private NaverService service;

    @Test
    public void test(){
        System.out.println( service.localSearch(NaverRequest.builder().query("반도").build()));

    }
}