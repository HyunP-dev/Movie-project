package com.movie.back.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
public class BoxInfo {

    @Id
    private String imageLink;

    private String title;

    private String rating;
}
