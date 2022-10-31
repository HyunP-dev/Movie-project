package com.movie.back.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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
                map.add("genre",genre);
                map.add("country", country);
                map.add("yearfrom", yearfrom);
                map.add("yearto", yearto);

                return map;
        }
}
