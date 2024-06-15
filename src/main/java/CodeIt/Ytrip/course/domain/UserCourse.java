package CodeIt.Ytrip.course.domain;

import CodeIt.Ytrip.user.domain.User;
import CodeIt.Ytrip.video.domain.Video;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserCourse {

    @Id
    @GeneratedValue
    @Column(name = "user_course_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userCourse")
    private List<CourseDetail> courseDetails = new ArrayList<>();

    private String name;
}
