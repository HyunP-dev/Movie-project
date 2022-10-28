package com.movie.back.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mvi")
public class MainController {

    @ApiOperation(value="Movie Article GET",notes="영화글 GET")
    @GetMapping(value = "/{movieId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> read(@PathVariable Long movieId){
        return ResponseEntity.ok("test");
    }

    @ApiOperation(value = "Movie Article POST",notes = "영화글 POST")
    @PostMapping(value = "",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(){   //todo 바디로 받을 객체를 만들어한다.
        return ResponseEntity.ok("test");
    }

    @ApiOperation(value="Movie Article PUT",notes = "영화글 PUT")
    @PutMapping(value = "/{movieId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> modified(@PathVariable Long movieId) {   //todo 바디로 받을 객체를 만들어야한다.
        return ResponseEntity.ok("test");
    }

    @ApiOperation(value="Movie Article Delete",notes = "영화글 DELETE")
    @DeleteMapping(value = "/{movieId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> remove(@PathVariable Long movieId){
        return ResponseEntity.ok("test");
    }
}
