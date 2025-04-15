package com.example.user_persist_ms.users.messaging.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserEvent {
    private String name;
    private String email;
    private String pass;
    private String rut;
    private String avatar;
    private String role;
}
