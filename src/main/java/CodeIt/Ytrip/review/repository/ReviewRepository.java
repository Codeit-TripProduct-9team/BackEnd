package CodeIt.Ytrip.review.repository;

import CodeIt.Ytrip.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByVideoId(Long videoId);
    List<Review> findByVideoIdOrderByLikeCountDesc(Long videoId);
    List<Review> findByVideoIdOrderByCreatedAtDesc(Long videoId);
}
