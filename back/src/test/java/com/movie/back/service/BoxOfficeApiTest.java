package com.movie.back.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.movie.back.data.BoxOfficeRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoxOfficeApiTest {


    @Autowired
    private BoxOfficeApi boxOfficeApi;

    //박스오피스 정보 openApi 잘 불러오는지 확인하는 테스트코드
    @Test
    public void boxOfficeOpenApiAct() throws JsonProcessingException {
   //     boxOfficeApi.boxOfficeGet(request).forEach(map -> {
  //          map.get("rnum");    //이런식으로 매핑하면 됨
//        });
        boxOfficeApi
                .boxOfficeGet(new BoxOfficeRequest())
                .forEach(System.out::println);
    }


}