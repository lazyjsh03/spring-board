package io.jsh.board.spring_board.service;

import io.jsh.board.spring_board.domain.Post;
import io.jsh.board.spring_board.dto.PostCreateRequest;
import io.jsh.board.spring_board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

}
