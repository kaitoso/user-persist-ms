package com.example.user_persist_ms.users.infrastructure.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MongoUserEntity {

    @Id
    private String id;
    private String name;
    private String email;
    private String pass;
    private String rut;
    private String avatar;
    private String role;

}
