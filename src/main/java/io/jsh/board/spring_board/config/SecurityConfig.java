package io.jsh.board.spring_board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF 보호 비활성화 (Stateless한 REST API에서는 보통 비활성화합니다)
                .csrf(AbstractHttpConfigurer::disable)

                // HTTP 요청에 대한 접근 권한 설정
                .authorizeHttpRequests(authorize -> authorize
                        // "/hello" 주소로 오는 요청은
                        .requestMatchers("/hello").permitAll() // 누구나 접근 허용
                        // 그 외 모든 요청은
                        .anyRequest().authenticated() // 인증된 사용자만 접근 가능
                );

        return http.build();
    }
}
