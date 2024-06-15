package CodeIt.Ytrip.course.dto;

import CodeIt.Ytrip.place.domain.Place;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDto {
    private int index;
    private String name;
    private String description;
    private String img;
    private float posX;
    private float posY;

    public static CourseDto of(int index, Place place) {
        return CourseDto.builder()
                .index(index)
                .name(place.getName())
                .description(place.getDescription())
                .img(place.getImg())
                .posX(place.getPosX())
                .posY(place.getPosY())
                .build();
    }
}
