package com.example.user_persist_ms.users.config;


import com.example.user_persist_ms.users.application.usecases.CreateUserUseCaseImpl;
import com.example.user_persist_ms.users.domain.ports.incoming.CreateUserUseCase;
import com.example.user_persist_ms.users.domain.ports.outgoing.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserModuleConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        return new CreateUserUseCaseImpl(userRepository);
    }
}