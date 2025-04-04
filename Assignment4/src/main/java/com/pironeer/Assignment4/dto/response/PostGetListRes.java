package com.pironeer.Assignment4.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostGetListRes {
    public Long id;
    public String title;
    public String content;
}
