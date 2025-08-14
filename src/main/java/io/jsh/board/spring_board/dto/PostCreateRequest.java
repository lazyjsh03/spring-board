package io.jsh.board.spring_board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostCreateRequest {

    private String title;
    private String content;
}
