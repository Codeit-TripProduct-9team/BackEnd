package CodeIt.Ytrip.review.domain;

import CodeIt.Ytrip.like.domain.ReviewLike;
import CodeIt.Ytrip.user.domain.User;
import CodeIt.Ytrip.video.domain.Video;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Review {

    @Id @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id")
    private Video video;

    @OneToMany(mappedBy = "review")
    private List<ReviewLike> reviewLikes = new ArrayList<>();

    private String content;

    public Review(User user, Video video, String content) {
        this.user = user;
        this.video = video;
        this.content = content;
    }
}
