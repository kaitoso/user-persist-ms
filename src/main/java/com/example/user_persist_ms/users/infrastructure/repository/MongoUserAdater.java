package com.example.user_persist_ms.users.infrastructure.repository;

import com.example.user_persist_ms.users.domain.model.User;
import com.example.user_persist_ms.users.domain.ports.outgoing.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MongoUserAdater implements UserRepository {
    private final MongoUserRepository mongoUserRepository;

    @Override
    public User save(User user) {
        MongoUserEntity entity = toEntity(user);
        MongoUserEntity saved = mongoUserRepository.save(entity);
        return toDomain(saved);
    }

    private MongoUserEntity toEntity(User user){
        return new MongoUserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPass(),
                user.getRut(),
                user.getAvatar(),
                user.getRole()
        );
    }
    private User toDomain(MongoUserEntity entity){
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPass(),
                entity.getRut(),
                entity.getAvatar(),
                entity.getRole()
        );
    }


}
