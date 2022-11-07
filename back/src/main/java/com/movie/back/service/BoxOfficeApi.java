package com.movie.back.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.back.data.BoxOfficeRequest;
import com.movie.back.data.BoxOfficeResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoxOfficeApi {

    @Value("${movie.box.key}")
    private String key;

    private final ImageService imageService;

    public  ArrayList<BoxOfficeResponse>  boxOfficeGet(BoxOfficeRequest request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<BoxOfficeResponse> res = new ArrayList<>();
        request.setKey(key);

        request.setTargetDt(LocalDateTime
                .now()
                .minusDays(7L)
                .format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                .toString());

        log.info(LocalDateTime.now().minusDays(7L).format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString());

        var uri = UriComponentsBuilder
                .fromUriString("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json")
                .queryParams(request.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                null,
                String.class
        );
        LinkedHashMap lm = (LinkedHashMap) mapper.readValue(responseEntity.getBody(), java.util.Map.class).get("boxOfficeResult");
        ArrayList<java.util.Map<String,String>> list = (ArrayList<Map<String,String>>)lm.get("weeklyBoxOfficeList");
        list.forEach(map ->{
                res.add(BoxOfficeResponse.builder().
                        rank(map.get("rank"))
                        .rankOldAndNew(map.get("rankOldAndNew"))
                        .movieNm(map.get("movieNm"))
                        .audiCnt("audiCnt")
                        .auidAcc("auidAcc")
                        .resource(imageService.viewFileGet(map.get("rank").trim()+".jpg"))
                        .build());
        });
        return res;
    }

}
