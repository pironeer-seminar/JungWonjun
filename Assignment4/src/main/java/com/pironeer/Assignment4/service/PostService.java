package com.pironeer.Assignment4.service;

import com.pironeer.Assignment4.dto.request.PostCreateReq;
import com.pironeer.Assignment4.dto.response.CommentWithRes;
import com.pironeer.Assignment4.dto.response.PostGetListRes;
import com.pironeer.Assignment4.dto.response.PostSearchRes;
import com.pironeer.Assignment4.entity.Post;
import com.pironeer.Assignment4.entity.PostStatus;
import com.pironeer.Assignment4.entity.User;
import com.pironeer.Assignment4.repository.CommentRepository;
import com.pironeer.Assignment4.repository.PostRepository;
import com.pironeer.Assignment4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public Long create(PostCreateReq req) {
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("조회된 유저가 없습니다."));

        Post post = Post.create(user, req.getTitle(), req.getContent(), req.getStatus());
        post = postRepository.save(post);

        return post.getId();
    }

    public List<PostSearchRes> search() {
        List<Post> posts = postRepository.findAllByStatus(PostStatus.PUBLIC);

        return posts.stream()
                .map(post -> {
                    List<CommentWithRes> commentDtos = commentRepository.findAllByPost(post).stream()
                            .map(comment -> new CommentWithRes(
                                    comment.getId(),
                                    comment.getContent()
                            ))
                            .toList();

                    return new PostSearchRes(
                            post.getUser().getId(),
                            post.getId(),
                            post.getTitle(),
                            post.getContent(),
                            post.getCreatedAt(),
                            commentDtos
                    );
                })
                .toList();
    }


    public List<PostGetListRes> findByUser(Long userId) {
        if (userRepository.findById(userId).isEmpty()) {
            throw new IllegalStateException("해당 유저가 존재하지 않습니다.");
        }
        List<Post> posts = postRepository.findAllByUserId(userId);
        return posts.stream()
                .map(post -> new PostGetListRes(post.getId(), post.getTitle(), post.getContent()))
                .collect(Collectors.toList());
    }

    public PostSearchRes detail(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalStateException("해당 게시글이 존재하지 않습니다."));
        return new PostSearchRes(post.getUser().getId(), post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt(),
                commentRepository.findAllByPost(post).stream()
                        .map(comment -> new CommentWithRes(
                                comment.getId(),
                                comment.getContent()
                        ))
                        .toList()
        );
    }

    public Long update(Long postId, PostCreateReq req) {
        Post post = postRepository.findById(postId)
                        .orElseThrow(()-> new IllegalStateException("해당 게시글이 존재하지 않습니다."));
        post.update(req.getTitle(), req.getContent(), req.getStatus());
        postRepository.save(post);
        return post.getId();

    }

    public Long delete(Long postId) {
        postRepository.deleteById(postId);
        return postId;
    }
}