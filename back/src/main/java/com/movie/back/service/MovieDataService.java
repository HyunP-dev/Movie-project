package com.movie.back.service;

import com.movie.back.dto.BoxInfoDTO;
import com.movie.back.repository.BoxInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieDataService {

        private final BoxInfoRepository boxInfoRepository;

        public List<BoxInfoDTO> boxInfoDTOList(){
               List<BoxInfoDTO> list = new ArrayList<>();
            boxInfoRepository.findAll().forEach(boxInfo -> {
                    list.add(BoxInfoDTO.builder()
                                    .title(boxInfo.getTitle())
                                    .imageLink(boxInfo.getImageLink())
                                    .rating(boxInfo.getRating())
                            .build());
            });

                return list;
        }
}
