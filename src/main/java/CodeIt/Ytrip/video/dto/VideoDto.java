package CodeIt.Ytrip.video.dto;

import CodeIt.Ytrip.video.domain.Video;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class VideoDto {

    private Long id;
    private String title;
    private String url;
    private String tag;

    public static VideoDto from(Video video) {
        return VideoDto.builder()
                .id(video.getId())
                .title(video.getTitle())
                .url(video.getUrl())
                .tag(video.getTag())
                .build();
    }
}
