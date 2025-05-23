package com.example.user_persist_ms.users.config;


import com.example.user_persist_ms.users.application.usecases.CreateUserUseCaseImpl;
import com.example.user_persist_ms.users.domain.ports.incoming.CreateUserUseCase;
import com.example.user_persist_ms.users.domain.ports.outgoing.UserEventPublisher;
import com.example.user_persist_ms.users.domain.ports.outgoing.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserModuleConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder, UserEventPublisher eventPublisher) {
        return new CreateUserUseCaseImpl(userRepository, passwordEncoder, eventPublisher);
    }
    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}