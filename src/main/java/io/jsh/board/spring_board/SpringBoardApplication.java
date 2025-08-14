package io.jsh.board.spring_board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoardApplication.class, args);
	}

}
