package com.example.user_persist_ms.users.infrastructure.messaging;

import com.example.user_persist_ms.users.domain.model.User;
import com.example.user_persist_ms.users.domain.ports.incoming.CreateUserUseCase;
import com.example.user_persist_ms.users.messaging.events.CreateUserEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserKafkaConsumer {
    private final CreateUserUseCase createUserUseCase;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${kafka.topic.user.create}", groupId = "spring.kafka.consumer.group-id")
    public void listen (ConsumerRecord<String, String> record){
        try{
            String message = record.value();
            CreateUserEvent event = objectMapper.readValue(message, CreateUserEvent.class);
            User user = new User(
                    null,
                    event.getName(),
                    event.getEmail(),
                    event.getPass(),
                    event.getRut(),
                    event.getAvatar(),
                    event.getRole()
            );

            createUserUseCase.execute(user);

            System.out.println("✅ User created from Kafka event: " + user.getEmail());

        } catch (Exception e) {
            System.err.println("❌ Error processing Kafka event: " + e.getMessage());
        }
    }
}
