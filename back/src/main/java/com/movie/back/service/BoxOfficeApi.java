package com.movie.back.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.back.data.BoxOfficeRequest;
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
public class BoxOfficeApi {

    @Value("${spring.movie.box.key}")
    private String key;

    public  ArrayList<Map>  boxOfficeGet(BoxOfficeRequest request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        request.setKey(key);
        request.setTargetDt(LocalDateTime
                .now()
                .minusDays(7L)
                .format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                .toString());
        System.out.println(LocalDateTime.now().minusDays(7L).format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString());
        var uri = UriComponentsBuilder
                .fromUriString("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json")
                .queryParams(request.toMultiValueMap())
                .build()
                .encode()
                .toUri();
        System.out.println(request.toMultiValueMap());
        System.out.println(uri.toString());


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
        ArrayList<java.util.Map> list = (ArrayList<Map>)lm.get("weeklyBoxOfficeList");

        return list;
    }

}
