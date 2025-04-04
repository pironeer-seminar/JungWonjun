package com.pironeer.Assignment4.service;

import com.pironeer.Assignment4.dto.request.PostCreateReq;
import com.pironeer.Assignment4.dto.response.PostSearchRes;
import com.pironeer.Assignment4.entity.Post;
import com.pironeer.Assignment4.entity.PostStatus;
import com.pironeer.Assignment4.entity.User;
import com.pironeer.Assignment4.repository.PostRepository;
import com.pironeer.Assignment4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Long create(PostCreateReq req) {
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("조회된 유저가 없습니다."));

        Post post = Post.create(user, req.getTitle(), req.getContent(), req.getStatus());
        post = postRepository.save(post);

        return post.getId();
    }

    public List<PostSearchRes> search() {
        // PostStatus가 public인 게시글만 조회할 수 있다.
        List<Post> posts = postRepository.findAllByStatus(PostStatus.PUBLIC);
        return posts.stream()
                .map(post ->
                        new PostSearchRes(post.getUser().getId(), post.getId(), post.getTitle(),
                                post.getContent(), post.getCreatedAt())
                )
                .toList();
    }

    public PostSearchRes detail(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalStateException(""));
        return new PostSearchRes(post.getUser().getId(), post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt());
    }

    public Long update(Long postId, PostCreateReq req) {
        Post post = postRepository.findById(postId)
                        .orElseThrow(()-> new IllegalStateException(""));
        post.update(req.getTitle(), req.getContent(), req.getStatus());
        postRepository.save(post);
        return post.getId();

    }

    public Long delete(Long postId) {
        postRepository.deleteById(postId);
        return postId;
    }
}