package com.movie.back.data.KMDB;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MovieResponse {

            @JsonProperty("Query")
            private String query;

            @JsonProperty("KMAQuery")
            private String kmaQuery;

            @JsonProperty("TotalCount")
            private  int totalCount;

            @Data
            static  class Result{
                private String docId;
                private String movieId;
                private String movieSeq;
                private String movieTitle;
                private String titleEng;
                private String titleOrg;
                private String titleEtc;
                private String prodYear;

                @JsonProperty("director")
                private List<Delectors> delectorsList;
                @Data
                static class Delectors{
                            private String directorNm;
                            private String directorEnNm;
                            private String directorId;
                }
            }


}
