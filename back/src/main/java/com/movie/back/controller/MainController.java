package com.movie.back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @GetMapping("/api/test")
    public String get(){
        return "요청성공!??!?!?!";
    }

}
