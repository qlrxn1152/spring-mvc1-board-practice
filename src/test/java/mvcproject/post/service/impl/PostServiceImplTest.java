package mvcproject.post.service.impl;

import mvcproject.post.domain.Post;
import mvcproject.post.repository.PostRepository;
import mvcproject.post.repository.impl.PostRepositoryImpl;
import mvcproject.post.service.PostService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest {

    private PostRepository postRepository =  new PostRepositoryImpl();
    private PostService postService = new PostServiceImpl(postRepository);

    @Test
    void save() {
        // given
        Post post = new Post("titleA", "contentA");

        // when
        Post savedPost = postService.save(post);

        // then
        assertThat(post).isEqualTo(savedPost);
    }

    @Test
    void findById() {
        // given
        Post post = new Post("titleA", "contentA");
        Post savedPost = postService.save(post);

        // when
        Post findPost = postService.findById(savedPost.getPostId());

        // then
        assertThat(findPost).isEqualTo(savedPost);
    }

    @Test
    void findAll() {
        // given
        Post postA = new Post("titleA", "contentA");
        Post postB = new Post("titleB", "contentB");
        postService.save(postA);
        postService.save(postB);

        // when
        List<Post> posts = postService.findAll();

        // then
        assertThat(posts).hasSize(2);
        assertThat(posts).contains(postA, postB);
    }

    @Test
    void edit() {
        // given
        Post postA = new Post("titleA", "contentA");
        postService.save(postA);
        Post updatePost = new Post("updateTitle", "updateContent");

        // when
        postService.update(postA.getPostId(), updatePost);

        // then
        assertThat(postA.getTitle()).isEqualTo(updatePost.getTitle());
        assertThat(postA.getContent()).isEqualTo(updatePost.getContent());
    }

    @Test
    void delete() {
        // given
        Post postA = new Post("titleA", "contentA");
        postService.save(postA);

        // when
        postService.delete(postA.getPostId());
        List<Post> posts = postService.findAll();

        // then
        assertThat(posts).isEmpty();
    }

    @BeforeEach
    void clearStore() {
        postRepository.clearStore();
    }
}