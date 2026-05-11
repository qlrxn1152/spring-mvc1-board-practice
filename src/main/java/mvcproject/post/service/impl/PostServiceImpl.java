package mvcproject.post.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mvcproject.post.domain.Post;
import mvcproject.post.repository.PostRepository;
import mvcproject.post.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    // TODO : 예외처리 ㄱㄱ

    private final PostRepository postRepository;


    @Override
    public Post save(Post post) {
        log.info("Saving post {}", post);
        return postRepository.save(post);
    }

    @Override
    public Post findById(Long id) {
        log.info("Finding PostId = {}", id);
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void update(Long postId, Post updatePost) {
        log.info("Update PostId = {}, updatePost = {}", postId, updatePost);
        postRepository.update(postId, updatePost);
    }

    @Override
    public void delete(Long deletePostId) {
        log.info("Deleting PostId = {}", deletePostId);
        postRepository.delete(deletePostId);
    }

    @Override
    public void viewPost(Long postId) {
        Post post = postRepository.findById(postId);

        post.increaseViewCount();
    }

}
