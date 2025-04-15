package com.example.user_persist_ms.users.messaging.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatedEvent {
    private String id;
    private String name;
    private String email;
    private String rut;
    private String avatar;
    private String role;
}
