package mvcproject.post.repository;

import mvcproject.post.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    Post save(Post post);

    Post findById(Long id);

    List<Post> findAll();

    void update(Long postId, Post updatePost);

    void delete(Long deletePostId);

    void clearStore();
}
