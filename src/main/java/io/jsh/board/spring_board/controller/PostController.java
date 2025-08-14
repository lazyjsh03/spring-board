package io.jsh.board.spring_board.controller;

import io.jsh.board.spring_board.domain.Post;
import io.jsh.board.spring_board.dto.PostCreateRequest;
import io.jsh.board.spring_board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor // 생성자 주입을 위해 다시 @RequiredArgsConstructor를 사용합니다.
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostCreateRequest request) {

        Post savedPost = postService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }
}