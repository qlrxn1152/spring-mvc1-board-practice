package mvcproject.post.repository.impl;

import mvcproject.post.domain.Post;
import mvcproject.post.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryImplTest {

    private PostRepository postRepository =  new PostRepositoryImpl();

    @Test
    void save() {
        // given
        Post post = new Post("titleA", "contentA");

        // when
        Post savedPost = postRepository.save(post);

        // then
        assertThat(post).isEqualTo(savedPost);
    }

    @Test
    void findById() {
        // given
        Post post = new Post("titleA", "contentA");
        Post savedPost = postRepository.save(post);

        // when
        Post findPost = postRepository.findById(savedPost.getPostId());

        // then
        assertThat(findPost).isEqualTo(savedPost);
    }

    @Test
    void findAll() {
        // given
        Post postA = new Post("titleA", "contentA");
        Post postB = new Post("titleB", "contentB");
        postRepository.save(postA);
        postRepository.save(postB);

        // when
        List<Post> posts = postRepository.findAll();

        // then
        assertThat(posts).hasSize(2);
        assertThat(posts).contains(postA, postB);
    }

    @Test
    void edit() {
        // given
        Post postA = new Post("titleA", "contentA");
        postRepository.save(postA);
        Post updatePost = new Post("updateTitle", "updateContent");

        // when
        postRepository.update(postA.getPostId(), updatePost);

        // then
        assertThat(postA.getTitle()).isEqualTo(updatePost.getTitle());
        assertThat(postA.getContent()).isEqualTo(updatePost.getContent());
    }

    @Test
    void delete() {
        // given
        Post postA = new Post("titleA", "contentA");
        postRepository.save(postA);

        // when
        postRepository.delete(postA.getPostId());
        List<Post> posts = postRepository.findAll();

        // then
        assertThat(posts).isEmpty();
    }

    @BeforeEach
    void clearStore() {
        postRepository.clearStore();
    }
}