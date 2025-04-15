package com.example.user_persist_ms.users.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<MongoUserEntity, String> {
}
