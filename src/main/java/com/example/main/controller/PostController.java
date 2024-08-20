package com.example.main.controller;

import com.example.main.model.Post;
import com.example.main.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService = new PostService();

    // 모든 게시글 가져오기
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    // 특정 ID의 게시글 가져오기
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> post = postService.getPostById(id);
        return post.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 새로운 게시글 업로드
    @PostMapping("/upload")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
}

