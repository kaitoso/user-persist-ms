package com.example.user_persist_ms.users.domain.ports.outgoing;

import com.example.user_persist_ms.users.domain.model.User;

public interface UserRepository {
    User save(User user);
}
