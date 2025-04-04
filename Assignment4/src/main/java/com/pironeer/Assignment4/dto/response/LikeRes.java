package com.pironeer.Assignment4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikeRes {
    private Long postId;
    private Long userId;
}
