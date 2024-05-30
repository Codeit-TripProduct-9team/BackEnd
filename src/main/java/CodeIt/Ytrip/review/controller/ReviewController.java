package CodeIt.Ytrip.review.controller;

import CodeIt.Ytrip.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/video/{videoId}/reviews")
    public ResponseEntity<?> getReviewList(@PathVariable("videoId") Long videoId) {
        return reviewService.getReviewList(videoId);
    }
}
