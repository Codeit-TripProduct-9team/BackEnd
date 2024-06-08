package CodeIt.Ytrip.course.repository;

import CodeIt.Ytrip.course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
