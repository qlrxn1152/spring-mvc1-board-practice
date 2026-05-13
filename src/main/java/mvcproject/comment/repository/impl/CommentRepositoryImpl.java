package mvcproject.comment.repository.impl;

import lombok.extern.slf4j.Slf4j;
import mvcproject.comment.domain.Comment;
import mvcproject.comment.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Slf4j
public class CommentRepositoryImpl implements CommentRepository {

    private Map<Long, Comment> store = new ConcurrentHashMap<>();
    private AtomicLong sequence = new AtomicLong(0);

    @Override
    public Comment save(Comment comment) {
        long id = sequence.incrementAndGet();
        store.put(id, comment);
        return comment;
    }

    @Override
    public Comment findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Comment> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void update(Long commentId, Comment updateComment) {
        Comment findComment = store.get(commentId);
        findComment.updateComment(updateComment);
    }

    @Override
    public void delete(Long deleteCommentId) {
        store.remove(deleteCommentId);
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
