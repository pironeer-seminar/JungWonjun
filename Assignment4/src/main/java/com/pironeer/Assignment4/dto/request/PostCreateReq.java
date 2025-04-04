package com.pironeer.Assignment4.dto.request;

import com.pironeer.Assignment4.entity.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateReq {

    private Long userId;

    private String title;

    private String content;

    private PostStatus status;
}