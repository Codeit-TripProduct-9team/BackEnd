package CodeIt.Ytrip.course.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PlanDto {

    private int day;
    private List<CourseDto> place;
}
