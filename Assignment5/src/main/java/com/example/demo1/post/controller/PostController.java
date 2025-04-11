package com.example.demo1.post.controller;

import com.example.demo1.common.dto.ApiRes;
import com.example.demo1.common.type.PostSuccessType;
import com.example.demo1.common.type.SuccessType;
import com.example.demo1.post.dto.request.PostCreateReq;
import com.example.demo1.post.dto.request.PostUpdateReq;
import com.example.demo1.post.dto.response.PostSearchRes;
import com.example.demo1.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 생성
    @PostMapping("")
    @Operation(
            summary = "게시글 생성 API",
            description = "게시글을 DB에 저장합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 게시글 생성"),
                    @ApiResponse(responseCode = "400", description = "잘못된 입력값"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    public ApiRes<?> create(@RequestBody @Valid PostCreateReq req) {
        postService.create(req);
        return ApiRes.success(PostSuccessType.CREATE);
    }

    // 목록조회
    @GetMapping("")
    @Operation(
            summary = "게시글 목록 조회 API",
            description = "상태가 PUBLIC인 전체 게시글을 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 게시글 목록 조회"),
                    @ApiResponse(responseCode = "400", description = "잘못된 입력값"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    public ApiRes<List<PostSearchRes>> search() {
        return ApiRes.success(PostSuccessType.GET_ALL, postService.search());
    }

    // 단일조회
    @GetMapping("/{postId}")
    @Operation(
            summary = "게시글 단일 조회 API",
            description = "게시글을 조회합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 게시글 조회"),
                    @ApiResponse(responseCode = "400", description = "잘못된 입력값"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    public PostSearchRes detail(
            @PathVariable("postId") Long postId
    ) {
        return postService.detail(postId);
    }

    // 수정
    @PutMapping("/{postId}")
    @Operation(
            summary = "게시글 수정 API",
            description = "게시글을 수정합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 게시글 수정"),
                    @ApiResponse(responseCode = "400", description = "잘못된 입력값"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    public Long update(
            @PathVariable("postId") Long postId,
            @RequestBody PostUpdateReq req) {
        return postService.update(postId, req);
    }

    // 삭제
    @DeleteMapping("/{postId}")
    @Operation(
            summary = "게시글 삭제 API",
            description = "게시글을 삭제합니다.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공적으로 게시글 삭제"),
                    @ApiResponse(responseCode = "400", description = "잘못된 입력값"),
                    @ApiResponse(responseCode = "500", description = "서버 오류")
            }
    )
    public Long delete(
            @PathVariable("postId") Long postId
    ) {
        return postService.delete(postId);
    }
}