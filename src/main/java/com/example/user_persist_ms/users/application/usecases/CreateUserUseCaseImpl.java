package com.example.user_persist_ms.users.application.usecases;

import com.example.user_persist_ms.users.domain.model.User;
import com.example.user_persist_ms.users.domain.ports.incoming.CreateUserUseCase;
import com.example.user_persist_ms.users.domain.ports.outgoing.UserRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;

    @Override
    public User execute(User user) {
        return userRepository.save(user);
    }
}
