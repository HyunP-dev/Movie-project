package com.movie.back.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.movie.back.data.BoxOfficeRequest;
import com.movie.back.data.KMDB.MovieRequest;
import com.movie.back.data.NaverRequest;
import com.movie.back.data.NaverResponse;
import com.movie.back.entity.BoxInfo;
import com.movie.back.repository.BoxInfoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoxOfficeApiTest {


    @Autowired
    private BoxOfficeApi boxOfficeApi;

    @Autowired
    private NaverService naverService;

    @Autowired
    private BoxInfoRepository boxInfoRepository;

    //박스오피스 정보 openApi 잘 불러오는지 확인하는 테스트코드
    @Test
    public void boxOfficeOpenApiAct() throws JsonProcessingException {

        boxOfficeApi
                .boxOfficeGet(new BoxOfficeRequest())
                .forEach(System.out::println);
    }

    @Test       //성공     --필드를 만들어서 그 필드에 값들을 여기서 리턴하는 값들을 통해 받아 마지막에 내보내면된다!!
    public void 박스오피스이미지받기() throws JsonProcessingException {
        boxOfficeApi
                .boxOfficeGet(new BoxOfficeRequest())
                .forEach(boxOfficeResponse -> {
                  //  System.out.println(boxOfficeResponse);
                    var items = naverService.movieSearch(NaverRequest
                            .builder()
                            .query(boxOfficeResponse.getMovieNm())
                            .build()).getItems().stream()
                            .filter(items1 -> items1.getUserRating() > 5.0)
                            .collect(Collectors.toList());

                    for(var item : items){
                        System.out.println(item);
                    }
                  //  items.forEach(System.out::println);

                });
    }


    @Test
    @DisplayName("Naver 검색")
    public void test3() throws JsonProcessingException {
        System.out.println(naverService.movieSearch(NaverRequest.builder().query("REMEMBER").build()).getItems());
    }
    @Test
    @DisplayName("KMDB 검색")
    public void test4() throws JsonProcessingException {
        ArrayList<Map> list = new ArrayList<>();
        System.out.println(naverService.movieResponse(MovieRequest.builder().query("블랙아담").build()));
//                .forEach(map ->
//                       // list.addAll((Collection<? extends Map>) map.get("Result"))
//                    //Result만 걸러냄
//                );
//                list.forEach(map -> {
//                    System.out.println(map.get("title"));
//                    //여기서 원하는 값만 추출이 가능하다.
//                });

    }

    @Test
    public void test5() throws JsonProcessingException {
        boxInfoRepository.findAll().forEach(System.out::println);
        /* System.out.println( naverService
                .movieResponse(MovieRequest.builder()
                        .query("블랙아담")
                        .build()).stream().findFirst().get());
*/
    }
    @Test
    @DisplayName("최신 박스오피스 정보를 저장한다.")
    public void test6() throws JsonProcessingException {
        boxOfficeApi
                .boxOfficeGet(new BoxOfficeRequest())
                .forEach(boxOfficeResponse -> {
                    var boxDTO = naverService.movieSearch(NaverRequest
                                    .builder()
                                    .query(boxOfficeResponse.getMovieNm())
                                    .build()).getItems().stream()
                            .filter(items1 -> items1.getUserRating() > 5.0)
                            .collect(Collectors.toList());

                    System.out.println(boxDTO);
                    boxDTO.forEach(items -> {
                        boxInfoRepository.save(
                                BoxInfo.builder()
                                        .title(items.getTitle())
                                        .imageLink(items.getImage())
                                        .rating(items.getUserRating().toString())
                                .build()
                        );
                    });
                });

        //저장한 데이터를 출력해서 확인한다.
       //  boxInfoRepository.findAll().forEach(System.out::println);
    }




}