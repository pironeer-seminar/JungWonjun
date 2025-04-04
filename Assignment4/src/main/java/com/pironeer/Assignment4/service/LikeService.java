package com.pironeer.Assignment4.service;

import com.pironeer.Assignment4.dto.request.LikeCreateReq;
import com.pironeer.Assignment4.dto.response.LikeRes;
import com.pironeer.Assignment4.entity.Like;
import com.pironeer.Assignment4.entity.Post;
import com.pironeer.Assignment4.entity.User;
import com.pironeer.Assignment4.repository.LikeRepository;
import com.pironeer.Assignment4.repository.PostRepository;
import com.pironeer.Assignment4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<LikeRes> search() {
        return likeRepository.findAll().stream()
                .map((like) -> new LikeRes(
                        like.getPost().getId(),
                        like.getUser().getId()
                ))
                .toList();
    }

    public Long create(LikeCreateReq req) {
        Post post = postRepository.findById(req.getPostId())
                .orElseThrow(() -> new IllegalStateException("해당 게시물은 존재하지 않습니다."));
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new IllegalStateException("해당 유저는 존재하지 않습니다"));
        Like like = Like.create(post, user);
        likeRepository.save(like);
        return like.getId();
    }

    public Long delete(Long likeId) {
        Like like = likeRepository.findById(likeId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 좋아요입니다."));
        likeRepository.deleteById(likeId);
        return likeId;
    }
}
