package com.example.notifier;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotifierService {

    private final SimpMessagingTemplate messagingTemplate;

    public NotifierService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @RabbitListener(queues = "alertQueue")
    public void receiveMessage(String message) {
        System.out.println("Receved Message" + message);
        messagingTemplate.convertAndSend("/topic/toast", message);
    }
}