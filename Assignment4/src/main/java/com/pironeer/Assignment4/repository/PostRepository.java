package com.pironeer.Assignment4.repository;

import com.pironeer.Assignment4.entity.Post;
import com.pironeer.Assignment4.entity.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByStatus(PostStatus status);
}