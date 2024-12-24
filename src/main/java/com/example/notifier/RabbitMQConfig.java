package com.example.notifier;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "alertQueue";

    @Bean
    public Queue notifierQueue() {
        return new Queue(QUEUE_NAME, false);
    }
}