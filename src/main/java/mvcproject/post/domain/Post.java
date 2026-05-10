package mvcproject.post.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class Post {

    private Long postId;
    private String title;
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updatePost(Post updatePost) {
        this.title = updatePost.getTitle();
        this.content = updatePost.getContent();
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
