package io.jsh.board.spring_board.controller;

import io.jsh.board.spring_board.domain.Post;
import io.jsh.board.spring_board.dto.PostCreateRequest;
import io.jsh.board.spring_board.dto.PostResponse;
import io.jsh.board.spring_board.dto.PostUpdateRequest;
import io.jsh.board.spring_board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor // 생성자 주입을 위해 다시 @RequiredArgsConstructor를 사용합니다.
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    // POST /api/posts
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostCreateRequest request) {
        Post savedPost = postService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    // GET /api/posts
    @GetMapping
    public ResponseEntity<List<PostResponse>> findAllPosts() {
        List<PostResponse> posts = postService.findAll();
        return ResponseEntity.ok(posts);
    }

    // GET /api/posts/{id}
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findPost(@PathVariable Long id) {
        Post post = postService.findById(id);
        PostResponse response = new PostResponse(post);
        return ResponseEntity.ok(response);
    }

    // PUT /api/posts/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest request) {
        postService.update(id, request);
        return ResponseEntity.ok().build();
    }

    // DELETE /api/posts/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok().build();
    }
}