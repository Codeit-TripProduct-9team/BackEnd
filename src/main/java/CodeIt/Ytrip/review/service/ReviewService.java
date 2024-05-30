package CodeIt.Ytrip.review.service;

import CodeIt.Ytrip.common.exception.NoSuchElementException;
import CodeIt.Ytrip.common.reponse.StatusCode;
import CodeIt.Ytrip.common.reponse.SuccessResponse;
import CodeIt.Ytrip.review.domain.Review;
import CodeIt.Ytrip.review.dto.ReviewDto;
import CodeIt.Ytrip.review.repository.ReviewRepository;
import CodeIt.Ytrip.video.domain.Video;
import CodeIt.Ytrip.video.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ResponseEntity<?> getReviewList(Long videoId, String sort) {
        List<Review> reviews = new ArrayList<>();

        try {
            if (sort.equals("likes")) {
                reviews = reviewRepository.findByVideoIdOrderByLikeCountDesc(videoId);
            }

            if (sort.equals("latest")) {
                reviews = reviewRepository.findByVideoIdOrderByCreatedAtDesc(videoId);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        List<ReviewDto> reviewDto = reviews.stream()
                .map(ReviewDto::from)
                .toList();

        return ResponseEntity.ok(SuccessResponse.of(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), reviewDto));
    }
}
