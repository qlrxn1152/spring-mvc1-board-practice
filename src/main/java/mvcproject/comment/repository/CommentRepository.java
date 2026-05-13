package mvcproject.comment.repository;

import mvcproject.comment.domain.Comment;
import mvcproject.post.domain.Post;

import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);

    Comment findById(Long id);

    List<Comment> findAll();

    void update(Long commentId, Comment updateComment);

    void delete(Long deleteCommentId);

    void clearStore();

}
