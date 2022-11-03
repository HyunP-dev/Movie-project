package com.movie.back.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.movie.back.data.BoxOfficeRequest;
import com.movie.back.data.BoxOfficeResponse;
import com.movie.back.data.KMDB.MovieRequest;
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
@RestController
@RequestMapping("/mvi")
@RequiredArgsConstructor
public class MainController {

    private final NaverService service;
    @GetMapping("/api/test")
    public String get(){
        return "요청성공!??!?!?!";
    }

    @GetMapping("/search")
    @ResponseBody
    public Map searchMovie(@RequestParam String query) throws JsonProcessingException {
                    return service.movieResponse(MovieRequest.builder().query(query).build());
    }

    @ApiOperation(value = "MOVIE All GET",notes = "GET 방식으로 전체조회")
    @GetMapping(path = "")    //전체 데이터 조회
    public ResponseEntity<ArrayList<BoxOfficeResponse>> readAll() throws JsonProcessingException {    //todo: PageResponse를 만들어서 page 개체를 던질예정

            return ResponseEntity.ok(null);                           //PageResponse  안에는 페이지가 있음
    }                                                                                       //TODO: PageRequest 객체를 통해 받을 예정
    @ApiOperation(value = "MOVIE ONE GET",notes = "GET 방식으로 하나조회")
    @GetMapping(value="/{movieId}")
    public ResponseEntity<MovieDTO> read(@PathVariable("movieId") Long movieId){
            return ResponseEntity.ok(new MovieDTO());
    }

    @GetMapping("/")
    public ResponseEntity<Resource> image(){

        HttpHeaders headers = new HttpHeaders();

//        try{
//         //   headers.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
//        } catch (IOException e) {
//            throw new RuntimeException();
//        }


        return ResponseEntity.ok(null);
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
