package io.jsh.board.spring_board.service;

import io.jsh.board.spring_board.domain.Post;
import io.jsh.board.spring_board.dto.PostCreateRequest;
import io.jsh.board.spring_board.dto.PostResponse;
import io.jsh.board.spring_board.dto.PostUpdateRequest;
import io.jsh.board.spring_board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Post create(PostCreateRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        return postRepository.save(post);
    }

    public List<PostResponse> findAll() {
        // createdAt을 기준으로 최신순으로 게시물 리스트 검색
        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));

        return posts.stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post with id " + id + " not found"));
    }

    @Transactional
    public void update(Long id, PostUpdateRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post with id " + id + " not found"));

        post.update(request.getTitle(), request.getContent());
    }

    @Transactional
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
