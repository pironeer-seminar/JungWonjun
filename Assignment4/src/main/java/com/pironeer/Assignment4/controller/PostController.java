package com.pironeer.Assignment4.controller;

import com.pironeer.Assignment4.dto.request.PostCreateReq;
import com.pironeer.Assignment4.dto.response.PostGetListRes;
import com.pironeer.Assignment4.dto.response.PostSearchRes;
import com.pironeer.Assignment4.service.CommentService;
import com.pironeer.Assignment4.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    // 생성
    @PostMapping("")
    public Long create(@RequestBody PostCreateReq req) {
        return postService.create(req);
    }

    // 목록조회
    @GetMapping("")
    public List<PostSearchRes> search() {
        return postService.search();
    }

    // 단일조회 (with 댓글)
    @GetMapping("/{postId}")
    public PostSearchRes detail(@PathVariable("postId") Long postId){
        return postService.detail(postId);
    }

    // 유저별 목록조회
    @GetMapping("users/{userId}")
    public List<PostGetListRes> search(@PathVariable("userId") Long userId){
        return postService.findByUser(userId);
    }

    // 수정
    @PutMapping("/{postId}")
    public Long update(@PathVariable("postId") Long postId, @RequestBody PostCreateReq req){
        return postService.update(postId, req);
    }

    // 삭제
    @DeleteMapping("/{postId}")
    public Long delete(@PathVariable("postId") Long postId){
        return postService.delete(postId);
    }
}