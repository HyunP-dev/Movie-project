package com.movie.back.data;

import lombok.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoxOfficeRequest {

    private String key;
    //발급받은키 값을 입력합니다.
    private String targetDt;
    //조회하고자 하는 날짜를 yyyymmdd 형식으로 입력합니다.
    private String weekGb;
      /*
    * 주간/주말/주중을 선택 입력합니다
    “0” : 주간 (월~일)
    “1” : 주말 (금~일) (default)
    “2” : 주중 (월~목)
    * */
      private String repNationCd;
    //한국/외국 영화별로 조회할 수 있습니다.
    //“K: : 한국영화 “F” : 외국영화 (default : 전체)
    public MultiValueMap<String,String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String,String>();

        map.add("key",key);
        map.add("targetDt",targetDt);
        map.add("itemPerPage","15");

        return map;
    }

}
