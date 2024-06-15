package CodeIt.Ytrip.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {

    private String name;
    private List<PlanDto> plan;


    public static CourseDto of (String name, List<PlanDto> planDto) {
        return CourseDto.builder()
                .name(name)
                .plan(planDto)
                .build();
    }
}
