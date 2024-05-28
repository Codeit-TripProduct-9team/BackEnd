package CodeIt.Ytrip.video.service;

import CodeIt.Ytrip.video.domain.Video;
import CodeIt.Ytrip.video.dto.VideoDto;
import CodeIt.Ytrip.video.repository.VideoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VideoServiceTest {

    @Autowired
    VideoRepository videoRepository;
    @Test
    public void 비디오_목록_조회() throws Exception {
        //given
        List<Video> findVidoes = videoRepository.findTop12ByOrderByLikeCountDesc();
        //when
        int size = findVidoes.size();
        //then
        Assertions.assertThat(size).isEqualTo(5);
    }

}