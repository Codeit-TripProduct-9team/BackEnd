package CodeIt.Ytrip.video.service;

import CodeIt.Ytrip.common.reponse.StatusCode;
import CodeIt.Ytrip.common.reponse.SuccessResponse;
import CodeIt.Ytrip.video.domain.Video;
import CodeIt.Ytrip.video.dto.VideoDto;
import CodeIt.Ytrip.video.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public ResponseEntity<?> getVideoList() {

        List<VideoDto> videos = videoRepository.findTop12ByOrderByLikeCountDesc()
                .stream().map(VideoDto::from)
                .toList();

        log.info("Video size = {}", videos.size());

        return ResponseEntity.ok(SuccessResponse.of(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), videos));
    }
}
