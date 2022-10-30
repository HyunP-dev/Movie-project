package com.movie.back.controller;

import com.movie.back.dto.MovieDTO;
import com.movie.back.entity.Movie;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mvi")
public class MainController {


    @GetMapping("/api/test")
    public String get(){
        return "요청성공!??!?!?!";
    }

    @ApiOperation(value = "MOVIE All GET",notes = "GET 방식으로 전체조회")
    @GetMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)    //전체 데이터 조회
    public ResponseEntity<List<MovieDTO>> readAll(){    //todo: PageResponse를 만들어서 page 개체를 던질예정
            return ResponseEntity.ok(new ArrayList<MovieDTO>());                            //PageResponse  안에는 페이지가 있음
    }                                                                                       //TODO: PageRequest 객체를 통해 받을 예정
    @ApiOperation(value = "MOVIE ONE GET",notes = "GET 방식으로 하나조회")
    @GetMapping(value="/{movieId}")
    public ResponseEntity<MovieDTO> read(@PathVariable("movieId") Long movieId){
            return ResponseEntity.ok(new MovieDTO());
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
