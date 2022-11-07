package com.movie.back.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

/*
*
*   @WebMvcTest
*   -JPA 기능은 동작하지 않는다.
*   - 여러 스프링 테스트 에노테이션 중 Web(Spring Mvc) 에만 집중할 수 있는 에노테이션
*   - @Controller, @ControllerAdvice    사용가능
*   - 단 @Service , @Repository는 사용할 수 없다.
* */
@WebMvcTest(MainController.class)
class MainControllerTest {

        @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
        @Autowired
        MockMvc mockMvc;

        @Test
        @DisplayName("박스오피스데이터를 확인한다.")
        void MviDateTest() throws Exception {
                mockMvc.perform(get("/mvi/box")).andExpect(status().isOk());
        }
}