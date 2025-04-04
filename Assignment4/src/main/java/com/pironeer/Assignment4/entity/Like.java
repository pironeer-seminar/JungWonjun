package com.pironeer.Assignment4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "likes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"post_id", "user_id"})
})
@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Like {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public static Like create(Post post, User user) {
        return Like.builder()
                .post(post)
                .user(user)
                .build();
    }
}