package CodeIt.Ytrip.video.domain;

import CodeIt.Ytrip.like.domain.VideoLike;
import CodeIt.Ytrip.review.domain.Review;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Video {

    @Id @GeneratedValue
    @Column(name = "video_id")
    private Long id;

    private String title;
    private String content;
    private String url;

    @Column(name = "likes_count")
    private Integer likeCount;

    private String tag;

    @OneToMany(mappedBy = "video")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "video")
    private List<VideoLike>  videoLikes = new ArrayList<>();

    public Video(String title, String content, String url, Integer likeCount, String tag) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.likeCount = likeCount;
        this.tag = tag;
    }
}
