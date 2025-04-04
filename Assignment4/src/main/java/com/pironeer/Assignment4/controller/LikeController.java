package com.pironeer.Assignment4.controller;

import com.pironeer.Assignment4.dto.request.LikeCreateReq;
import com.pironeer.Assignment4.dto.response.LikeRes;
import com.pironeer.Assignment4.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @GetMapping("")
    public List<LikeRes> search() {
        return likeService.search();
    }

    @PostMapping("")
    public Long like(@RequestBody LikeCreateReq req) {
        return likeService.create(req);
    }

    @DeleteMapping("/{likeId}")
    public Long delete(@PathVariable("likeId") Long likeId) {
        return likeService.delete(likeId);
    }
}
