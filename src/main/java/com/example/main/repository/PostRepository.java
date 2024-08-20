package com.example.main.repository;

import com.example.main.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository {
    private List<Post> posts = new ArrayList<>();
    private Long nextId = 1L;

    // 모든 게시글 반환
    public List<Post> findAll() {
        return new ArrayList<>(posts);
    }

    // 특정 ID의 게시글 반환
    public Optional<Post> findById(Long id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    // 게시글 저장
    public Post save(Post post) {
        post.setId(nextId++);
        posts.add(post);
        return post;
    }
}

