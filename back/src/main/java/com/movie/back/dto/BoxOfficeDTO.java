package com.movie.back.dto;

import com.movie.back.entity.ActorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoxOfficeDTO {

        private String title;
        private Integer rank;
        private String postLink;
        private String synopsis;
        private String date;
        private List<ActorDTO> actorList;
        private List<String> stillImage;
}
