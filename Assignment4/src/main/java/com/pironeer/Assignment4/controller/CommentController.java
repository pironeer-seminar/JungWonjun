package com.pironeer.Assignment4.controller;

import com.pironeer.Assignment4.dto.request.CommentCreateReq;
import com.pironeer.Assignment4.dto.request.CommentUpdateReq;
import com.pironeer.Assignment4.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("")
    public Long create(@RequestBody CommentCreateReq req) {
        return commentService.create(req);
    }

    @PutMapping("/{commentId}")
    public Long update(
            @PathVariable("commentId") Long commentId,
            @RequestBody CommentUpdateReq req) {
        return commentService.update(commentId, req);
    }

    @DeleteMapping("/{commentId}")
    public Long delete(@PathVariable("commentId") Long commentId) {
        return commentService.delete(commentId);
    }
}