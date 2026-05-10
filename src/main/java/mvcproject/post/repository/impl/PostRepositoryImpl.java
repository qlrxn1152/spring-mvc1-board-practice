package mvcproject.post.repository.impl;

import mvcproject.post.domain.Post;
import mvcproject.post.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final Map<Long, Post> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public Post save(Post post) {
        long postId = sequence.incrementAndGet();

        post.setPostId(postId);
        store.put(postId, post);

        return post;
    }

    @Override
    public Post findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Long postId, Post updatePost) {
        Post findPost = findById(postId);

        findPost.updatePost(updatePost);
    }

    @Override
    public void delete(Long deletePostId) {
        store.remove(deletePostId);
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
