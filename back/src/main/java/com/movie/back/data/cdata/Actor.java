package com.movie.back.data.cdata;

import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class Actor {
        private String peopleNm;

        private String cast;

        private String actorGb;


        public String getActorName() {
            return peopleNm;
        }

        public String getCharacterName() {
            return cast;
        }

        public String getType() {
            switch (Integer.parseInt(actorGb)) {
                case 1:
                    return "주연";
                case 2:
                    return "조연";
                case 3:
                    return "특별출연";
                case 5:
                    return "단역";
                default:
                    return null;
            }
        }
}
