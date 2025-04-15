package com.example.user_persist_ms.users.infrastructure.messaging;

import com.example.user_persist_ms.users.domain.ports.outgoing.UserEventPublisher;
import com.example.user_persist_ms.users.messaging.events.UserCreatedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserKafkaProducer implements UserEventPublisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${kafka.topic.user.created}")
    private String userCreatedTopic;

    @Override
    public void publishUserCreated(UserCreatedEvent event){
        try{
            String json = objectMapper.writeValueAsString(event);
            kafkaTemplate.send(userCreatedTopic, json);
            System.out.println("📤 Event published to users.created: " + json);
        } catch (Exception e) {
            System.err.println("❌ Error publishing event: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
