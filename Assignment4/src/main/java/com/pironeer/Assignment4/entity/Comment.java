package com.pironeer.Assignment4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comments")
@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(nullable = false, name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public static Comment create(Post post, User user, String content) {
        return Comment.builder()
                .post(post)
                .user(user)
                .content(content)
                .build();
    }

    public void update(String content) {
        this.content = content;
    }

}