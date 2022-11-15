package com.movie.back.service;

import com.movie.back.repository.BoxOfficeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoxOfficeServiceTest {

    @Autowired
    BoxOfficeService boxOfficeService;

    @Autowired
    BoxOfficeRepository boxOfficeRepository;
    @Test
    void test() throws IOException, KobisScrapper.NotScrappedDateException {
        boxOfficeService.saveBoxMovie();
    }

    @Transactional
    @Test
        // 옵션 적용
    void test2(){
        boxOfficeRepository.getBoxOfficeList().forEach(System.out::println);
    }

    @Test
        // 옵션 적용
    void test3(){
        boxOfficeService.getBoxList().forEach(System.out::println);
    }


}