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
public class PostCourseRequest {

    private String name;
    private List<PlanDto> plan;


//    public static PostCourseRequest of (Long userId, List<CourseDto> courseDto) {
//        return PostCourseRequest.builder()
//                .userId(userId)
//                .course(courseDto)
//                .build();
//    }
}
