package com.example.user_persist_ms.users.domain.ports.outgoing;

import com.example.user_persist_ms.users.messaging.events.UserCreatedEvent;

public interface UserEventPublisher {
    void publishUserCreated(UserCreatedEvent event);
}
