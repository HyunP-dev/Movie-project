package com.movie.back.service;


import com.movie.back.data.NaverRequest;
import com.movie.back.data.NaverResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class NaverService {
            @Value("${naver.url.client.id}")
            private String naverClientId;
            @Value("${naver.url.client.secret}")
            private String naverSecret;

            public NaverResponse localSearch(NaverRequest request){
                var uri = UriComponentsBuilder
                        .fromUriString("https://openapi.naver.com/v1/search/movie.json")
                        .queryParams(request.toMultiValueMap())
                        .build()
                        .encode()
                        .toUri();

                var headers =new HttpHeaders();
                headers.set("X-Naver-Client-Id", naverClientId);
                headers.set("X-Naver-Client-Secret", naverSecret);
                //restTemplate에서는 HttpEntity 타입을 매개변수로 받기에 HttpEntity로 header값들을 넣어야한다
                var httpEntity = new HttpEntity<>(headers);
                var responseType = new ParameterizedTypeReference<NaverResponse>(){};
                //제네릭을 사용한경우 그 타입으로 클래스 타입을 지정할 수 없기에 ParameterizedType을 사용해서 사용해야한다
                ResponseEntity<NaverResponse> responseentity = new RestTemplate().exchange(
                        uri,
                        HttpMethod.GET,
                        httpEntity,
                        responseType
                );
                return responseentity.getBody();
            }
}
