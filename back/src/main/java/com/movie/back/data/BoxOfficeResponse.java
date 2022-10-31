package com.movie.back.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoxOfficeResponse {

        private String rank;
        private String rankOldAndNew;
        private String movieNm;
        private String audiCnt; //해당일에 관객수
        private String auidAcc; //누적관객수
        private Resource resource;
}
