package com.movie.back.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ImageServiceTest {


    @Autowired
    private ImageService imageService;

    @Test
    public void 이미지테스트(){
            imageService.viewFileAll().forEach(resource -> System.out.println(resource.getFilename()));
    }
}