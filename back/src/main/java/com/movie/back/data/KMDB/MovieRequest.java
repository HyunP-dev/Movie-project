package com.movie.back.data.KMDB;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {

        private String serviceKey;
        private String query;
        public MultiValueMap<String,String> toMultiValueMap(){
                var map = new LinkedMultiValueMap<String,String>();

                map.add("collection","kmdb_new2");
                map.add("ServiceKey", serviceKey);
                map.add("detail", "Y");
                map.add("query", query);

                return map;
        }
}
