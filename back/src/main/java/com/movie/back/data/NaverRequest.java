package com.movie.back.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NaverRequest {

        private String query;
        private Integer start;  //검색시작위치 10~100
        private String genre;   //장르
        private String country; //국가
        private  String yearfrom; //시작연도
        private String yearto;  //종료연도

        public MultiValueMap<String,String> toMultiValueMap(){
                var map = new LinkedMultiValueMap<String,String>();
                map.add("query", query);
                map.add("display","5");
                map.add("start","1");
                map.add("yearfrom","2021");
                map.add("yearto","2023");


                return map;
        }
}
