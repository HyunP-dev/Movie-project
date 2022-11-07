package com.movie.back.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.movie.back.data.BoxOfficeRequest;
import com.movie.back.data.BoxOfficeResponse;
import com.movie.back.data.KMDB.MovieRequest;
import com.movie.back.data.NaverRequest;
import com.movie.back.data.NaverResponse;
import com.movie.back.dto.MovieDTO;
import com.movie.back.entity.Movie;
import com.movie.back.service.BoxOfficeApi;
import com.movie.back.service.ImageService;
import com.movie.back.service.NaverService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mvi")
@RequiredArgsConstructor
public class MainController {

    private final BoxOfficeApi boxOfficeApi;
    private final NaverService naverService;
    @GetMapping("/api/test")
    public String get(){
        return "요청성공!??!?!?!";
    }

   /* @GetMapping("/search")      //TODO 여기에는 KMDB 데이터를 넣을 예정임
    @ResponseBody
    public Map searchMovie(@RequestParam String query) throws JsonProcessingException {
                    return naverService.movieResponse(MovieRequest.builder().query(query).build());
    }*/

    @ApiOperation(value = "MOVIE All GET",notes = "GET 방식으로 BoxOffice 순위 10개 조회한다.")
    @GetMapping(path = "/box")    //전체 데이터 조회
    public ResponseEntity<List<NaverResponse.Items>> readAll() throws JsonProcessingException {
            List<NaverResponse.Items> responses = new ArrayList<>();
            boxOfficeApi
                    .boxOfficeGet(new BoxOfficeRequest())
                    .forEach(boxOfficeResponse -> {
                        responses.addAll(
                                naverService.movieSearch(NaverRequest.builder()
                                        .query(boxOfficeResponse.getMovieNm())
                                        .build()).getItems()
                                        .stream().filter(items -> items.getUserRating() > 5.0).collect(Collectors.toList())
                        );
                    });


            return ResponseEntity.ok(responses);
    }

    @ApiOperation(value = "MOVIE ONE GET",notes = "GET 방식으로 하나조회")
    @GetMapping(value="/box/read")
    public ResponseEntity<Map> read(@RequestParam String name) throws JsonProcessingException {


            return ResponseEntity.ok( naverService
                    .movieResponse(MovieRequest.builder()
                            .query(name)
                            .build()).stream().findFirst().get());
    }


    @ApiOperation(value = "MOVIE POST",notes = "POST 요청")
    @PostMapping(value = "",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody MovieDTO movieDTO){
            return ResponseEntity.ok("post");
    }
    @ApiOperation(value = "MOVIE PUT",notes = "PUT 요청")
    @PutMapping(value = "/{movieId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> modify(
            @PathVariable("movieId") Long movieId,
            @RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(new MovieDTO());
    }

    @ApiOperation(value = "MOVIE DELETE",notes = "DELETE 요청")
    @DeleteMapping(value = "/{movieId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> remove(@PathVariable("movieId") Long movieId){
            return ResponseEntity.ok(1L);   //todo: 삭제한 PK가 날아가게
    }



}
