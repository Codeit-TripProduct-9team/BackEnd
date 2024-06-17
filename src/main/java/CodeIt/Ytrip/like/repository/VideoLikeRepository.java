package CodeIt.Ytrip.like.repository;

import CodeIt.Ytrip.like.domain.VideoLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoLikeRepository extends JpaRepository<VideoLike, Long> {
    boolean existsByVideoIdAndUserId(Long videoId, Long userId);
    List<VideoLike> findByUserId(Long userId);

}
