package com.example.user_persist_ms.users.application.usecases;

import com.example.user_persist_ms.users.domain.model.User;
import com.example.user_persist_ms.users.domain.ports.incoming.CreateUserUseCase;
import com.example.user_persist_ms.users.domain.ports.outgoing.UserEventPublisher;
import com.example.user_persist_ms.users.domain.ports.outgoing.UserRepository;
import com.example.user_persist_ms.users.messaging.events.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;


@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserEventPublisher eventPublisher;

    @Override
    public User execute(User user) {
        String encrypted = passwordEncoder.encode(user.getPass());
        user.setPass(encrypted);
        User saved =  userRepository.save(user);

        UserCreatedEvent event = new UserCreatedEvent(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getRut(),
                saved.getAvatar(),
                saved.getRole()
        );
        eventPublisher.publishUserCreated(event);
        return saved;
    }
}
