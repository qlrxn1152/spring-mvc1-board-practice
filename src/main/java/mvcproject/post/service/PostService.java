package mvcproject.post.service;

import mvcproject.post.domain.Post;

import java.util.List;

public interface PostService {
    Post save(Post post);

    Post findById(Long id);

    List<Post> findAll();

    void update(Long postId, Post updatePost);

    void delete(Long deletePostId);

}
