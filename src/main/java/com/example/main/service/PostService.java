package com.example.main.service;

import com.example.main.model.Post;
import com.example.main.repository.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostService {
    private final PostRepository postRepository = new PostRepository();

    // 모든 게시글 반환
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 특정 ID의 게시글 반환
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    // 게시글 생성
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}

