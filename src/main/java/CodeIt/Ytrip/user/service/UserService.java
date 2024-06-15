package CodeIt.Ytrip.user.service;

import CodeIt.Ytrip.common.exception.NoSuchElementException;
import CodeIt.Ytrip.common.exception.UserException;
import CodeIt.Ytrip.common.reponse.StatusCode;
import CodeIt.Ytrip.common.reponse.SuccessResponse;
import CodeIt.Ytrip.course.domain.CourseDetail;
import CodeIt.Ytrip.course.domain.UserCourse;
import CodeIt.Ytrip.course.dto.CourseDto;
import CodeIt.Ytrip.course.dto.PlanDto;
import CodeIt.Ytrip.place.dto.PlaceDto;
import CodeIt.Ytrip.course.repository.CourseDetailRepository;
import CodeIt.Ytrip.course.repository.UserCourseRepository;
import CodeIt.Ytrip.place.domain.Place;
import CodeIt.Ytrip.place.repository.PlaceRepository;
import CodeIt.Ytrip.user.domain.User;
import CodeIt.Ytrip.user.dto.UserCourseResponse;
import CodeIt.Ytrip.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CourseDetailRepository courseDetailRepository;
    private final PlaceRepository placeRepository;
    private final UserCourseRepository userCourseRepository;

    public ResponseEntity<?> findUserCourse(Long userId) {
        Optional<User> findUser = userRepository.findById(userId);
        findUser.orElseThrow(() -> new UserException(StatusCode.USER_NOT_FOUND));

        List<UserCourse> findUserCourse = userCourseRepository.findByUserId(userId);
        List<CourseDto> courseDto = findUserCourse.stream().map(userCourse -> {

            List<CourseDetail> findCourseDetail = courseDetailRepository.findByUserCourseId(userCourse.getId());

            List<PlanDto> planDto = findCourseDetail.stream().map(courseDetail -> {
                List<Long> placeIds = Arrays.stream(courseDetail.getPlaces().split(","))
                        .map(Long::parseLong)
                        .toList();

                AtomicInteger index = new AtomicInteger();

                List<Place> findPlaces = placeRepository.findByIdIn(placeIds);
                List<PlaceDto> placeDto = findPlaces.stream().map(course -> PlaceDto.of(index.incrementAndGet(), course)).toList();
                return PlanDto.of(courseDetail.getDayNum(), placeDto);
            }).toList();
            return CourseDto.of(userCourse.getName(), planDto);
        }).toList();

        UserCourseResponse response = UserCourseResponse.from(courseDto);
        return ResponseEntity.ok(SuccessResponse.of(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), response));
    }
}
