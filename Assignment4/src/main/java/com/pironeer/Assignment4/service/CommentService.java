package com.pironeer.Assignment4.service;

import com.pironeer.Assignment4.dto.request.CommentCreateReq;
import com.pironeer.Assignment4.dto.request.CommentUpdateReq;
import com.pironeer.Assignment4.entity.Comment;
import com.pironeer.Assignment4.entity.Post;
import com.pironeer.Assignment4.entity.User;
import com.pironeer.Assignment4.repository.CommentRepository;
import com.pironeer.Assignment4.repository.PostRepository;
import com.pironeer.Assignment4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Long create(CommentCreateReq req) {
        Post post = postRepository.findById(req.getPostId())
                .orElseThrow(() -> new IllegalStateException("해당 게시물 없음"));
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new IllegalStateException("해당 유저 없음"));
        Comment comment = Comment.create(post, user, req.getContent());
        commentRepository.save(comment);
        return comment.getId();
    }
    
    public Long update(Long commentId, CommentUpdateReq req) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalStateException("해당 댓글 없음"));
        comment.update(req.getContent());
        commentRepository.save(comment);
        return comment.getId();
    }

    public Long delete(Long commentId) {
        commentRepository.deleteById(commentId);
        return commentId;
    }
}
