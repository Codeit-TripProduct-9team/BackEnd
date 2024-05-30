package CodeIt.Ytrip.review.controller;

import CodeIt.Ytrip.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/video/{videoId}/reviews")
    public ResponseEntity<?> getReviewList(
            @PathVariable("videoId") Long videoId,
            @RequestParam(defaultValue = "latest") String sort) {
        return reviewService.getReviewList(videoId, sort);
    }

}
