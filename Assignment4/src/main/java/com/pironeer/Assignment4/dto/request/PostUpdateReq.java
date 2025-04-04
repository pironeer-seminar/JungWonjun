package com.pironeer.Assignment4.dto.request;

import com.pironeer.Assignment4.entity.PostStatus;
import lombok.Getter;

@Getter
public class PostUpdateReq {
    private String title;

    private String content;

    private PostStatus status;
}
