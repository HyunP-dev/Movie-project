package com.movie.back.data;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class NaverResponse {
        private Integer total;
        private Integer start;
        private Integer display;
        private List<Items> items;

        @Data
        @NoArgsConstructor
        public static class Items{
                private String title;   //영화제목
                private String link;    //네이버에서 확인할 수있는 영화정보 url
                private String image;   //섬네일 이미지 링크
                private String subtitle;    //영어 제목 또는 원제
                private Date pubDate;   //제작 연도 yyyy 식임
                private String director;    //감독
                private String actor;       //출연배우들
                private Double userRating;  //평점

        }
}
