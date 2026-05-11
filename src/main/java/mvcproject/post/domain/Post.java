package mvcproject.post.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class Post {

    private Long postId;
    private String title;
    private String content;
    private int viewCount; // 초기값 = 0 설정

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void updatePost(Post updatePost) {
        this.title = updatePost.getTitle();
        this.content = updatePost.getContent();
        this.updatedAt = LocalDateTime.now();
    }

    public void increaseViewCount() {
        this.viewCount++;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
