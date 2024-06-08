package CodeIt.Ytrip.course.domain;

import CodeIt.Ytrip.course.repository.CourseRepository;
import CodeIt.Ytrip.place.domain.Place;
import CodeIt.Ytrip.place.repository.PlaceRepository;
import CodeIt.Ytrip.video.domain.Video;
import CodeIt.Ytrip.video.repository.VideoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CourseTest {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void 코스_저장() throws Exception {
        //given

        Video video = Video.builder()
                .url("testURL")
                .tag("testTag")
                .title("testTitle")
                .content("testContent")
                .likeCount(100)
                .build();

        videoRepository.save(video);

        Course course = Course.builder()
                .dayNum(1)
                .places("1,2")
                .video(video)
                .build();
        //when
        courseRepository.save(course);

        //then
        Optional<Course> findCourse = courseRepository.findById(course.getId());
        Assertions.assertThat(findCourse.get().getPlaces()).isEqualTo("1,2");
    }

//    @Test
//    public void 코스_검색() throws Exception {
//        //given
//
//        Video video = Video.builder()
//                .url("testURL")
//                .tag("testTag")
//                .title("testTitle")
//                .content("testContent")
//                .likeCount(100)
//                .build();
//
//        videoRepository.save(video);
//
//        Course course = Course.builder()
//                .dayNum(1)
//                .places("1,2")
//                .video(video)
//                .build();
//        //when
//        courseRepository.save(course);
//
//        Place place = Place.builder()
//                .name("place_name 1")
//                .posX(100.21)
//                .posY(28.21)
//                .build();
//
//        Place place2 = Place.builder().name("place_name 2")
//                .posX(22.11)
//                .posY(54.21)
//                .build();
//
//        placeRepository.save(place);
//        placeRepository.save(place2);
//
//        //then
//        Optional<Course> findCourse = courseRepository.findById(course.getId());
//
//        List<String> placeStrings = List.of(findCourse.get().getPlaces().split(","));
//
//        List<Long> places = placeStrings.stream()
//                .map(Long::valueOf)  // 각 String 값을 Long으로 변환
//                .toList();
//
//        Long placeId = places.get(0);
//        Optional<Place> findPlace = placeRepository.findById(placeId);
//        System.out.println("findPlace.get(). = " + findPlace.get().);
//    }
}