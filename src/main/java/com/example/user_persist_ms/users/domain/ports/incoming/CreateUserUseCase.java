package com.example.user_persist_ms.users.domain.ports.incoming;

import com.example.user_persist_ms.users.domain.model.User;

public interface CreateUserUseCase {
    User execute(User user);
}
