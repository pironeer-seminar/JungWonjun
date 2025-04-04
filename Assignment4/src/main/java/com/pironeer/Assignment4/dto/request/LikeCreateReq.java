package com.pironeer.Assignment4.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikeCreateReq {
    private Long postId;
    private Long userId;
}
