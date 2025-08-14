package io.jsh.board.spring_board.repository;

import io.jsh.board.spring_board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
