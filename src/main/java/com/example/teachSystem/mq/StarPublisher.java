package com.example.teachSystem.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StarPublisher {
    private static final String TASK_QUEUE_NAME = "task_queue";

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendTask(String task) {
        rabbitTemplate.convertAndSend(TASK_QUEUE_NAME, task);
        System.out.println(" [x] Sent '" + task + "'");
    }
}
