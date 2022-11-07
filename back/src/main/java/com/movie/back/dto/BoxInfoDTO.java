package com.movie.back.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoxInfoDTO {

        private String title;
        private String imageLink;
        private String rating;
}
